# Aufgaben

## Konstruktoren
1. Der Constructor dient der Initialisierung der Instanzvariablen
2. Durch den Aufruf eines Constructors hinter `new` wird eine Instanz angelegt und initialisiert
3. Mit dem Initialisierungskonstruktor sollen alle Instanzvariablen initialisierbar sein
4. Ein Konstruktor kann einen anderen Konstruktor der selben Klasse via `this` aufrufen

---

## Objektreferenzen
**gegeben:**

```java
import java.util.Objects;

@Override
public class ExamClass {
    public String name;
    
    public ExamClass(String name) {
        this.name = name;
    }
    
    public ExamClass() {
        this(null);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        ExamClass other = (ExamClass) obj;
        return Objects.equals(name, other.name);
    }
}
```

Die Methode wird wie folgt aufgerufen
```java
public class Main {
    public static void main(String[] args) {
        ExamClass e1, e2;
        e1 = new ExamClass("Peter");
        e2 = new ExamClass("JAck");
        
        e1.equals(e2);
    }
}
```
Welche Objektreferenz des obigen Aufrufs wird in welcher lokalen Variablen gespeichert ?  
`obj` hat die **Objektreferenz zu e2**. `this` hat die **Objektreferenz zu e1**. und `other` kann die **Objecktreferenz zu `obj`** enthalten.

---
 ## Gleichheit vs Identitaet

1. Gleiche Objekte koennen mit einer nach dem Contract ueberschriebenen `equals` methode  verglichen werden, um deren Gleicheit festzustellen.
2. Identische Objekte koennen mit einer nach dem Contract ueberschriebenen `equals` methode  vergelichen werden, um deren Identitatet festzustellen.
3. Identische Objekte koenne mit der von `Object` geerbten `equals` methode verglichen werden,  um deren Identitatet festzustellen
4. Identische Objekte koennen mit dem Vergleichsoperator verglichen werden, um deren Identitaet festzustellen.

---
## Vererbung

![mermaid-diagram-2023-09-10-141151.svg](..%2F..%2F..%2F..%2F..%2F..%2F..%2FDownloads%2Fmermaid-diagram-2023-09-10-141151.svg)

Hier sieht die Vererbungshierarchie wie folgt aus:  
Class1 -> Class2 -> Class3  
Class1 -> Class4

---
 ## Zugriffsmodifizierer
Gegeben ist der folgende code 
```java
package demo;

public class A {
    private int att1 = 1;
    int att2 = 2;
    protected int att3 = 3;
    public int att4 = 4;
    
    public void print() {
        System.out.print("A: ");
        System.out.print(att1 + " ");
        System.out.print(att2 + " ");
        System.out.print(att3 + " ");
        System.out.print(att4 + " ");
    }
}
```

```java
package otherDemo;
import demo.A;

public class B extends A {
    private int att1 = 5;
    
    public void print() {
        System.out.print("A: ");
        System.out.print(att1 + " ");
        System.out.print(att2 + " ");
        System.out.print(att3 + " ");
        System.out.print(att4 + " ");       
    }    
}
```
Was laueft schief ?
- lediglich `System.out.print(att2);` wird nicht akzeptiert werden.

Warum ?  

| **Public**                         | **Protected**                                                        | **Private**                         | **Default**                                                                          |
|------------------------------------|----------------------------------------------------------------------|-------------------------------------|--------------------------------------------------------------------------------------|
| Can be accessed from _any_ package | Can be accessed _within_ package or _childclass_ outside the package | Can be accessed only _within class_ | Default is **public** in the **same package** and **private** in **outside package** |

Da `B` `att1` aber ueberschreibt, koennen wir es wieder verwenden, somit ist nur `private` modifyer problematisch

---

## Abstrakte Klasse
1. Abstarkte Methoden werden mit dem keyword `abstract` deklariert
2. Konkrete, von abstarkten Klassen abgeleitete Klassen muessen allle geerbten abstarkten Methoden implementieren.
3. Abstrakte Klassen koennen nicht instantiiert werden.
4. Abstrakte Klasen koennen mit dem Schluesselwort final deklariert werden

---

## Ueberschreiben Mehtoden
1. Vor dem Kopf der ueberschriebenen Methode kann `@Override` eingefuegt werden,  um zu pruefen, ob von der uebergeordneten Klasse eine Mehtode ueberschrieben wird
2. Die Signaturen der ueberschriebenen und der ueberschreibenden Methode sollten identisch sein.  Unterschiede sind in der Sichtbarkeit und dem Rueckgabetyp basierend auf bestimmten Regelungen moeglich
3. In der ueberschreibenden Mehtode kann die uberschriebene Mehtode via `super.method()` aufgerufen werde
4. Durch das Ueberschreiben von Methoden wird das Prinzip der Polymorphie in Klassenhiereachie umgesetzt
5. Im Normalfall unterscheiden sich der Methodenrumpf der ueberschriebenen Methode und der ueberschreibenden Methode

---

## Type Subtype

![mermaid-diagram-2023-09-10-143804.svg](..%2F..%2F..%2F..%2F..%2F..%2F..%2FDownloads%2Fmermaid-diagram-2023-09-10-143804.svg)

- Gemaess dem Diagramm **ueberschreibt** die Methode `methode()` der Klasse `SubClass` die Methode `methode()` der Klasse Class
- Es handelt sich um **Polymorphie**. Das word bei der umsetzung in Java als **dynamische Bindung** realisiert.
- In java **erfolgt die Auswahl der Methode zur Laufzeit**

