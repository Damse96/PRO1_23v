package guifx;

import application.controller.Controller;
import application.model.Forestilling;
import application.model.Kunde;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Gui extends Application {

    private TextField txfForestillingNavn, txfStartDato, txfSlutDato, txfKundenavn, txfKundeMobil;
    private Label lblKunder, lblKundenavn, lblForestillinger, lblForestillingNavn, lblStartDato, lblSlutDato, lblKundeNavn, lblKundeMobil;
    private ListView<Forestilling> lwForestillinger;
    private ListView<Kunde> lwKunder;
    private Button btnOpretForestilling, btnOpretKunde;


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

        GridPane txaPane = new GridPane();
        pane.add(txaPane, 0, 0);
        txaPane.setGridLinesVisible(false);
        txaPane.setPadding(new Insets(5));
        txaPane.setHgap(10);
        txaPane.setVgap(5);
        txaPane.setMinWidth(500);


        lblForestillinger = new Label("Forestillinger:");
        lwForestillinger = new ListView<>();
        txaPane.add(lblForestillinger, 0, 0);
        txaPane.add(lwForestillinger, 0, 1);
        lwForestillinger.setPrefSize(250, 200);
        lwForestillinger.getItems().setAll(Controller.getForestillinger());


        lblKunder = new Label("Kunder");
        lwKunder = new ListView();
        txaPane.add(lblKunder, 1, 0);
        txaPane.add(lwKunder, 1, 1);
        lwKunder.setPrefSize(250, 200);
        lwKunder.getItems().setAll(Controller.getKunder());


        GridPane txfPane = new GridPane();
        pane.add(txfPane, 0, 1);
        txfPane.setGridLinesVisible(false);
        txfPane.setPadding(new Insets(5));
        txfPane.setHgap(28);
        txfPane.setVgap(5);
        txfPane.setMinWidth(500);

        lblForestillingNavn = new Label("Navn:");
        txfForestillingNavn = new TextField();
        txfPane.add(lblForestillingNavn, 0, 0);
        txfPane.add(txfForestillingNavn, 1, 0);

        lblStartDato = new Label("Start dato:");
        txfStartDato = new TextField();
        txfPane.add(lblStartDato, 0, 1);
        txfPane.add(txfStartDato, 1, 1);

        lblSlutDato = new Label("Slut dato:");
        txfSlutDato = new TextField();
        txfPane.add(lblSlutDato, 0, 2);
        txfPane.add(txfSlutDato, 1, 2);

        btnOpretForestilling = new Button("Opret forestilling");
        txfPane.add(btnOpretForestilling, 1, 3);
        btnOpretForestilling.setOnAction(Event -> this.opretForestillingAction());

        lblKundenavn = new Label("Kunde navn:");
        txfKundenavn = new TextField();
        txfPane.add(lblKundenavn, 2, 0);
        txfPane.add(txfKundenavn, 3, 0);

        lblKundeMobil = new Label("Kunde mobil:");
        txfKundeMobil = new TextField();
        txfPane.add(lblKundeMobil, 2, 1);
        txfPane.add(txfKundeMobil, 3, 1);

        btnOpretKunde = new Button("Opret kunde");
        txfPane.add(btnOpretKunde, 3, 2);
        btnOpretKunde.setOnAction(Event -> this.opretKundeAction());


    }

    private void opretKundeAction() {
        String name = txfKundenavn.getText().trim();
        String mobil = txfKundeMobil.getText().trim();
        if (name.length() == 0) {
            txfKundenavn.setText("Udfyld");
        } else if (mobil.length() != 8) {
            txfKundeMobil.setText(mobil + " ikke 8 cifre");
        } else {
            Controller.createKunde(name, mobil);
            lwKunder.getItems().setAll(Controller.getKunder());
            txfKundeMobil.clear();
            txfKundenavn.clear();
        }

    }

    private void opretForestillingAction() {
        String name = txfForestillingNavn.getText().trim();
        String startDato, slutDato;
        LocalDate startDate, slutDate;

        startDato = txfStartDato.getText();
        slutDato = txfSlutDato.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        System.out.println(startDato);
        System.out.println(slutDato);

        startDate = LocalDate.parse(startDato, formatter);
        slutDate = LocalDate.parse(slutDato, formatter);


        if (name.length() == 0) {
            txfForestillingNavn.setText("Udfyld");
        } else if (String.valueOf(startDato).length() != 8) {
            txfStartDato.setText("ikke gyldig");
        } else if (String.valueOf(slutDato).length() != 8) {
            txfSlutDato.setText("ikke gyldig");
        } else {
            Controller.createForestilling(name, startDate, slutDate);
            lwForestillinger.getItems().setAll(Controller.getForestillinger());
            txfForestillingNavn.clear();
            txfStartDato.clear();
            txfSlutDato.clear();
        }

    }


}