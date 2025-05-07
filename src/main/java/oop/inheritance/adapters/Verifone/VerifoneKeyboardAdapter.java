package oop.inheritance.adapters.Verifone;

import oop.inheritance.interfaces.Keyboard;
import oop.library.v240m.VerifoneV240mKeyboard;

public class VerifoneKeyboardAdapter implements Keyboard {
    private final VerifoneV240mKeyboard verifoneV240mKeyboard;

    public VerifoneKeyboardAdapter(){
        this.verifoneV240mKeyboard = new VerifoneV240mKeyboard();
    }


    @Override
    public String getChar() {
        return verifoneV240mKeyboard.get();
    }

    @Override
    public String readLine() {
        return null;
    }
}
