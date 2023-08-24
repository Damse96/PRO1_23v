package gui.adminScener;

import application.model.Ledsager;
import application.model.Udflugt;
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

public class UdflugtOversigtScene {
    private Stage primaryStage;
    private BorderPane nextPane;

    public UdflugtOversigtScene(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.nextPane = new BorderPane();
        nextPane.setPadding(new Insets(20));

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setGridLinesVisible(false);

        // -------------------- Tilføj ListView of Udflugter --------------------
        Label lblUdflugter = new Label("Udflugter");
        gridPane.add(lblUdflugter, 0, 0);

        ListView<Udflugt> udflugtListView = new ListView<>();
        ArrayList<Udflugt> udflugter = Storage.getUdflugter();
        ObservableList<Udflugt> udflugtList = FXCollections.observableArrayList(udflugter);

        udflugtListView.setItems(udflugtList);

        // Handle double-click event on konferenceListView
        udflugtListView.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) { // Check for double-click
                Udflugt selectedUdflugter = udflugtListView.getSelectionModel().getSelectedItem();
                if (selectedUdflugter != null) {
                    // Call a method to display the details of the selected Konference
                    showUdflugtDetails(selectedUdflugter);
                }
            }
        });

        gridPane.add(udflugtListView, 0, 1);

        //      -------------------- Tilbage --------------------
        Button btnBack = new Button("Tilbage");
        btnBack.setOnAction(e -> goBack());

        HBox buttonBox = new HBox(10,btnBack);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);

        //      -------------------- Tilføj --------------------
        // Set the gridPane as the center
        nextPane.setCenter(gridPane);

        // Set the "Tilbage" button in the bottom right
        nextPane.setBottom(buttonBox);
    }

    private void showUdflugtDetails(Udflugt selectedUdflugter) {

        // Create a new dialog
        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle("Tilmeldinger");

        // Create a custom DialogPane
        DialogPane dialogPane = new DialogPane();
        VBox content = new VBox();

        // Create a ListView to display the participants (deltagere)
        ListView<Ledsager> participantsListView = new ListView<>();
        participantsListView.getItems().addAll(selectedUdflugter.getLedsagere());

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
