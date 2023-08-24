package application.Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {
    private LocalDate dato;

    private LocalTime tid;

    private boolean single;

    private Spiller spiller;

    private Bane bane;

    public Booking(LocalDate dato, LocalTime tid, boolean single, Spiller spiller) {
        this.dato = dato;
        this.tid = tid;
        this.single = single;
        this.spiller = spiller;
    }

    public LocalDate getDato() {
        return dato;
    }

    public LocalTime getTid() {
        return tid;
    }

    public boolean isSingle() {
        return single;
    }

    public Spiller getSpiller() {
        return spiller;
    }

    public Bane getBane() {
        return bane;
    }

    public void setBane(Bane bane) {
        if (this.bane != bane) {
            Bane oldBane = this.bane;
            if (oldBane != null) {
                oldBane.removeBooking(this);
            }
            this.bane = bane;
            if (bane != null) {
                bane.addBooking(this);
            }
        }
    }

    @Override
    public String toString() {
        return "Booking{" +
                "dato=" + dato +
                ", tid=" + tid +
                ", single=" + single +
                ", spiller=" + spiller +
                ", bane=" + bane +
                '}';
    }
}
