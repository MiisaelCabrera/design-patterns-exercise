package oop.inheritance.adapters.Ingenico;

import oop.inheritance.interfaces.GenericCard;
import oop.inheritance.interfaces.GenericCardSwipper;
import oop.library.ingenico.services.IngenicoCardSwipper;

public class IngenicoCardSwipperAdapter implements GenericCardSwipper {
    private final IngenicoCardSwipper cardSwipper;

    public IngenicoCardSwipperAdapter(){
        this.cardSwipper = new IngenicoCardSwipper();
    }

    @Override
    public GenericCard readCard() {
        return new IngenicoCardAdapter(cardSwipper.readCard());

    }
}
