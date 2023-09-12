package dev.nicorueckner.Aufgabe4;

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
