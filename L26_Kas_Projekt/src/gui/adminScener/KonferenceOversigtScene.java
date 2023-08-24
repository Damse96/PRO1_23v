package gui.adminScener;

import application.model.Konference;
import application.model.Tilmelding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import storage.Storage;

import java.util.ArrayList;

public class KonferenceOversigtScene {
    private Stage primaryStage;
    private BorderPane nextPane;

    public KonferenceOversigtScene(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.nextPane = new BorderPane();
        nextPane.setPadding(new Insets(20));

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setGridLinesVisible(false);



        // -------------------- Tilføj ListView of Konferencer --------------------
        Label lblKonferencer = new Label("Konferencer");
        gridPane.add(lblKonferencer, 0, 0);

        ListView<Konference> konferenceListView = new ListView<>();
        ArrayList<Konference> konferencer = Storage.getKonferencer();
        ObservableList<Konference> konferenceList = FXCollections.observableArrayList(konferencer);

        konferenceListView.setItems(konferenceList);

        // Handle double-click event on konferenceListView
        konferenceListView.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) { // Check for double-click
                Konference selectedKonference = konferenceListView.getSelectionModel().getSelectedItem();
                if (selectedKonference != null) {
                    // Call a method to display the details of the selected Konference
                    showKonferenceDetails(selectedKonference);
                }
            }
        });

        gridPane.add(konferenceListView, 0, 1);

        //      -------------------- Tilbage --------------------
        Button btnBack = new Button("Tilbage");
        btnBack.setOnAction(e -> goBack());

        HBox buttonBox = new HBox(10,btnBack);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);

        //      -------------------- Placering af knapper --------------------
        // Set the gridPane as the center
        nextPane.setCenter(gridPane);

        // Set the "Tilbage" button in the bottom right
        nextPane.setBottom(buttonBox);

        //      -------------------- Opret --------------------

    }

    private void showKonferenceDetails(Konference selectedKonference) {
        // Create a new dialog
        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle("Tilmeldinger");

        // Create a custom DialogPane
        DialogPane dialogPane = new DialogPane();
        VBox content = new VBox();

        // Create a ListView to display the participants (deltagere)
        ListView<Tilmelding> participantsListView = new ListView<>();
        participantsListView.getItems().addAll(selectedKonference.getTilmeldinger());

        content.getChildren().add(participantsListView);
        dialogPane.setContent(content);
        dialog.setDialogPane(dialogPane);

        // Add a close button
        dialogPane.getButtonTypes().add(ButtonType.CLOSE);

        // Show the dialog
        dialog.showAndWait();
    }

    private void goBack() {
        AdminScene adminScene = new AdminScene(primaryStage);
        adminScene.show();
    }

    public void show() {
        Scene scene = new Scene(nextPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
