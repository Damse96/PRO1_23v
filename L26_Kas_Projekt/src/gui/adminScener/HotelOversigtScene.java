package gui.adminScener;

import application.model.Deltager;
import application.model.Hotel;
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

public class HotelOversigtScene {
    private Stage primaryStage;
    private BorderPane nextPane;

    public HotelOversigtScene(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.nextPane = new BorderPane();
        nextPane.setPadding(new Insets(20));

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setGridLinesVisible(false);

        // -------------------- Tilføj ListView of Hoteller --------------------
        Label lblHoteller = new Label("Hoteller");
        gridPane.add(lblHoteller, 0, 0);

        ListView<Hotel> hotelListView = new ListView<>();
        ArrayList<Hotel> hoteller = Storage.getHoteller();
        ObservableList<Hotel> hotelList = FXCollections.observableArrayList(hoteller);

        hotelListView.setItems(hotelList);

        // Handle double-click event on konferenceListView
        hotelListView.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) { // Check for double-click
                Hotel selectedHotel = hotelListView.getSelectionModel().getSelectedItem();
                if (selectedHotel != null) {
                    // Call a method to display the details of the selected Konference
                    showHotelDetails(selectedHotel);
                }
            }
        });

        gridPane.add(hotelListView, 0, 1);

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

    private void showHotelDetails(Hotel selectedHotel) {

        // Create a new dialog
        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle("Tilmeldinger");

        // Create a custom DialogPane
        DialogPane dialogPane = new DialogPane();
        VBox content = new VBox();


        // Create a ListView to display the companions (ledsagere)
        ListView<Deltager> companionsListView = new ListView<>();
        for (Tilmelding tilmelding : selectedHotel.getTilmeldinger()) {
            Deltager deltager = tilmelding.getDeltager();
            if (deltager != null) {
                companionsListView.getItems().add(deltager);
            } else {
                System.out.println("Deltager is null for Tilmelding: " + tilmelding);
            }
        }



        // Create a TabPane to contain both ListViews
        TabPane tabPane = new TabPane();
        Tab companionsTab = new Tab("Ledsagere", companionsListView);
        tabPane.getTabs().addAll(companionsTab);

        content.getChildren().add(companionsListView);
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
