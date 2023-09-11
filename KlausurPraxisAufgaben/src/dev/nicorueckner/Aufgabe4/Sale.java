package dev.nicorueckner.Aufgabe4;

import dev.nicorueckner.Aufgabe1.TShirt;
import dev.nicorueckner.Aufgabe2.NoDiscountException;
import dev.nicorueckner.Aufgabe2.NoTShirtException;
import dev.nicorueckner.Aufgabe6.Store;

import java.time.LocalDate;

public class Sale implements ISale {
    private Store store;

    public Sale() {}
    public Store getStore() {
        return store;
    }
    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public float calculatePrice(TShirt tShirt, Discount discount) throws NoTShirtException {
        TShirt tShirtToSell = store.getTShirt(tShirt);
        float discountToApply = checkDiscount(discount);
        try {
            discountToApply = checkDiscount(discount);
        } catch (NoDiscountException e) {
            System.out.println(e.getMessage());
            return tShirt.getPrice();
        }

        return tShirt.getPrice() - tShirt.getPrice() * discountToApply;
    }

    @Override
    public int checkDiscount(Discount discount) throws NoDiscountException {
        LocalDate today = LocalDate.now();
        if (
                today.isEqual(discount.getFrom())
                        || today.isAfter(discount.getFrom())
                        && today.isBefore(discount.getTo())
                        || today.isEqual(discount.getTo())
        ) {
            return discount.getPercent();
        }
        throw new NoDiscountException("today no discount");
    }
} // end of class
