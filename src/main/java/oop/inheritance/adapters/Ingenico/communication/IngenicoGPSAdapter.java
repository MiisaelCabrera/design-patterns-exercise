package oop.inheritance.adapters.Ingenico.communication;

import oop.inheritance.adapters.Ingenico.IngenicoTransactionAdapter;
import oop.inheritance.adapters.Ingenico.IngenicoTransactionResponseAdapter;
import oop.inheritance.interfaces.CommunicationMode;
import oop.inheritance.interfaces.GenericTransaction;
import oop.inheritance.interfaces.GenericTransactionResponse;
import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.services.IngenicoGPS;

public class IngenicoGPSAdapter implements CommunicationMode {

    private final IngenicoGPS gps;

    public IngenicoGPSAdapter(){
        this.gps = new IngenicoGPS();
    }

    @Override
    public boolean open() {
        return gps.open();
    }

    @Override
    public boolean send(GenericTransaction transaction) {

        if(transaction instanceof IngenicoTransactionAdapter) {
            Transaction ingenicoTransaction = ((IngenicoTransactionAdapter) transaction).getTransaction();
            return gps.send(ingenicoTransaction);
        } else {
            throw new IllegalArgumentException("Unsupported card implementation");
        }
    }

    @Override
    public GenericTransactionResponse receive() {
        return new IngenicoTransactionResponseAdapter(gps.receive());

    }

    @Override
    public void close() {
        gps.close();
    }
}
