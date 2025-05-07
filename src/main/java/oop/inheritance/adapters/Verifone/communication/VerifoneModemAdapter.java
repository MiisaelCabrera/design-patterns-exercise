package oop.inheritance.adapters.Verifone.communication;

import oop.inheritance.adapters.Verifone.VerifoneTransactionAdapter;
import oop.inheritance.adapters.Verifone.VerifoneTransactionResponseAdapter;
import oop.inheritance.interfaces.CommunicationMode;
import oop.inheritance.interfaces.GenericTransaction;
import oop.inheritance.interfaces.GenericTransactionResponse;
import oop.library.v240m.VerifoneV240mModem;

public class VerifoneModemAdapter implements CommunicationMode {

    private final VerifoneV240mModem modem;

    public VerifoneModemAdapter(){
        this.modem = new VerifoneV240mModem();
    }

    @Override
    public boolean open() {
        return modem.open();
    }

    @Override
    public boolean send(GenericTransaction transaction) {

        if(transaction instanceof VerifoneTransactionAdapter) {
            byte[] verifoneTransaction = ((VerifoneTransactionAdapter) transaction).getTransaction();
            return modem.send(verifoneTransaction);
        } else {
            throw new IllegalArgumentException("Unsupported card implementation");
        }
    }

    @Override
    public GenericTransactionResponse receive() {
        return new VerifoneTransactionResponseAdapter(modem.receive());

    }

    @Override
    public void close() {
        modem.close();
    }
}
