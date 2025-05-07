package oop.inheritance.adapters.Ingenico;

import oop.inheritance.interfaces.GenericExpirationDate;


public class IngenicoExpirationDateAdapter implements GenericExpirationDate {

    private final oop.library.ingenico.model.ExpirationDate expirationDate;

    public IngenicoExpirationDateAdapter(int year, int month){
        this.expirationDate = new oop.library.ingenico.model.ExpirationDate(year, month);
    }

    public IngenicoExpirationDateAdapter(oop.library.ingenico.model.ExpirationDate expirationDate){
        this.expirationDate = expirationDate;
    }

    @Override
    public int getYear() {
        return expirationDate.getYear();
    }

    @Override
    public int getMoth() {
        return expirationDate.getMonth();
    }
}
