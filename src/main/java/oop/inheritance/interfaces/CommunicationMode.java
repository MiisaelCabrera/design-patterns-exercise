package oop.inheritance.interfaces;

public interface CommunicationMode {
    boolean open();
    boolean send(GenericTransaction transaction);
    GenericTransactionResponse receive();
    void close();

}
