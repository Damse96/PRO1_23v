package opgave3_insertionSort;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class App extends Application {

    private void initContent(Pane pane) {
        // Circle center at (70,70) and radius 30
        Circle circle = new Circle(70, 70, 30);
        pane.getChildren().add(circle);
        circle.setFill(Color.YELLOW);
        circle.setStroke(Color.BLACK);

        // Line from (70,70) to (100,70)
        Line line = new Line(10, 380, 380, 380);
        pane.getChildren().add(line);
        line.setStroke(Color.BLACK);


        // Rectangle with upper left corner at (100,40), width 75, height 25
        Rectangle rektangel = new Rectangle(20, 200, 170, 180);
        pane.getChildren().add(rektangel);
        rektangel.setFill(Color.RED);

        Rectangle vindue = new Rectangle(40, 150, 60, 100);
        pane.getChildren().add(vindue);
        vindue.setFill(Color.BLACK);
        // Rectangle with upper left corner at (100,40), width 75, height 25

        // Polygon with 3 points (100,100), (200,100) and (150,150)
        /*Polygon polygon = new Polygon(100, 100, 200, 100, 150, 150);
        pane.getChildren().add(polygon);
        polygon.setFill(Color.PINK);*/

    }

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        this.initContent(pane);
        Scene scene = new Scene(pane, 400, 400);

        stage.setTitle("Show shapes til opgave1: ");
        stage.setScene(scene);
        stage.show();
    }
}
