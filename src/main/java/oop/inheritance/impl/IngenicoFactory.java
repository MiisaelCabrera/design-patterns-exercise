package oop.inheritance.impl;

import oop.inheritance.adapters.Ingenico.*;
import oop.inheritance.adapters.Ingenico.communication.IngenicoEthernetAdapter;
import oop.inheritance.adapters.Ingenico.communication.IngenicoGPSAdapter;
import oop.inheritance.adapters.Ingenico.communication.IngenicoModemAdapter;
import oop.inheritance.data.CommunicationType;
import oop.inheritance.data.EntryMode;
import oop.inheritance.interfaces.*;
import oop.library.ingenico.model.ExpirationDate;

public class IngenicoFactory implements TerminalFactory {

    @Override
    public Display getDisplay() {
        return new IngenicoDisplayAdapter();
    }

    @Override
    public Keyboard getKeyboard() {
        return new IngenicoKeyboardAdapter();
    }

    @Override
    public Printer getPrinter() {
        return new IngenicoPrinterAdapter();
    }

    @Override
    public GenericCard getCard(String account, GenericExpirationDate expirationDate, EntryMode entryMode) {
        oop.library.ingenico.model.EntryMode ingenicoEntryMode = IngenicoEntryModeAdapter.toIngenico(entryMode);
        ExpirationDate ingenicoExpirationDate = new ExpirationDate(expirationDate.getYear(), expirationDate.getMoth());
        return new IngenicoCardAdapter(account, ingenicoExpirationDate, ingenicoEntryMode);
    }

    @Override
    public GenericCardSwipper getCardSwipper() {
        return new IngenicoCardSwipperAdapter();
    }

    @Override
    public GenericChipReader getChipReader() {
        return new IngenicoChipReaderAdapter();
    }

    @Override
    public GenericTransaction getTransaction() {
        return new IngenicoTransactionAdapter();
    }

    @Override
    public GenericTransactionResponse getTransactionResponse(boolean approved, String hostReference) {
        return new IngenicoTransactionResponseAdapter(approved, hostReference);
    }

    @Override
    public CommunicationMode getCommunicationMode(CommunicationType communicationType) {
        return switch (communicationType){
            case ETHERNET -> new IngenicoEthernetAdapter();
            case MODEM -> new IngenicoModemAdapter();
            case GPS -> new IngenicoGPSAdapter();
        };
    }


}
