package oop.inheritance.adapters.Ingenico;

import oop.inheritance.interfaces.GenericCard;
import oop.inheritance.interfaces.GenericChipReader;
import oop.library.ingenico.services.IngenicoChipReader;

public class IngenicoChipReaderAdapter implements GenericChipReader {
    private final IngenicoChipReader ingenicoChipReader;

    public IngenicoChipReaderAdapter(){
        this.ingenicoChipReader = new IngenicoChipReader();
    }


    @Override
    public GenericCard readCard() {
         return new IngenicoCardAdapter(ingenicoChipReader.readCard());

    }
}
