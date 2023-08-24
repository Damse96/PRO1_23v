package gui;

import application.model.Festival;
import application.model.Frivillig;
import application.model.FrivilligForening;
import application.model.Job;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        initStorage();
    }

    public static void initStorage() {
        Festival NorthSide = new Festival("NorthSide", LocalDate.of(2020,6,4),LocalDate.of(2020,6,6));

        Frivillig Jane = new Frivillig("Jane Jensen", "12345677", 20);
        Frivillig Lone = new Frivillig("Lone Hansen", "78787878", 25);
        Frivillig Anders = new Frivillig("Anders Mikkelsen", "55555555", 10);

        FrivilligForening Eaa = new FrivilligForening("Christian Madsen", "23232323", 100, "Erhvervsakademi Aarhus", 40);

        Job T1 = new Job("T1", "Rengøring af toilet", LocalDate.of(2020,6,4),100,5);
        Job T2 = new Job("T2", "Rengøring af toilet", LocalDate.of(2020,6,4),100,5);
        Job T3 = new Job("T3", "Rengøring af toilet", LocalDate.of(2020,6,4),100,5);
        Job T4 = new Job("T4", "Rengøring af toilet", LocalDate.of(2020,6,5),100,5);
        Job T5 = new Job("T5", "Rengøring af toilet", LocalDate.of(2020,6,5),100,5);
        Job T6 = new Job("T6", "Rengøring af toilet", LocalDate.of(2020,6,5),100,5);
        Job T7 = new Job("T7", "Rengøring af toilet", LocalDate.of(2020,6,6),100,5);
        Job T8 = new Job("T8", "Rengøring af toilet", LocalDate.of(2020,6,6),100,5);
        Job T9 = new Job("T9", "Rengøring af toilet", LocalDate.of(2020,6,6),100,5);







    }
}