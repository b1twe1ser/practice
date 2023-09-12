package dev.nicorueckner.Aufgabe3;

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