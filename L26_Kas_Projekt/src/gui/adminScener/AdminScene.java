package gui.adminScener;


import gui.LoginScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AdminScene {
    private Stage primaryStage;
    private BorderPane nextPane;

    public AdminScene(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.nextPane = new BorderPane();
        nextPane.setPadding(new Insets(20));

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setGridLinesVisible(false);

        //      -------------------- Oversigter --------------------
        Label lblOversigter = new Label("Oversigter");

        Button btnKonferencer = new Button("Konferencer");
        btnKonferencer.setOnAction(e -> goToKonferencer());

        Button btnHoteller = new Button("Hoteller");
        btnHoteller.setOnAction(e -> goToHoteller());

        Button btnUdflugter = new Button("Udflugter");
        btnUdflugter.setOnAction(e -> goToUdflugter());

        HBox oversigterBox = new HBox(10,btnKonferencer,btnHoteller,btnUdflugter);
        oversigterBox.setAlignment(Pos.CENTER);

        //      -------------------- Tilbage --------------------
        Button btnBack = new Button("Tilbage");
        btnBack.setOnAction(e -> goBack());

        HBox buttonBox = new HBox(10,btnBack);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);

        //      -------------------- Placering af knapper --------------------
        // Set the gridPane as the center
        nextPane.setCenter(gridPane);

        gridPane.add(lblOversigter, 0, 0);

        // Set the oversigterBox in the center
        gridPane.add(oversigterBox, 0, 1);

        // Set the "Tilbage" button in the bottom right
        nextPane.setBottom(buttonBox);

    }

    public void show() {
        Scene scene = new Scene(nextPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void goBack() {
        LoginScene loginScene = new LoginScene(primaryStage);
        loginScene.show();
    }

    private void goToKonferencer() {
        KonferenceOversigtScene konferenceOversigtScene = new KonferenceOversigtScene(primaryStage);
        konferenceOversigtScene.show();
    }

    private void goToHoteller() {
        HotelOversigtScene hotelOversigtScene = new HotelOversigtScene(primaryStage);
        hotelOversigtScene.show();
    }

    private void goToUdflugter() {
        UdflugtOversigtScene udflugtOversigtScene = new UdflugtOversigtScene(primaryStage);
        udflugtOversigtScene.show();
    }
}
