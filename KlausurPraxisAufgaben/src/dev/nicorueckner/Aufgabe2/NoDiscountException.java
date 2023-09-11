package dev.nicorueckner.Aufgabe2;

/**
 * Aufgabe 2
 * Checked und Unchecked Exceptions
 *
 * An Unchecked Exception
 * aka *RuntimeException*
 *
 * Can occur during runtime,
 * so it is unchecked at compiletime
 */
public class NoDiscountException extends RuntimeException {
    public NoDiscountException() {
        super();
    }
    public NoDiscountException(String message) {
        super(message);
    }
} // End of Class
