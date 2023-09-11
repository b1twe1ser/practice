# Exercises done

---
- [x] Aufgabe 1
- [x] Aufgabe 2
- [x] Aufgabe 3
- [x] Aufgabe 4
- [x] Aufgabe 5
- [x] Aufgabe 6

# Notes

---
## Aufgabe 1
#### Natuerliche Ordnung
Basierend auf `brand` Feld
```java
enum Size {
    EXTRA_SMALL, SMALL
}

class Pullover implements Comparable<Pullover> {
    String brand;
    Size size;
    
    public Pullover(Brand brand, Size size) {
        this.brand = brand;
        this.size = size;
    }
    
    @Override
    public int compareTo(Pullover pullover) {
        return brand.compareTo(pullover.brand);
    }
}
```
Jetzt kann "natuerlich" sortiert werden via

```java
import java.util.ArrayList;
import java.util.Collections;

class Main() {
    public static void main(String[] args) {
        Pullover nicosPullover = new Pullover("Addidas", Size.SMALL);
        Pullover elifsPullover = new Pullover("Bershka", Size.EXTRA_SMALL);

        List<Pullover> pullovers = new ArrayList<>(List.of(elifsPullover, nicosPullover));
        Collections.sort(pullovers); 
    }
}
```

**Outcome:** `[nicosPullover, elifsPullover]`

##### Zusaetzliche Ordnung

Basierend auf `Size`

```java
import java.util.Comparator;

class Pullover implements Comparable<Pullover> {
    String brand;
    Size size;

    public Pullover(Brand brand, Size size) {
        this.brand = brand;
        this.size = size;
    }

    public static Comparator<Pullover> sortSize() {
        
        // with lambda expression
        return (pullover1, pullover2) -> pullover1.size.compareTo(pullover2.size);
        
        // without lambda expression
        // return Comparator.comparing(Pullover::size);
    }
}
```
Jetzt kann zusaetzlich nach `size` sortiert werden

```java
import java.util.ArrayList;

class Main() {
    public static void main(String[] args) {
        Pullover pulloverBoiIt = new Pullover("A", Size.XL);
        Pullover pulloverGirlIt = new Pullover("B", Size.S);

        List<Pullover> pullovers = new ArrayList<>(List.of(shirtBoiIt, shirtGirlIt));

        pullovers.sort(Pullover.sortSize());
        System.out.println(pullovers);
    }
}
```

**Outcome:** `[pulloverGirlIt, PulloverBoiIt]`

---

## Aufgabe 2
#### Exceptions

Unchecked Exception

```java
public class NoDiscountException extends RuntimeException {
    public NoDiscountException() {
        super();
    }
    
    public NoDiscountException(String message) {
        super(message);
    }
}
```

Unchecked da _runtime_ exception. Also kann waehrend Laufzeit auftreten

Checked Exception

```java
public class NoPulloverException extends Exception {
    public NoPulloverException() {
        super();
    }
    
    public NoPulloverException(String message) {
        super(message);
    }
}
```

Checkt da keine `RuntimeException` sondern `Exception`

---

## Aufgabe 3
#### Innere Klassen und GUI

```java

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 * Aufgabe 3
 * Inner class and GUI (kinda)
 */
public class Controller {
    private JButton clickMe;
    private JTextField text;

    // Inner Class
    class MyClick implements ActionListener {
        // Setting Text to Success!
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            text.setText("Success!");
        }
    }

    /*
    Constructor
     */
    public Controller(JButton clickMe, JTextField text) {
        this.clickMe = clickMe;

        // attaching the inner class to the button
        this.clickMe.addActionListener(new MyClick());
        this.text = text;
    }

    /*
    Getter and Setter
     */
    public JButton getClickMe() {
        return clickMe;
    }
    public void setClickMe(JButton clickMe) {
        this.clickMe = clickMe;
    }
    public JTextField getText() {
        return text;
    }
    public void setText(JTextField text) {
        this.text = text;
    }
} // end of class
```
Hier kreieren wir eine innere Klasse names `MyClick`, welche einen `ActionListener` implementiert.
Diese wird dann im Constructor an den Button gehängt. 

---
## Aufgabe 4
#### Interfaces und ErrorHandling

**Sale**
```java

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
```
**Sale Interface**
```java
public interface ISale {
    public float calculatePrice(TShirt tShirt, Discount discount) throws NoTShirtException;
    public int checkDiscount(Discount discount) throws NoDiscountException;
}
```

**Discount**
```java

import java.time.LocalDate;
import java.util.Objects;

public class Discount {
    private LocalDate from;
    private LocalDate to;
    private int percent;

    public Discount() {
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(from);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Discount other = (Discount) obj;
        return Objects.equals(from, other.from)
                && Objects.equals(to, other.to)
                && Objects.equals(percent, other.percent);
    }
    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
}
```
---

## Aufgabe 5
#### ObjectSerializer

Zum Serialisieren eines Objects, muss das Object serialisierbar sein,  
dazu dient das Interface `Serializable`. Dies kann wie folgt implementiert werden.

```java

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
```
Im Grunde muss in diesem Schritt nichts weiter getan werden, da `Serializable` keine abstrakten Methoden   
besitzt. 

Der Vollstaendigkeit halber, hier noch die weitere Klasse.
```java
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
```

Hier musste ebenfalls lediglich das Interface `Serializable` implementiert werden.  
Da die Klasse allerdings auch eine `Address` beinhaltet, musste auch diese Type  
wie oben gesehen, auch das Interface implementieren.

**Der Serialisierer**
```java

import java.io.*;
import java.util.Objects;

public class PersonSerializier {
    private ObjectInputStream is;
    private ObjectOutputStream os;

    public PersonSerializier() {
        is = null;
        os = null;
    }
    public void initOutput(String file) throws IOException, NullPointerException {
        Objects.requireNonNull(file, "file must not be null");
        os = new ObjectOutputStream(new FileOutputStream(file));
    }

    public void initInput(String file) throws IOException, NullPointerException {
        Objects.requireNonNull(file, "file must not be null");
        is = new ObjectInputStream(new FileInputStream(file));
    }

    public void serializePerson(Person person) throws IOException {
        os.writeObject(person);
    }

    public Person deserializePerson() throws IOException, ClassNotFoundException {
        return (Person) is.readObject();
    }

    public void closeOutput() throws IOException {
        os.close();
    }

    public void closeInput() throws IOException {
        is.close();
    }

}
```

Die Klasse `PersonSerializier` hat einen `OutputStream` und einen `InputStream`.  
Diese werden im Konstruktor erzeugt und in den methoden `initOutpu()` bzw `initInput()`  
initialisiert.

---

## Aufgabe 6
#### CollectionAPI

Die CollectionAPI mit eigenen Datentypen nutzen
```java
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
```