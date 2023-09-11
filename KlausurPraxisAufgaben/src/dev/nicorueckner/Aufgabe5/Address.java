package dev.nicorueckner.Aufgabe5;

import java.io.Serializable;
import java.util.Objects;

public class Address implements Serializable {
    private String street;
    private String postCode;
    private String town;

    public Address(String street, String postCode, String town) {
        super();
        this.street = street; this.postCode = postCode; this.town = town;
    }
    @Override
    public int hashCode() {
        return Objects.hash(postCode, street, town); }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Address other = (Address) obj;
        return Objects.equals(postCode, other.postCode) && Objects.equals(street, other.street)
                && Objects.equals(town, other.town);
    }
    public String getStreet() {
        return street; }
    public void setStreet(String street) {
        this.street = street; }
    public String getPostCode() {
        return postCode; }
    public void setPostCode(String postCode) {
        this.postCode = postCode; }
    public String getTown() {
        return town; }
    public void setTown(String town) {
        this.town = town; }
}
