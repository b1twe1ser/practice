package dev.nicorueckner.Aufgabe5;

import java.io.Serializable;
import java.util.Objects;
public class Person implements Serializable {

    private String fistName; private String lastName;
    private Address address;
    public Person(String fistName, String lastName, Address address) {
        super();
        this.fistName = fistName; this.lastName = lastName; this.address = address;
    }
    @Override
    public int hashCode() {
        return Objects.hash(address, fistName, lastName); }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        return Objects.equals(address, other.address) && Objects.equals(fistName, other.fistName)
                && Objects.equals(lastName, other.lastName);
    }
    public String getFistName() {
        return fistName; }
    public void setFistName(String fistName) {
        this.fistName = fistName; }
    public String getLastName() {
        return lastName; }
    public void setLastName(String lastName) {
        this.lastName = lastName; }
    public Address getAddress() {
        return address; }
    public void setAddress(Address address) {
        this.address = address; }

}
