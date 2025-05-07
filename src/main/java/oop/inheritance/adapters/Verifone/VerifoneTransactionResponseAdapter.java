package oop.inheritance.adapters.Verifone;

import oop.inheritance.interfaces.GenericTransactionResponse;

public class VerifoneTransactionResponseAdapter implements GenericTransactionResponse {
    byte[] response;

    public VerifoneTransactionResponseAdapter(boolean approved, String hostReference){

    }

    public VerifoneTransactionResponseAdapter(byte[] response){
        this.response = response;
    }


    @Override
    public boolean isApproved() {
        return false;
    }

    @Override
    public void setApproved(boolean approved) {
    }

    @Override
    public String getHostReference() {
        return "";
    }

    @Override
    public void setHostReference(String hostReference) {
    }
}
