package dev.nicorueckner.Aufgabe5;

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
