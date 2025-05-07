package oop.inheritance.adapters.Ingenico.communication;

import oop.inheritance.adapters.Ingenico.IngenicoTransactionAdapter;
import oop.inheritance.adapters.Ingenico.IngenicoTransactionResponseAdapter;
import oop.inheritance.interfaces.CommunicationMode;
import oop.inheritance.interfaces.GenericTransaction;
import oop.inheritance.interfaces.GenericTransactionResponse;
import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.services.IngenicoModem;

public class IngenicoModemAdapter implements CommunicationMode {

    private final IngenicoModem modem;

    public IngenicoModemAdapter(){
        this.modem = new IngenicoModem();
    }

    @Override
    public boolean open() {
        return modem.open();
    }

    @Override
    public boolean send(GenericTransaction transaction) {

        if(transaction instanceof IngenicoTransactionAdapter) {
            Transaction ingenicoTransaction = ((IngenicoTransactionAdapter) transaction).getTransaction();
            return modem.send(ingenicoTransaction);
        } else {
            throw new IllegalArgumentException("Unsupported card implementation");
        }
    }

    @Override
    public GenericTransactionResponse receive() {
        return new IngenicoTransactionResponseAdapter(modem.receive());

    }

    @Override
    public void close() {
        modem.close();
    }
}
