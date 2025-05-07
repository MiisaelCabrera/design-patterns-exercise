package oop.inheritance.interfaces;

import oop.inheritance.data.EntryMode;

public interface GenericCard {
    String getAccount();
    GenericExpirationDate getExpirationDate();

    EntryMode getEntryMode();


}
