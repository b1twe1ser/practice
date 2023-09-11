package dev.nicorueckner.Aufgabe1;

import java.util.Comparator;
import java.util.Objects;

/**
Aufgabe 1
TShirt Class

Comparable natural order:
    Implement Comparable Interface
    Implement compareTo() methode

Comparator zusaetzliche Order:
    Implement Comparable Interface
    Implement sortSize(): Comparator<T> methode
 */
public class TShirt implements Comparable<TShirt> {
    private String brand;
    private Size size;
    private float price;
    /*
    CONSTRUCTOR
     */


    public TShirt(String brand, Size size, float price) {
        this.brand = brand;
        this.size = size;
        this.price = price;
    }
    public TShirt(String brand, Size size) {
        this(brand, size, 0f);
    }

    public TShirt() {
        this(null, null);
    }

    /*
    GETTER AND SETTER
     */
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public Size getSize() {
        return size;
    }
    public void setSize(Size size) {
        this.size = size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;

        TShirt other = (TShirt) obj;
        return Objects.equals(brand, other.getBrand())
                && Objects.equals(size, other.getSize());
    }

    /**
    This method is just for me
    to check what the code is doing
    and be able to print my T-Shirt array
     */
    @Override
    public String toString() {
        return "(Tshirt: "
                + brand
                + ", "
                + size
                +")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, size, price);
    }

    /**
    Natural order,
    based on brandname,
    not my first choice but whatever 🍑

    Called like this
    `Collections.sort(collection)`
     */
    @Override
    public int compareTo(TShirt tShirt) {
        Objects.requireNonNull(tShirt, "tShirt must not be null");
        Objects.requireNonNull(tShirt.getBrand(), "brand must not be null");
        return this.brand.compareTo(tShirt.getBrand());
    }

    /**
    Zuesaetzliche Order
    based on size

    Called like this
    `Collections.sort(collection, TShirt.sortSize())`
     */
    public static Comparator<TShirt> sortSize() {
        return (tShirt1, tShirt2) -> tShirt1.getSize().compareTo(tShirt2.getSize());
        // return Comparator.comparing(TShirt::getSize); the better way, but we need lambda
    }
} // end of class
