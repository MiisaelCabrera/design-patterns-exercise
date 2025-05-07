package oop.inheritance.adapters.Verifone;

import oop.inheritance.interfaces.GenericCard;
import oop.inheritance.interfaces.GenericTransaction;

import java.time.LocalDateTime;

public class VerifoneTransactionAdapter implements GenericTransaction {
    private byte[] transaction ;

    public VerifoneTransactionAdapter(){

    }

    @Override
    public int getAmountInCents() {
        return 0;
    }

    @Override
    public void setAmountInCents(int amountInCents) {

    }

    @Override
    public GenericCard getCard() {
        return null;
    }

    @Override
    public void setCard(GenericCard card) {

    }

    @Override
    public LocalDateTime getLocalDateTime() {
        return LocalDateTime.now();
    }

    @Override
    public void setLocalDateTime(LocalDateTime localDateTime) {

    }

    public byte[] getTransaction() {
        return transaction;
    }
}
