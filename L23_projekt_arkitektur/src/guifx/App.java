package guifx;

import application.controller.Controller;
import application.model.Plads;
import application.model.PladsType;
import javafx.application.Application;
import storage.Storage;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {

        initStorage();
        Application.launch(Gui.class);
        testPrint();


    }

    public static void initStorage() {
        //forestillinger
        Controller.createForestilling("Evita", LocalDate.of(2023, 8, 10), LocalDate.of(2023, 8, 20));
        Controller.createForestilling("Lykke Per", LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 10));
        Controller.createForestilling("Chess", LocalDate.of(2023, 8, 21), LocalDate.of(2023, 8, 30));

        //Kunder
        Controller.createKunde("Anders Hansen", "11223344");
        Controller.createKunde("Peter Jensen", "12345678");
        Controller.createKunde("Niels Madsen", "12341234");


        /** Pladser **/
        for (int row = 1; row < 16; row++) {
            for (int plads = 1; plads < 21; plads++) {
                if (row < 6) {
                    if (plads < 3 && plads < 19) {
                        Controller.createPlads(row, plads, 500, PladsType.STANDARD);
                    } else {
                        Controller.createPlads(row, plads, 450, PladsType.STANDARD);
                    }
                } else if (row < 11) {
                    if (plads < 3) {
                        Controller.createPlads(row, plads, 400, PladsType.STANDARD);

                    } else if (plads < 8) {
                        Controller.createPlads(row, plads, 450, PladsType.STANDARD);


                    } else if (plads < 13) {
                        Controller.createPlads(row, plads, 450, PladsType.KØRESTOL);

                    } else if (plads < 19) {
                        Controller.createPlads(row, plads, 450, PladsType.STANDARD);

                    } else {
                        Controller.createPlads(row, plads, 400, PladsType.STANDARD);
                    }

                } else if (row < 12) {
                    if (plads > 7 && plads < 13) {
                        Controller.createPlads(row, plads, 400, PladsType.EKSTRABEN);
                    } else {

                    }
                } else {
                    Controller.createPlads(row, plads, 400, PladsType.STANDARD);


                }

            }

        }

    }


    public static void testPrint() {
        for (int i = 0; i < Storage.getKunder().size(); i++) {
            System.out.println("Navn: "+ Storage.getKunder().get(i).getNavn() + " Mobil: " + Storage.getKunder().get(i).getMobil());

        }
        for (int i = 0; i < Storage.getForestillinger().size(); i++) {
            System.out.println("Navn: " + Storage.getForestillinger().get(i).getName() + " Startdato: " + Storage.getForestillinger().get(i).getStartDate() + " Slutdato: "+ Storage.getForestillinger().get(i).getSlutDate());

        }
        for (int i = 0; i < Storage.getPladser().size(); i++) {

            System.out.println("Række: " + Storage.getPladser().get(i).getRække() + " Nr: " + Storage.getPladser().get(i).getNr() + " Pris: " + Storage.getPladser().get(i).getPris() + " Pladstype: " + Storage.getPladser().get(i).getPladsType());
        }

    }

}

