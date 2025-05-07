package oop.inheritance.adapters.Ingenico;

import oop.inheritance.interfaces.GenericCard;
import oop.inheritance.interfaces.GenericExpirationDate;
import oop.library.ingenico.model.Card;
import oop.library.ingenico.model.EntryMode;
import oop.library.ingenico.model.ExpirationDate;

public class IngenicoCardAdapter implements GenericCard {

    private final Card card;

    public IngenicoCardAdapter(String account, ExpirationDate expirationDate, EntryMode entryMode){
        this.card = new Card(account, expirationDate, entryMode);
    }

    public IngenicoCardAdapter(Card card){
        this.card = card;
    }

    public Card getIngenicoCard() {
        return card;
    }

    @Override
    public String getAccount() {
        return card.getAccount();
    }

    @Override
    public GenericExpirationDate getExpirationDate() {
        return new IngenicoExpirationDateAdapter(card.getExpirationDate());

    }

    @Override
    public oop.inheritance.data.EntryMode getEntryMode() {
        return IngenicoEntryModeAdapter.fromIngenico(card.getEntryMode());

    }
}
