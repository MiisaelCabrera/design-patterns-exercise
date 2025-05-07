package oop.inheritance.adapters.Ingenico;

import oop.inheritance.data.EntryMode;

public class IngenicoEntryModeAdapter {
    public static EntryMode fromIngenico(oop.library.ingenico.model.EntryMode ingenicoEntryMode){
        return switch(ingenicoEntryMode) {
            case SWIPED -> EntryMode.SWIPED;
        case INSERTED -> EntryMode.INSERTED;
        case MANUAL ->EntryMode.MANUAL;

        };
    }

    public static oop.library.ingenico.model.EntryMode toIngenico(EntryMode genericEntryMode){
        return switch(genericEntryMode) {
            case SWIPED -> oop.library.ingenico.model.EntryMode.SWIPED;
            case INSERTED -> oop.library.ingenico.model.EntryMode.INSERTED;
            case MANUAL -> oop.library.ingenico.model.EntryMode.MANUAL;
           };
    }
}
