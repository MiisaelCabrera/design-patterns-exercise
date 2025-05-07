package oop.inheritance.adapters.Verifone;

import oop.inheritance.interfaces.Printer;
import oop.library.v240m.VerifoneV240mPrinter;

public class VerifonePrinterAdapter implements Printer {
    private final VerifoneV240mPrinter verifoneV240mPrinter;

    public VerifonePrinterAdapter(){
        this.verifoneV240mPrinter = new VerifoneV240mPrinter();
    }

    @Override
    public void print(int x, String text) {
        verifoneV240mPrinter.print(x, text);
    }

    @Override
    public void lineFeed() {
        verifoneV240mPrinter.lineFeed();
    }
}