---

## Interfaces
Interface `I1` implementieren die default Methode `m`. Interface `I2` implementieren ebenfalls die default Methode `m`.   Die Signaturen der Methoden sind gleich. Beide Interfaces stehen in keiner Beziehung zu einander. Die Klasse `Class` implementiert sowohl `I1` als auch `I2`.  

Welche Methode(n) erbt `Class`?

→ Beide Methoden von `m`

---

## CollectionAPI
- Welchen grundlegenden typ der collectionapi wuerden sie waehlen, wenn ein Zugriff ohne Schluessel erfolgen soll und Duplikate nicht erlaubt sind ?  
    → `java.util.Set`
- Welchen grundlegenden typ der collectionapi wuerden sie waehlen, wenn ein Zugriff mit schluessel erfolgen soll ?   
    → `java.util.Map`
- Welchen grundlegenden Typ der Collection API würden Sie wählen, wenn ein Zugriff ohne Schlüssel erfolgen soll und Duplikate erlaubt sind ?  
    → `java.util.List`
- Welchen konkreten Typ der Collection API würden Sie wählen, wenn ein Zugriff ohne Schlüssel erfolgen soll und Duplikate erlaubt sind und
  das Einfügen/Löschen schnell sein soll ?  
    → `java.util.LinkedList`
- Welchen konkreten Typ der Collection API würden Sie wählen, wenn ein Zugriff ohne Schlüssel erfolgen soll und Duplikate erlaubt sind und
  der Zugriff schnell sein soll ?   
    → `java.util.ArrayList`

---

## Random Stuff

`char[] c = new char[2];`  
`ArrayList I = new ArrayList();`  
`int length = c.length + I.size();`

---

## Comparable/Comparator
Objekte in der Collection API können verglichen werden, um sie in einer sortierbaren Collection zu sortieren. Hierfür gibt es die Möglichkeit,  
- ... dass die zu sortierenden Objekte `Comparable` implementieren und so eine fuer die Objekte natuerliche Ordnung definieren.
- ... dass die sortierebare Collection eine Implementierung von `Comparator` besitzt und so eine zusateliche Ordnung definiert.

---

## ArrayList

`ArrayList<Integer> lits;` type

- `for (int k = 0; k < list.size(); k++) System.out.println(list.get(k));`
- `for(var o: list) System.out.println(o);`
- `for (Iterator<Integer> e = list.iterator();e.hasNext();) System.out.println(e.next());`
- `for(Integer o: list) System.out.println(o);`
- `for (Iterator e = list.iterator();e.hasNext();) System.out.println(e.next())`

---

## Try Catch

Gegeben ist der folgende Programmcode, in dem eine java.lang.ArithmeticException geworfen wird. Fangen Sie die Exception so ab, dass die folgende Ausgabe entsteht. Füllen Sie alle nicht benötigten Felder mit einem Kommentar ("//").
Ausgabe:

-1
-2
Abgefangen: / by zero 2
1

Loesung:
```java
public class Division {
    public static void main(String[] args) {
        for (int i = -2; i < 3; i++) {
            try {
                System.out.println(2/i);
            } catch (ArithmeticException e) {
                System.out.println("Abgefangen: " + e.getMessage());
            }
        }
    }
}
```

---

## Try Catch

Füllen Sie die leeren Felder so aus, dass der Code compiliert.

```java
public class Divison {
    public void ohNo(ArithmeticException ae) throws Exception {
        if (ae == null) 
            throw new Exception();
        else 
            throw ae;
    }
}
```

---

## Throw
Was kann anstelle von `//INSERT CODE HERE` eingefügt werden, so dass kein Compiler-Fehler auftritt?

```java
class ThrowStuff {
    public void whatHappensNext() throws IOException { 
        // INSERT CODE HERE
    } 
}
```

- `throw new IllegalArgumentException();`  
- `throw new RuntimeException();`

---

## Enums
Gegeben ist folgender Programmcode für eine Enumeration (einen Aufzählungstyp):

```java
public enum Day {MON, TUE, WED, THUR, FRI, SAT, SUN}
```

- Ist der Code vollstaendig ? JA
- In welcher Datei sollte der Code gespeichert werden ? Day.java
- `MON` ist vom Datentyp ? `Day`
- Wie kann bei einer Werzuweisung auf `MON` von einer anderen Klasse aus zugegriffen werden ? `Day.MON`

---

## Strings

- Objekte der Klasse `String` sind schreibgeschützt
- Objekte der Klasse `String`, `Stringbuffer` und `StringBuilder` sowie `char[]` sind ueber geeignete Methoden leicht ineinander ueberfuehrbar
- Objekte der Klasse `StringBuffer` sind modifizierbar
- Objekte der Klasse `String` koennen mit `+` aneinander angefuegt werden
- Objekte der Klasse `String` koenne ueber eine ihrer Methoden in ein `char[]` ueberfuehrt werden

---

## IO/Serialization

- Viele Operationen auf Dateien/Datenströmen werfen checked Exceptions und sind daher beim Aufruf in try-catch-Blöcke
  einzuschließen.
- Input/Output-Streams in der API von Java können durch die weitergeleiteten Daten, die Richtung und die Funktion kategoriesiert
  werden.
- Eine JSON-Datei ist wie ein Baum aufgebaut und für Menschen lesbar.
- Nach Beenden des Lesens/Schreibens sollte der Datenstrom geschlossen werden.
- Lese- und Schreiboperationen können beliebig gemischt werden.
