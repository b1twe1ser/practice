package dev.nicorueckner.Aufgabe4;

import dev.nicorueckner.Aufgabe1.TShirt;
import dev.nicorueckner.Aufgabe2.NoDiscountException;
import dev.nicorueckner.Aufgabe2.NoTShirtException;

public interface ISale {
    public float calculatePrice(TShirt tShirt, Discount discount) throws NoTShirtException;
    public int checkDiscount(Discount discount) throws NoDiscountException;
}
