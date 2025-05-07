package oop.inheritance.adapters.Ingenico;

import oop.inheritance.interfaces.Printer;
import oop.library.ingenico.services.IngenicoPrinter;

public class IngenicoPrinterAdapter implements Printer {
    private final IngenicoPrinter ingenicoPrinter;

    public IngenicoPrinterAdapter(){
        this.ingenicoPrinter = new IngenicoPrinter();
    }

    @Override
    public void print(int x, String text) {
        ingenicoPrinter.print(x, text);
    }

    @Override
    public void lineFeed() {
        ingenicoPrinter.lineFeed();
    }
}
