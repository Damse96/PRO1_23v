package application.Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.ArrayList;

public class Spiller {
    private String navn;

    private String uddannelse;

    private final ArrayList<Booking> bookings = new ArrayList<>();

    public Spiller(String navn, String uddannelse) {
        this.navn = navn;
        this.uddannelse = uddannelse;
    }

    public String getNavn() {
        return navn;
    }

    public String getUddannelse() {
        return uddannelse;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public Booking createBooking(LocalDate dato, LocalTime tid, boolean single) {
        Booking booking = new Booking(dato,tid,single, this);
        bookings.add(booking);
        return booking;
    }

    @Override
    public String toString() {
        return
                 navn + " (" + uddannelse + ")" ;
    }

    public int samletPris(Kategori kategori){
        int sum = 0;
        for (Booking booking : bookings){
            sum += booking.getTid().get(ChronoField.HOUR_OF_AMPM) * kategori.getPrisKrSingle() + kategori.getPrisKrDouble();
        } return sum;
    }
}
