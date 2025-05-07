package oop.inheritance.adapters.Verifone;

import oop.inheritance.interfaces.Display;
import oop.library.v240m.VerifoneV240mDisplay;

public class VerifoneDisplayAdapter implements Display {
    private final VerifoneV240mDisplay verifoneV240mDisplay;

    public VerifoneDisplayAdapter(){
        this.verifoneV240mDisplay = new VerifoneV240mDisplay();
    }

    @Override
    public void showMessage(int x, int y, String message) {
        verifoneV240mDisplay.print(x, y, message);
    }

    @Override
    public void clear() {
        verifoneV240mDisplay.clear();
    }
}
