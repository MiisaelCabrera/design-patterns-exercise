package oop.inheritance.impl;

import oop.inheritance.adapters.Verifone.*;
import oop.inheritance.adapters.Verifone.communication.VerifoneEthernetAdapter;
import oop.inheritance.adapters.Verifone.communication.VerifoneGPSAdapter;
import oop.inheritance.adapters.Verifone.communication.VerifoneModemAdapter;
import oop.inheritance.data.CommunicationType;
import oop.inheritance.data.EntryMode;
import oop.inheritance.interfaces.*;
import oop.library.verifone.model.ExpirationDate;


public class VerfoneFactory implements TerminalFactory {

    @Override
    public Display getDisplay() {
        return new VerifoneDisplayAdapter();
    }

    @Override
    public Keyboard getKeyboard() {
        return new VerifoneKeyboardAdapter();
    }

    @Override
    public Printer getPrinter() {
        return new VerifonePrinterAdapter();
    }

    @Override
    public GenericCard getCard(String account, GenericExpirationDate expirationDate, EntryMode entryMode) {
        oop.library.verifone.model.EntryMode verifoneEntryMode = VerifoneEntryModeAdapter.toVerifone(entryMode);
        ExpirationDate verifoneExpirationDate = new ExpirationDate(expirationDate.getYear(), expirationDate.getMoth());
        return new VerifoneCardAdapter(account, verifoneExpirationDate, verifoneEntryMode);
    }

    @Override
    public GenericCardSwipper getCardSwipper() {
        return new VerifoneCardSwipperAdapter();
    }

    @Override
    public GenericChipReader getChipReader() {
        return new VerifoneChipReaderAdapter();
    }

    @Override
    public GenericTransaction getTransaction() {
        return new VerifoneTransactionAdapter();

    }

    @Override
    public GenericTransactionResponse getTransactionResponse(boolean approved, String hostReference) {
        return new VerifoneTransactionResponseAdapter(approved, hostReference);
    }

    @Override
    public CommunicationMode getCommunicationMode(CommunicationType communicationType) {
        return switch (communicationType){
            case ETHERNET -> new VerifoneEthernetAdapter();
            case MODEM -> new VerifoneModemAdapter();
            case GPS -> new VerifoneGPSAdapter();
        };
    }


}


