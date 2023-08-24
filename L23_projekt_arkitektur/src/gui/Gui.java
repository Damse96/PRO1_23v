package gui;


import application.controller.Controller;
import application.model.Bestilling;
import application.model.Forestilling;
import application.model.Kunde;
import application.model.Plads;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import storage.Storage;


import java.awt.*;
import java.awt.Dialog;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Gui extends Application {

    private TextField txfDato, txfForestillingNavn, txfStartDato, txfSlutDato, txfKundenavn, txfKundeMobil, txfSamletPris;
    private Label lblSamletPris, lblDato, lblPladser, lblKunder, lblKundenavn, lblForestillinger, lblForestillingNavn, lblStartDato, lblSlutDato, lblKundeNavn, lblKundeMobil;
    private ListView<Forestilling> lwForestillinger;
    private ListView<Kunde> lwKunder;
    private ListView<Plads> lwPladser;
    private Frame samletPrisPane;
    private Button btnOpretForestilling, btnOpretKunde, btnOpretBestilling, btnSamletPris, btnAntalBestiltePladserPåDag, btnSuccesDato, btnBestiltePladserTilForestillingPåDag;






    @Override
    public void start(Stage stage) {
        stage.setTitle("Teater bestillinger");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(5);
        pane.setVgap(5);

        GridPane listviewPane = new GridPane();
        pane.add(listviewPane, 0, 0);
        listviewPane.setHgap(5);




        /** Forestillings Pane **/
        GridPane forestillingPane = new GridPane();
        pane.add(forestillingPane,0, 1);
        forestillingPane.setGridLinesVisible(false);
        forestillingPane.setPadding(new Insets(5));
        forestillingPane.setHgap(20);
        forestillingPane.setVgap(5);
        lblForestillinger = new Label("Forestillinger:");
        lwForestillinger = new ListView<>();
        listviewPane.add(lblForestillinger, 0, 0);
        listviewPane.add(lwForestillinger,0,1);

        lwForestillinger.getItems().setAll(Controller.getForestillinger());


        lblForestillingNavn = new Label("Navn:");
        txfForestillingNavn = new TextField();
        forestillingPane.add(lblForestillingNavn, 0,0);
        forestillingPane.add(txfForestillingNavn, 1,0);

        lblStartDato = new Label("Start dato:");
        txfStartDato = new TextField();
        forestillingPane.add(lblStartDato, 0,1);
        forestillingPane.add(txfStartDato, 1, 1 );

        lblSlutDato= new Label("Slut dato:");
        txfSlutDato = new TextField();
        forestillingPane.add(lblSlutDato, 0 , 2);
        forestillingPane.add(txfSlutDato, 1, 2);

        btnOpretForestilling = new Button("Opret forestilling");
        forestillingPane.add(btnOpretForestilling,1,3);
        btnOpretForestilling.setOnAction(Event -> this.opretForestillingAction());



        /** Kunde pane **/
        lblKunder = new Label("Kunder");
        lwKunder = new ListView();
        listviewPane.add(lblKunder, 1, 0);
        listviewPane.add(lwKunder,1 ,1);

        lwKunder.getItems().setAll(Controller.getKunder());


        lblKundenavn = new Label("Kunde navn:");
        txfKundenavn = new TextField();
        forestillingPane.add(lblKundenavn, 2, 0);
        forestillingPane.add(txfKundenavn, 3, 0);



        lblKundeMobil= new Label("Kunde mobil:");
        txfKundeMobil = new TextField();
        forestillingPane.add(lblKundeMobil, 2, 1);
        forestillingPane.add(txfKundeMobil, 3, 1);

        btnOpretKunde = new Button("Opret kunde");
        forestillingPane.add(btnOpretKunde,3,2);
        btnOpretKunde.setOnAction(Event -> this.opretKundeAction());


        /** Pladser pane **/
        lblPladser = new Label("Pladser");
        lwPladser = new ListView<>();
        lwPladser.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listviewPane.add(lblPladser, 2, 0);
        listviewPane.add(lwPladser,2,1);

        lwPladser.getItems().setAll(Controller.getPladser());
        btnOpretBestilling = new Button("Opret bestilling");


        lblDato = new Label("Dato");

        txfDato = new TextField();

        txfDato.setText("yyyy-MM-dd");
        forestillingPane.add(lblDato, 4,0);

        forestillingPane.add(txfDato, 5, 0);

        forestillingPane.add(btnOpretBestilling,5,1);
        btnOpretBestilling.setOnAction(Event -> this.opretBestillingAction());





    }

    private void opretKundeAction(){
        String name = txfKundenavn.getText().trim();
        String mobil = txfKundeMobil.getText().trim();
        if (name.length() == 0) {
            txfKundenavn.setText("*");
        } else if (mobil.length() != 8) {
            txfKundeMobil.setText(mobil + "########");
        } else {
        Controller.createKunde(name, mobil);
        lwKunder.getItems().setAll(Controller.getKunder());
        txfKundeMobil.clear();
        txfKundenavn.clear();
        }

    }

    private void opretForestillingAction(){
        String name = txfForestillingNavn.getText().trim();
        String startDato, slutDato;
        LocalDate startDate, slutDate;

        startDato = txfStartDato.getText();
        slutDato = txfSlutDato.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(startDato);
        System.out.println(slutDato);

        startDate = LocalDate.parse(startDato, formatter);
        slutDate = LocalDate.parse(slutDato, formatter);


        if (name.length() == 0) {
            txfForestillingNavn.setText("*");
        } else if (String.valueOf(startDato).length() != 8) {
            txfStartDato.setText("yyyy-MM-dd");
        }
        else if (String.valueOf(slutDato).length() != 8) {
            txfSlutDato.setText("yyyy-MM-dd");}
        else {
            Controller.createForestilling(name, startDate, slutDate);
            lwForestillinger.getItems().setAll(Controller.getForestillinger());
            txfForestillingNavn.clear();
            txfStartDato.clear();
            txfSlutDato.clear();
        }

    }

    private void opretBestillingAction(){

        if (!txfDato.getText().isEmpty() && txfDato.getText().length() != 8){
            LocalDate dato = LocalDate.parse(txfDato.getText());
            Forestilling forestilling = lwForestillinger.getSelectionModel().getSelectedItem();
            Kunde kunde = lwKunder.getSelectionModel().getSelectedItem();
            ArrayList<Plads> pladser = new ArrayList<>(lwPladser.getSelectionModel().getSelectedItems());

            if (forestilling != null || kunde != null || pladser != null) {
                if(dato.isBefore(forestilling.getStartDate()) || dato.isAfter(forestilling.getSlutDate())){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Fejl");
                        alert.setHeaderText("Den valgte forestilling foregår ikke på den valgte dato");
                        alert.setContentText("Indtast ny dato: yyyy-MM-dd");
                        alert.show();
                } else {
                    Controller.opretBestillingMedPladser(forestilling, lwKunder.getSelectionModel().getSelectedItem(), dato, pladser);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Bestilling");
                    alert.setHeaderText("Bestilling oprettet:");

                    alert.setContentText("Navn: " + kunde.getNavn() + "\nForestilling: " + forestilling.getName() + "\nPladser: " + pladser);
                    alert.show();

                }
            } else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Add person");
                    alert.setHeaderText("No named typed");
                    alert.setContentText("Type the name of the person");
                    alert.show();


            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fejl");
            alert.setHeaderText("Fejl i dato");
            alert.setContentText("Indtast dato som: yyyy-MM-dd");
            alert.show();
        }

    }

    private void samletPrisAction(){
        samletPrisPane = new Frame();
        Window samletPrisWindow = new Window(samletPrisPane);

    }







}
