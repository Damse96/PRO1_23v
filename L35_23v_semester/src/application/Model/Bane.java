package application.Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.ArrayList;

public class Bane {
    private int nummer;

    private boolean inde;

    private LocalTime førsteTid;

    private LocalTime sidsteTid;

    private final ArrayList<Booking> bookings = new ArrayList<>();

    private Kategori kategori;


    public Bane(int nummer, boolean inde, LocalTime førsteTid, LocalTime sidsteTid) {
        this.nummer = nummer;
        this.inde = inde;
        this.førsteTid = førsteTid;
        this.sidsteTid = sidsteTid;


    }

    public int getNummer() {
        return nummer;
    }

    public boolean isInde() {
        if (inde = true) {
            System.out.println("inde");
        } else {
            System.out.println("Ude");;
        } return inde;
    }

    public LocalTime getFørsteTid() {
        return førsteTid;
    }

    public LocalTime getSidsteTid() {
        return sidsteTid;
    }



    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public Kategori getKategori() {
        return kategori;
    }

    /**
     * Adds the person to this group, if they aren't connected. Pre: The person
     * isn't connected to another group.
     */
    public void addBooking(Booking booking) {
        if (!bookings.contains(booking)) {
        bookings.add(booking);
        booking.setBane(this); }
    }

    /**
     * Removes the person from this group, if they are connected.
     */
    public void removeBooking(Booking booking) {
        if (!bookings.contains(booking)) {
            bookings.remove(booking);
            booking.setBane(this); }
    }

    public void setKategori(Kategori kategori) {
        if (this.kategori != kategori) {
        this.kategori = kategori; }
    }

   public int bookedeTimerPåDato(LocalDate dato){
        int sum = 0;
        for (Booking booking: bookings){
        if (dato.equals(bookings)){
            sum += dato.get(ChronoField.HOUR_OF_AMPM);


            }
        }
        return sum;
    }


    @Override
    public String toString() {
        return "Bane{" +
                "nummer=" + nummer +
                ", " + inde + " " +
                førsteTid +
                " ->" + sidsteTid + ", " + kategori ;
    }
}
