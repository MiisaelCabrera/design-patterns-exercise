package oop.inheritance.interfaces;


import java.time.LocalDateTime;

public interface GenericTransaction {
    int getAmountInCents();

    void setAmountInCents(int amountInCents);

    GenericCard getCard();

    void setCard(GenericCard card);

    LocalDateTime getLocalDateTime();

    void setLocalDateTime(LocalDateTime localDateTime);
}
