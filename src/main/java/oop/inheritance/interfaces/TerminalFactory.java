package oop.inheritance.interfaces;


import oop.inheritance.data.CommunicationType;
import oop.inheritance.data.EntryMode;

public interface TerminalFactory {
    Display getDisplay();
    Keyboard getKeyboard();
    Printer getPrinter();
    GenericCard getCard(String account, GenericExpirationDate expirationDate, EntryMode entryMode);
    GenericCardSwipper getCardSwipper();
    GenericChipReader getChipReader();
    GenericTransaction getTransaction();
    GenericTransactionResponse getTransactionResponse(boolean approved, String hostReference);

    CommunicationMode getCommunicationMode(CommunicationType communicationType);
}
