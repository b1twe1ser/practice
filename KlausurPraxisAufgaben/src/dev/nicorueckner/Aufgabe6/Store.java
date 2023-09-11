package dev.nicorueckner.Aufgabe6;

import dev.nicorueckner.Aufgabe1.TShirt;
import dev.nicorueckner.Aufgabe2.NoTShirtException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Store {
    private List<TShirt> tShirts;

    public Store() {
        tShirts = new ArrayList<>();
    }

    public List<TShirt> gettShirts() {
        return tShirts;
    }

    @Override
    public String toString() {
        return "["
                + tShirts.stream()
                .filter(Objects::nonNull)
                .map(TShirt::toString)
                .collect(Collectors.joining(", "))
                + "]";

    }

    public boolean add(TShirt obj) {
        return tShirts.add(obj);
    }

    public boolean delete(TShirt obj) {
        return tShirts.remove(obj);
    }

    public TShirt getTShirt(TShirt obj) throws NoTShirtException {
        Objects.requireNonNull(tShirts);
        if (tShirts.contains(obj)) {
            return obj;
        }
        throw new NoTShirtException("tshirt is not availiable");
    }
}
