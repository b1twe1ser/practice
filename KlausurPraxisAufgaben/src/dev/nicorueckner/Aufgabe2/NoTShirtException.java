package dev.nicorueckner.Aufgabe2;

/**
 * A Checked Exception aka *Exception*
 */
public class NoTShirtException extends Exception {
    public NoTShirtException() {
        super();
    }
    public NoTShirtException(String message) {
        super(message);
    }
}
