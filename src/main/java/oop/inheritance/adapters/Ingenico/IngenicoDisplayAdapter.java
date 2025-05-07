package oop.inheritance.adapters.Ingenico;

import oop.inheritance.interfaces.Display;
import oop.library.ingenico.services.IngenicoDisplay;

public class IngenicoDisplayAdapter implements Display {
    private final IngenicoDisplay ingenicoDisplay;

    public IngenicoDisplayAdapter(){
        this.ingenicoDisplay = new IngenicoDisplay();
    }

    @Override
    public void showMessage(int x, int y, String message) {
        ingenicoDisplay.showMessage(x, y, message);
    }

    @Override
    public void clear() {
        ingenicoDisplay.clear();
    }
}
