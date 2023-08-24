package opgave5_datamatiker;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        GridPane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Loops");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane initContent() {
        GridPane pane = new GridPane();
        Canvas canvas = new Canvas(200, 200);
        pane.add(canvas, 0, 0);
        this.drawShapes(canvas.getGraphicsContext2D());
        return pane;
    }

    // ------------------------------------------------------------------------


    private void drawShapes(GraphicsContext gc) {
        String s = "Datamatiker";
        int x = 20; // center: (x,y)
        int y = 180;
        while (s.length() > 0) {
            gc.fillText(s, x, y);
            y = -1;
            s = s.substring(0, s.length() - 1);
        }

    }
}
