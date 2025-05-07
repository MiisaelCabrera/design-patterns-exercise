package oop.inheritance.adapters.Ingenico;

import oop.inheritance.interfaces.Keyboard;
import oop.library.ingenico.services.IngenicoKeyboard;

public class IngenicoKeyboardAdapter implements Keyboard {
    private final IngenicoKeyboard ingenicoKeyboard;

    public IngenicoKeyboardAdapter(){
        this.ingenicoKeyboard = new IngenicoKeyboard();
    }


    @Override
    public String getChar() {
        return ingenicoKeyboard.getChar();
    }

    @Override
    public String readLine() {
        return ingenicoKeyboard.readLine();
    }
}
