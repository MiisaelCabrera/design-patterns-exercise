package oop.inheritance.interfaces;

public interface GenericTransactionResponse {

    boolean isApproved();
    void setApproved(boolean approved);
    String getHostReference();
    void setHostReference(String hostReference);
}
