package oop.inheritance.adapters.Verifone;

import oop.inheritance.interfaces.GenericCard;
import oop.inheritance.interfaces.GenericExpirationDate;
import oop.library.verifone.model.Card;
import oop.library.verifone.model.EntryMode;
import oop.library.verifone.model.ExpirationDate;

public class VerifoneCardAdapter implements GenericCard {

    private final Card card;

    public VerifoneCardAdapter(String account, ExpirationDate expirationDate, EntryMode entryMode){
        this.card = new Card(account, expirationDate, entryMode);
    }

    public VerifoneCardAdapter(Card card){
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
        return new VerifoneExpirationDateAdapter(card.getExpirationDate());

    }

    @Override
    public oop.inheritance.data.EntryMode getEntryMode() {
        return VerifoneEntryModeAdapter.fromVerifone(card.getEntryMode());

    }
}
