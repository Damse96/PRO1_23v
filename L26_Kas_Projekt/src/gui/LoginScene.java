package gui;

import application.controller.Controller;
import application.model.Tilmelding;
import gui.adminScener.AdminScene;
import gui.tilmeldingsscener.KonferenceScene;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LoginScene {
    private Stage primaryStage;
    private StackPane loginPane;

    public LoginScene(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.loginPane = new StackPane();
        Button btnTilmelding = new Button("Tilmeld konference");
        btnTilmelding.setOnAction(e -> goToTilmelding());
        Button btnAdmin = new Button("Administation");
        btnAdmin.setOnAction(e -> goToAdmin());
        HBox box = new HBox(10,btnTilmelding,btnAdmin);
        box.setAlignment(Pos.CENTER);
        this.loginPane.getChildren().add(box);

    }

    public void show() {
        Scene scene = new Scene(loginPane, 800,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void goToTilmelding() {
        Tilmelding tilmelding = Controller.createTilmelding();
        KonferenceScene konferenceScene = new KonferenceScene(primaryStage, tilmelding);
        konferenceScene.show();
    }

    private void goToAdmin() {
        AdminScene adminScene = new AdminScene(primaryStage);
        adminScene.show();
    }
}
