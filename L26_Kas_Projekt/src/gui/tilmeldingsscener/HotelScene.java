package gui.tilmeldingsscener;

import application.model.*;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;

public class HotelScene {
    private Stage primaryStage;
    private GridPane nextPane;
    private Tilmelding tilmelding;
    private Label lblSceneTitel, lblHotelValg, lblServiceValg;
    private ComboBox<Hotel> cmbHotel;
    private ListView<Tillæg> lvwTillæg;

    public HotelScene(Stage primaryStage, Tilmelding tilmelding) {
        this.tilmelding = tilmelding;
        this.primaryStage = primaryStage;
        this.nextPane = new GridPane();
        nextPane.setPadding(new Insets(20));
        nextPane.setAlignment(Pos.CENTER);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setGridLinesVisible(false);
//      -------------------- Indhold i gridPane --------------------

        lblSceneTitel = new Label("Overnatningsønsker");
        lblSceneTitel.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        GridPane.setHalignment(lblSceneTitel, HPos.CENTER);
        gridPane.add(lblSceneTitel,0,0,4,1);
        cmbHotel = new ComboBox<>();
        lblHotelValg = new Label("Hotel: ");
        lblServiceValg = new Label("Services: ");
        gridPane.add(lblHotelValg, 0, 1);
        gridPane.add(cmbHotel, 1, 1);
        gridPane.add(lblServiceValg, 0, 2);
        lvwTillæg = new ListView<>();
        lvwTillæg.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lvwTillæg.setPrefHeight(100);
        gridPane.add(lvwTillæg,1,2);


        //ComboBox værdier og logikker
        cmbHotel.getItems().addAll(tilmelding.getKonference().getHoteller());
        cmbHotel.getSelectionModel().selectedItemProperty().addListener((ov, oldVal, newVal) -> {
            if (newVal != null) {
                lvwTillæg.getItems().clear();
                lvwTillæg.getItems().addAll(newVal.getTillæg());
            }
        });



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
        tilmelding.setHotel(cmbHotel.getValue());
        ArrayList<Tillæg> selectedTillæg = new ArrayList<>();
        selectedTillæg.addAll(lvwTillæg.getSelectionModel().getSelectedItems());
        for (Tillæg t : selectedTillæg) {
            tilmelding.addTillæg(t);
        }
        BekræftScene bekræftScene = new BekræftScene(primaryStage, tilmelding);
        bekræftScene.show();
    }

    private void goBack() {
        DeltagerScene deltagerScene = new DeltagerScene(primaryStage, tilmelding);
        deltagerScene.show();
    }
}
