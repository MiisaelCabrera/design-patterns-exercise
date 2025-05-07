package oop.inheritance.adapters.Ingenico;

import oop.inheritance.interfaces.GenericCard;
import oop.inheritance.interfaces.GenericTransaction;
import oop.library.ingenico.model.Card;
import oop.library.ingenico.model.Transaction;

import java.time.LocalDateTime;

public class IngenicoTransactionAdapter implements GenericTransaction {
    private final Transaction transaction;

    public IngenicoTransactionAdapter(){
        this.transaction = new Transaction();
    }

    @Override
    public int getAmountInCents() {
        return transaction.getAmountInCents();
    }

    @Override
    public void setAmountInCents(int amountInCents) {
        transaction.setAmountInCents(amountInCents);
    }

    @Override
    public GenericCard getCard() {
        return new IngenicoCardAdapter(transaction.getCard());
    }

    @Override
    public void setCard(GenericCard card) {
        if (card instanceof IngenicoCardAdapter) {
            Card ingenicoCard = ((IngenicoCardAdapter) card).getIngenicoCard();
            transaction.setCard(ingenicoCard);
        } else {
            throw new IllegalArgumentException("Unsupported card implementation");
        }
    }

    @Override
    public LocalDateTime getLocalDateTime() {
        return transaction.getLocalDateTime();
    }

    @Override
    public void setLocalDateTime(LocalDateTime localDateTime) {
        transaction.setLocalDateTime(localDateTime);
    }

    public Transaction getTransaction() {
        return transaction;
    }
}
