package gui.tilmeldingsscener;

import application.controller.Controller;
import application.model.Ledsager;
import application.model.Tilmelding;
import application.model.Udflugt;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LedsagerScene {
    private Stage primaryStage;
    private GridPane nextPane;
    private Tilmelding tilmelding;
    private TextField txfLedsagerNavn;
    private ListView<Udflugt> lvwUdflugt;
    private Label lblLedsagerNavn, lblSceneTitel, lblProgram, lblUdflugt, lblPris, lblDatoForUdflugt, lblBeskrivelse;

    public LedsagerScene(Stage primaryStage, Tilmelding tilmelding) {
        this.tilmelding = tilmelding;
        this.primaryStage = primaryStage;
        this.nextPane = new GridPane();
        nextPane.setPadding(new Insets(20));
        nextPane.setAlignment(Pos.CENTER);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setGridLinesVisible(false);
//      -------------------- Indhold i gridPane --------------------
        lblSceneTitel = new Label("Udflugter til ledsager");
        lblSceneTitel.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        GridPane.setHalignment(lblSceneTitel, HPos.CENTER);
        gridPane.add(lblSceneTitel, 0, 0, 4, 1);

        //       ------- Labels -------
        lblProgram = new Label("Ledsager program: ");
        gridPane.add(lblProgram, 0, 1);

        lblLedsagerNavn = new Label("Ledsagernavn: ");
        gridPane.add(lblLedsagerNavn, 4, 1);
        txfLedsagerNavn = new TextField();
        gridPane.add(txfLedsagerNavn, 5, 1);


        lblUdflugt = new Label("Udflugt: ");
        gridPane.add(lblUdflugt, 0, 3);

        lblDatoForUdflugt = new Label("Dato: ");
        gridPane.add(lblDatoForUdflugt, 1, 3);

        lblPris = new Label("Pris: ");
        gridPane.add(lblPris, 3, 3);

        lblBeskrivelse = new Label("Beskrivelse: ");
        gridPane.add(lblBeskrivelse, 4, 3);


//      ------- ListView -------

        lvwUdflugt = new ListView<>();
        gridPane.add(lvwUdflugt, 0, 5, 5, 1);
        lvwUdflugt.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lvwUdflugt.setMaxHeight(100);
        lvwUdflugt.setMaxWidth(800);
        lvwUdflugt.getItems().setAll(Controller.getUdflugter());


//      -------------------- Næste/Tilbage --------------------
        Button btnBack = new Button("Tilbage");
        btnBack.setOnAction(e -> goBack());
        Button btnNext = new Button("Næste");
        btnNext.setOnAction(e -> goToNext());

        HBox buttonBox = new HBox(10,btnBack,btnNext);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);

//      -------------------- Tilføj --------------------
        this.nextPane.add(gridPane,0,0);
        this.nextPane.add(buttonBox,0,1);
    }

    public void show() {
        Scene scene = new Scene(nextPane, 800,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void goToNext() {
        Ledsager ledsager = Controller.createLedsager(tilmelding.getDeltager(),txfLedsagerNavn.getText());
        for (Udflugt udflugt : lvwUdflugt.getSelectionModel().getSelectedItems()) {
            ledsager.addUdflugt(udflugt);
        }

        if (tilmelding.isHotelisSelected()) {
            HotelScene hotelScene = new HotelScene(primaryStage, tilmelding);
            hotelScene.show();
        } else {
        BekræftScene bekræftScene = new BekræftScene(primaryStage, tilmelding);
        bekræftScene.show();
        }
    }

    private void goBack() {
        DeltagerScene deltagerScene = new DeltagerScene(primaryStage, tilmelding);
        deltagerScene.show();
    }
}
