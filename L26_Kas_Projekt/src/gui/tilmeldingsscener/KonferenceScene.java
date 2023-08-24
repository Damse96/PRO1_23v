package gui.tilmeldingsscener;

import application.controller.Controller;
import application.model.Konference;
import application.model.Tilmelding;
import gui.LoginScene;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class KonferenceScene {
    private Stage primaryStage;
    private GridPane nextPane;
    private Tilmelding tilmelding;
    private Label lblSceneTitel, lblKonferencer;
    private ListView<Konference> lvwKonferencer;

    public KonferenceScene(Stage primaryStage, Tilmelding tilmelding) {
        this.tilmelding = tilmelding;
        this.primaryStage = primaryStage;
        this.nextPane = new GridPane();
        nextPane.setPadding(new Insets(20));
        nextPane.setHgap(20);
        nextPane.setVgap(10);
        nextPane.setAlignment(Pos.CENTER);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setGridLinesVisible(false);
        gridPane.setHgap(20);
        gridPane.setVgap(10);
//      -------------------- Indhold i gridPane --------------------
        lblSceneTitel = new Label("Konferencevalg");
        lblSceneTitel.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        GridPane.setHalignment(lblSceneTitel, HPos.CENTER);
        gridPane.add(lblSceneTitel,0,0,4,1);

        lblKonferencer = new Label("Vælg konference: ");
        gridPane.add(lblKonferencer,0,1);

        lvwKonferencer = new ListView<>();
        lvwKonferencer.getItems().addAll(Controller.getKonferencer());
        lvwKonferencer.setPrefWidth(500);
        gridPane.add(lvwKonferencer,0,2);

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
        Scene scene = new Scene(nextPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void goToNext() {
        Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
        tilmelding.setKonference(konference);
        konference.addTilmelding(tilmelding);
        if (konference != null) {
            DeltagerScene deltagerScene = new DeltagerScene(primaryStage, tilmelding);
            deltagerScene.show();
        }
    }

    private void goBack() {
        LoginScene loginScene = new LoginScene(primaryStage);
        loginScene.show();
    }
}