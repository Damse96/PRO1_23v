package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tilmelding {
    private boolean foredragsholder;
    private LocalDate ankomstdato;
    private LocalDate afrejsedato;
    private Deltager deltager;
    private Konference konference;
    private Hotel hotel;
    private boolean hotelIsSelected;
    private Ledsager ledsager;
    private boolean dobbeltværelse;
    private ArrayList<Tillæg> tillæg = new ArrayList<>();

    public Tilmelding() {
    }

    public Tilmelding(boolean foredragsholder, LocalDate ankomstdato, LocalDate afrejsedato, Deltager deltager, Konference konference, boolean dobbeltværelse, Hotel hotel) {
        this.foredragsholder = foredragsholder;
        this.ankomstdato = ankomstdato;
        this.afrejsedato = afrejsedato;
        this.deltager = deltager;
        this.konference = konference;
        this.konference.addTilmelding(this);
        this.deltager.addTilmelding(this);
        this.dobbeltværelse = dobbeltværelse;
        this.hotel = hotel;
    }

    public boolean isHotelisSelected() {
        return hotelIsSelected;
    }

    public void setHotelisSelected(boolean hotelisSelected) {
        this.hotelIsSelected = hotelisSelected;
    }

    public void setAnkomstdato(LocalDate ankomstdato) {
        this.ankomstdato = ankomstdato;
    }

    public void setAfrejsedato(LocalDate afrejsedato) {
        this.afrejsedato = afrejsedato;
    }

    public void setHotel(Hotel hotel) {
        if (this.hotel != hotel) {
            Hotel oldHotel = this.hotel;
            if (oldHotel != null) {
                oldHotel.removeTilmelding(this);
            }
            this.hotel = hotel;
            if (hotel != null) {
                hotel.addTilmelding(this);
            }
        }
    }

    public void setDobbeltværelse(boolean dobbeltværelse) {
        this.dobbeltværelse = dobbeltværelse;
    }

    public boolean isDobbeltværelse() {
        return dobbeltværelse;
    }

    public void addTillæg(Tillæg tillæg) {
        if (!this.tillæg.contains(tillæg)) {
            this.tillæg.add(tillæg);}
    }

    public void setKonference(Konference konference) {
        this.konference = konference;
    }

    public void setDeltager(Deltager deltager) {
        this.deltager = deltager;
    }
    public void setLedsager(Ledsager ledsager) {
        this.ledsager = ledsager;
        this.dobbeltværelse = true;
    }

    public boolean isForedragsholder() {
        return foredragsholder;
    }

    public void setForedragsholder(boolean foredragsholder) {
        this.foredragsholder = foredragsholder;
    }

    public LocalDate getAnkomstdato() {
        return ankomstdato;
    }

    public LocalDate getAfrejsedato() {
        return afrejsedato;
    }

    public double getSamletPris() {
        return udregnSamletPris();
    }

    public Deltager getDeltager() {
        return deltager;
    }

    public Konference getKonference() {
        return konference;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public Ledsager getLedsager() {
        return ledsager;
    }

    public ArrayList<Tillæg> getTillæg() {
        return tillæg;
    }


    public double udregnSamletPris() {
        int antalDage = afrejsedato.getDayOfYear() - ankomstdato.getDayOfYear() + 1;
        int antalNætter = antalDage -1;
        double hotelPris = 0;
        double konferencePris = 0;
        if (!isForedragsholder()) {
            konferencePris = konference.getPrisPrDag() * antalDage;
        }
        if (hotel != null) {
            if (dobbeltværelse) {
                hotelPris = hotel.getDobbeltværelsePris();
            } else {
                hotelPris = hotel.getEnkeltværelsePris();
            }
            hotelPris = hotelPris * antalNætter;
            for (Tillæg t : tillæg) {
                hotelPris += t.getPris() * antalNætter;
            }
        }
        return hotelPris + deltager.getUdflugtPris() + konferencePris;
    }

    @Override
    public String toString() {
        return "Navn: " + deltager.getNavn() + " telefon: "+ deltager.getTlfNr() +
                "\nForedragsholder: " + foredragsholder + " Ankomst: " + ankomstdato + " Afrejse: " + afrejsedato;
    }
}
