package gui;

import javafx.application.Application;
import javafx.stage.Stage;

public class StackPane extends Application {
    @Override
    public void start(Stage primaryStage) {
        LoginScene loginScene = new LoginScene(primaryStage);
        loginScene.show();
    }
}
