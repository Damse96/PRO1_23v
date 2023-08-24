package opgave4;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        this.initContent(pane);
        Scene scene = new Scene(pane, 400, 400);

        stage.setTitle("Show shapes til opgave1: ");
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(Pane pane) {

        int numberOfWheels = 4;
        int numberOfDoors = 4;
        for (int i = 1; i <= numberOfWheels; i++) {
            Circle circle = new Circle(80 + i, 200 + 80, 30);
            pane.getChildren().add(circle);
            circle.setFill(Color.YELLOW);
            circle.setStroke(Color.BLACK);
        }

        // Rectangle with upper left corner at (100,40), width 75, height 25
        for (int i = 1; i <= numberOfDoors; i++) {
            Rectangle rektangel = new Rectangle(20+i, 200-35, 40, 70);
            pane.getChildren().add(rektangel);
            rektangel.setFill(Color.RED);
            rektangel.setStroke(Color.BLACK);

        }

        Rectangle rektangel2 = new Rectangle(50, 200-70, 300, 140);
        pane.getChildren().add(rektangel2);
        rektangel2.setFill(Color.RED);
        rektangel2.setStroke(Color.BLACK);

    }

}
