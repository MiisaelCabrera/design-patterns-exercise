package oop.inheritance;

import java.time.LocalDateTime;

import oop.inheritance.data.CommunicationType;
import oop.inheritance.data.SupportedTerminal;
import oop.inheritance.impl.IngenicoFactory;
import oop.inheritance.impl.VerfoneFactory;
import oop.inheritance.interfaces.*;

public class Application {

    private CommunicationType communicationType = CommunicationType.ETHERNET;
    private SupportedTerminal supportedTerminal;

    private TerminalFactory terminalFactory;

    public Application(SupportedTerminal supportedTerminal) {
        this.supportedTerminal = supportedTerminal;
    }
    public Application(SupportedTerminal supportedTerminal, CommunicationType communicationType) {
        this.communicationType = communicationType;

        terminalFactory = switch (supportedTerminal){
            case INGENICO-> new IngenicoFactory();

            case VERIFONE -> new VerfoneFactory();

        };

    }


    public void showMenu() {

        Display display = terminalFactory.getDisplay();

        display.showMessage(5, 5, "MENU");
        display.showMessage(5, 10, "1. VENTA");
        display.showMessage(5, 13, "2. DEVOLUCION");
        display.showMessage(5, 16, "3. REPORTE");
        display.showMessage(5, 23, "4. CONFIGURACION");

    }

    public String readKey() {
        Keyboard keyboard = terminalFactory.getKeyboard();

        return keyboard.getChar();
    }

    public void doSale() {
        GenericCardSwipper cardSwipper = terminalFactory.getCardSwipper();
        GenericChipReader chipReader = terminalFactory.getChipReader();
        Display display = terminalFactory.getDisplay();
        Keyboard keyboard = terminalFactory.getKeyboard();
        GenericCard card;


        do {
            card = cardSwipper.readCard();
            if (card == null) {
                card = chipReader.readCard();
            }
        } while (card == null);

        display.clear();
        display.showMessage(5, 20, "Capture monto:");

        String amount = keyboard.readLine(); //Amount with decimal point as string

        GenericTransaction transaction = terminalFactory.getTransaction();

        transaction.setLocalDateTime(LocalDateTime.now());
        transaction.setCard(card);
        transaction.setAmountInCents(Integer.parseInt(amount.replace(".", "")));

        GenericTransactionResponse response= sendSale(transaction);

        if (response.isApproved()) {
            display.showMessage(5, 25, "APROBADA");
            printReceipt(transaction);
        } else {
            display.showMessage(5, 25, "DENEGADA");
        }
    }

    private void printReceipt(GenericTransaction transaction) {

        Printer printer = terminalFactory.getPrinter();
        //?
        GenericCard card = transaction.getCard();

        printer.print(5, "APROBADA");
        printer.lineFeed();
        printer.print(5, card.getAccount());
        printer.lineFeed();
        printer.print(5, "" + transaction.getAmountInCents());
        printer.lineFeed();
        printer.print(5, "________________");

    }
    private GenericTransactionResponse sendSale(GenericTransaction transaction) {

        CommunicationMode communicationMode = terminalFactory.getCommunicationMode(communicationType);
        communicationMode.open();
        communicationMode.send(transaction);
        GenericTransactionResponse transactionResponse = communicationMode.receive();
        communicationMode.close();

        return transactionResponse;
    }

    public void doRefund() {
    }

    public void printReport() {
    }

    public void showConfiguration() {
    }

    public void clearScreen() {
        Display display = terminalFactory.getDisplay();

        display.clear();

    }
}
