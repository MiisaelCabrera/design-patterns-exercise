package oop.inheritance.adapters.Verifone;

import oop.inheritance.interfaces.GenericExpirationDate;


public class VerifoneExpirationDateAdapter implements GenericExpirationDate {

    private final oop.library.verifone.model.ExpirationDate expirationDate;

    public VerifoneExpirationDateAdapter(int year, int month){
        this.expirationDate = new oop.library.verifone.model.ExpirationDate(year, month);
    }

    public VerifoneExpirationDateAdapter(oop.library.verifone.model.ExpirationDate expirationDate){
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
