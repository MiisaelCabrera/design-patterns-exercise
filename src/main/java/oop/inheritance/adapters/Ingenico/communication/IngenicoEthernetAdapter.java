package oop.inheritance.adapters.Ingenico.communication;

import oop.inheritance.adapters.Ingenico.IngenicoTransactionAdapter;
import oop.inheritance.adapters.Ingenico.IngenicoTransactionResponseAdapter;
import oop.inheritance.interfaces.CommunicationMode;
import oop.inheritance.interfaces.GenericTransaction;
import oop.inheritance.interfaces.GenericTransactionResponse;
import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.services.IngenicoEthernet;

public class IngenicoEthernetAdapter implements CommunicationMode {

    private final IngenicoEthernet ethernet;

    public IngenicoEthernetAdapter(){
        this.ethernet = new IngenicoEthernet();
    }

    @Override
    public boolean open() {
        return ethernet.open();
    }

    @Override
    public boolean send(GenericTransaction transaction) {

        if(transaction instanceof IngenicoTransactionAdapter) {
            Transaction ingenicoTransaction = ((IngenicoTransactionAdapter) transaction).getTransaction();
            return ethernet.send(ingenicoTransaction);
        } else {
            throw new IllegalArgumentException("Unsupported card implementation");
        }
    }

    @Override
    public GenericTransactionResponse receive() {
        return new IngenicoTransactionResponseAdapter(ethernet.receive());

    }

    @Override
    public void close() {
        ethernet.close();
    }
}
