package oop.inheritance.adapters.Ingenico;

import oop.inheritance.interfaces.GenericTransactionResponse;
import oop.library.ingenico.model.TransactionResponse;

public class IngenicoTransactionResponseAdapter implements GenericTransactionResponse {
    private final TransactionResponse response;

    public IngenicoTransactionResponseAdapter(boolean approved, String hostReference){
        this.response = new TransactionResponse(approved, hostReference);
    }

    public IngenicoTransactionResponseAdapter(TransactionResponse response){
        this.response = response;
    }


    @Override
    public boolean isApproved() {
        return response.isApproved();
    }

    @Override
    public void setApproved(boolean approved) {
        response.setApproved(approved);
    }

    @Override
    public String getHostReference() {
        return response.getHostReference();
    }

    @Override
    public void setHostReference(String hostReference) {
        response.setHostReference(hostReference);
    }
}
