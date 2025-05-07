package oop.inheritance.adapters.Verifone.communication;

import oop.inheritance.adapters.Verifone.VerifoneTransactionAdapter;
import oop.inheritance.adapters.Verifone.VerifoneTransactionResponseAdapter;
import oop.inheritance.interfaces.CommunicationMode;
import oop.inheritance.interfaces.GenericTransaction;
import oop.inheritance.interfaces.GenericTransactionResponse;
import oop.library.v240m.VerifoneV240mGPS;

public class VerifoneGPSAdapter implements CommunicationMode {

    private final VerifoneV240mGPS gps;

    public VerifoneGPSAdapter(){
        this.gps = new VerifoneV240mGPS();
    }

    @Override
    public boolean open() {
        return gps.open();
    }

    @Override
    public boolean send(GenericTransaction transaction) {

        if(transaction instanceof VerifoneTransactionAdapter) {
            byte[] verifoneTransaction = ((VerifoneTransactionAdapter) transaction).getTransaction();
            return gps.send(verifoneTransaction);
        } else {
            throw new IllegalArgumentException("Unsupported card implementation");
        }
    }

    @Override
    public GenericTransactionResponse receive() {
        return new VerifoneTransactionResponseAdapter(gps.receive());
    }

    @Override
    public void close() {
        gps.close();
    }
}
