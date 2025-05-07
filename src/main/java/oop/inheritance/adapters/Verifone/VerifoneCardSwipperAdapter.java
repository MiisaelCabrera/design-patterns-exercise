package oop.inheritance.adapters.Verifone;

import oop.inheritance.interfaces.GenericCard;
import oop.inheritance.interfaces.GenericCardSwipper;
import oop.library.v240m.VerifoneV240mCardSwipper;

public class VerifoneCardSwipperAdapter implements GenericCardSwipper {
    private final VerifoneV240mCardSwipper cardSwipper;

    public VerifoneCardSwipperAdapter(){
        this.cardSwipper = new VerifoneV240mCardSwipper();
    }

    @Override
    public GenericCard readCard() {
        return new VerifoneCardAdapter(cardSwipper.readCard());

    }
}
