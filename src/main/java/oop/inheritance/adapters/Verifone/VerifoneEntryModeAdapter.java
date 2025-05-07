package oop.inheritance.adapters.Verifone;

import oop.inheritance.data.EntryMode;

public class VerifoneEntryModeAdapter {
    public static EntryMode fromVerifone(oop.library.verifone.model.EntryMode verifoneEntryMode){
        return switch(verifoneEntryMode) {
            case SWIPED -> EntryMode.SWIPED;
            case INSERTED -> EntryMode.INSERTED;
            case MANUAL -> EntryMode.MANUAL;
        };
    }

    public static oop.library.verifone.model.EntryMode toVerifone(EntryMode genericEntryMode){
        return switch(genericEntryMode) {
            case SWIPED -> oop.library.verifone.model.EntryMode.SWIPED;
            case INSERTED -> oop.library.verifone.model.EntryMode.INSERTED;
            case MANUAL -> oop.library.verifone.model.EntryMode.MANUAL;
        };

    }
}
