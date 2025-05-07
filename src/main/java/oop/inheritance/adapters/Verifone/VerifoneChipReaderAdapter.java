package oop.inheritance.adapters.Verifone;

import oop.inheritance.interfaces.GenericCard;
import oop.inheritance.interfaces.GenericChipReader;
import oop.library.v240m.VerifoneV240mChipReader;

public class VerifoneChipReaderAdapter implements GenericChipReader {
    private final VerifoneV240mChipReader verifoneChipReader;

    public VerifoneChipReaderAdapter(){
        this.verifoneChipReader = new VerifoneV240mChipReader();
    }


    @Override
    public GenericCard readCard() {
        return new VerifoneCardAdapter(verifoneChipReader.readCard());

    }
}
