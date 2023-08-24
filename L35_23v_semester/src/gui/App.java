package gui;

import application.Model.Bane;
import application.Model.Booking;
import application.Model.Kategori;
import application.Model.Spiller;
import application.controller.Controller;
import javafx.application.Application;

import java.time.LocalDate;
import java.time.LocalTime;

public class App {
    public static void main(String[] args) {
        App.initStorage();
        Application.launch(Gui.class);
    }

    public static void initStorage() {


        Bane bane1 = Controller.opretBane(1,true, LocalTime.of(9,0,0),LocalTime.of(17,0,0));
        Bane bane2 = Controller.opretBane(2,true, LocalTime.of(9,0,0),LocalTime.of(17,0,0));
        Bane bane3 = Controller.opretBane(3,true, LocalTime.of(9,0,0),LocalTime.of(17,0,0));
        Bane bane4 = Controller.opretBane(4,false, LocalTime.of(9,0,0),LocalTime.of(17,0,0));
        Bane bane5 = Controller.opretBane(5,false, LocalTime.of(9,0,0),LocalTime.of(17,0,0));
        Bane bane6 = Controller.opretBane(6,false, LocalTime.of(9,0,0),LocalTime.of(17,0,0));

        Kategori Luksus = Controller.opretKategori(" Luksus ",100,200);
        Kategori Mellem = Controller.opretKategori(" Mellem ",50,100);
        Kategori Begynder = Controller.opretKategori(" Begynder ",25,50);
        bane1.setKategori(Luksus);
        bane2.setKategori(Luksus);
        bane3.setKategori(Mellem);
        bane4.setKategori(Mellem);
        bane5.setKategori(Begynder);
        bane6.setKategori(Begynder);



        Spiller Andreas = Controller.opretSpiller("Andreas","DMU");
        Spiller Petra =Controller.opretSpiller("Petra","DMU");
        Spiller Henrik = Controller.opretSpiller("Henrik","ITA");
        Spiller Ulla = Controller.opretSpiller("Ulla","ITA");

        Booking AndreasBooking1 =new Booking(LocalDate.of(2023,6,20),LocalTime.of(10,0),true,Andreas);
        AndreasBooking1.setBane(bane1);
        Booking AndreasBooking2 = new Booking(LocalDate.of(2023,6,22),LocalTime.of(10,0),false,Andreas);
        AndreasBooking2.setBane(bane2);
        Booking HenrikBooking1 = new Booking(LocalDate.of(2023,6,20),LocalTime.of(11,0),false,Henrik);
        HenrikBooking1.setBane(bane3);
        Booking UllaBooking1 = new Booking(LocalDate.of(2023,6,20),LocalTime.of(16,0),false,Ulla);
        UllaBooking1.setBane(bane3);
        Booking UllaBooking2 = new Booking(LocalDate.of(2023,6,23),LocalTime.of(17,0),true,Ulla);
        UllaBooking2.setBane(bane5);







    }
}
