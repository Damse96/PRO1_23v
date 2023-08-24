package gui;

import application.Model.Bane;
import application.Model.Booking;
import application.Model.Spiller;
import application.controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import storage.Storage;

public class Gui extends Application {

    private static TextArea bookingerPåBane;

    private static TextArea SpillerBookinger;

    private static TextField timerInput;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Bane Bookings");

        // Create the main gridpane
        GridPane pane = new GridPane();
        this.initContent(pane);

        // Create the scene and set it on the stage
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private void initContent(GridPane pane) {
        // Set gridpane properties
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(5));
        pane.setHgap(20);
        pane.setVgap(20);

        // ------------------------------- Labels ----------------------------------
        // Create the labels
        Label baner = new Label("Baner");
        pane.add(baner, 0, 0);

        Label spiller = new Label("Spiller");
        pane.add(spiller, 1, 0);

        Label bookingerPåBanen = new Label("Bookinger på bane");
        pane.add(bookingerPåBanen, 2, 0);

        Label tiderBooketAfSpiller = new Label("Tider booket af spiller");
        pane.add(tiderBooketAfSpiller,0,3);

        // ------------------------------- ListViews ---------------------------------

        // Create listview for festivals
        ListView<Bane> baneListView = new ListView<>();
        baneListView.getItems().addAll(Storage.getBane());
        pane.add(baneListView, 0, 1);

        // Select the first festival by default
        if (!baneListView.getItems().isEmpty()) {
            baneListView.getSelectionModel().selectFirst();
        }

        // Create listview for jobs
        ListView<Spiller> spillerListView = new ListView<>();
        spillerListView.getItems().addAll(Storage.getSpiller());
        pane.add(spillerListView, 1, 1);



        // ----------------------------- TextArea ---------------------------------
        // Create a TextArea to display information
        bookingerPåBane = new TextArea();
        bookingerPåBane.setEditable(false);
        bookingerPåBane.setPrefWidth(200);
        bookingerPåBane.setPrefHeight(200);
        pane.add(bookingerPåBane, 3, 1);

        baneListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, selectidBane) -> {
            if (selectidBane != null) {
                bookingerPåBane.setText("Tid: " + selectidBane.getBookings());
                for (Booking booking : selectidBane.getBookings()) {
                    bookingerPåBane.toString();
                }
            } else {
                bookingerPåBane.clear();
            }
        });



    }

}
