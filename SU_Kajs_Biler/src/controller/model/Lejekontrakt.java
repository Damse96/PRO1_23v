package controller.model;

import java.time.LocalDate;

public class Lejekontrakt {
    private LocalDate dato;

    Kunde kunde;

    private Bil bil;
    public Lejekontrakt(LocalDate dato) {
        this.dato = dato;
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public void setBil(Bil bil) {
        if (this.bil != bil) {
            Bil oldBil = this.bil;
            if (oldBil != null) {
                oldBil.removeBil(this);
            }
            this.bil = bil;
            if (bil != null) {
                bil.addLejekontrakt
                        (this);
            }
        }
    }
    public void setKunde(Kunde kunde) {
        if (this.kunde != kunde) {
            Kunde oldKunde = this.kunde;
            if (oldKunde != null) {
                oldKunde.removeKunde(this);
            }
            this.kunde = kunde;
            if (kunde != null) {
                kunde.addLejekontrakt(this);
            }
        }
    }

    public void removeLegekontrakt(Bil bil) {
    }

}
