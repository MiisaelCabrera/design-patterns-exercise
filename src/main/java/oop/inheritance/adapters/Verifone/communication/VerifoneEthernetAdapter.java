package oop.inheritance.adapters.Verifone.communication;

import oop.inheritance.adapters.Verifone.VerifoneTransactionAdapter;
import oop.inheritance.adapters.Verifone.VerifoneTransactionResponseAdapter;
import oop.inheritance.interfaces.CommunicationMode;
import oop.inheritance.interfaces.GenericTransaction;
import oop.inheritance.interfaces.GenericTransactionResponse;
import oop.library.v240m.VerifoneV240mEthernet;

public class VerifoneEthernetAdapter implements CommunicationMode {

    private final VerifoneV240mEthernet ethernet;

    public VerifoneEthernetAdapter(){
        this.ethernet = new VerifoneV240mEthernet();
    }

    @Override
    public boolean open() {
        return ethernet.open();
    }

    @Override
    public boolean send(GenericTransaction transaction) {

        if(transaction instanceof VerifoneTransactionAdapter) {
            byte[] verifoneTransaction = ((VerifoneTransactionAdapter) transaction).getTransaction();
            return ethernet.send(verifoneTransaction);
        } else {
            throw new IllegalArgumentException("Unsupported card implementation");
        }
    }

    @Override
    public GenericTransactionResponse receive() {
      return new VerifoneTransactionResponseAdapter(ethernet.receive());

    }

    @Override
    public void close() {
        ethernet.close();
    }
}
