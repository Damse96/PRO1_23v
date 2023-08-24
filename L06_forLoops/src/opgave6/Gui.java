package opgave6;

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
		// Replace the statement here with your code.
		// draw an arrowhead at (50,30)
		int y1 = 170; // start point: (x,y1)
		int y2 = 190; // end point: (x,y2)
		// for at ændre antal streger skal i <= 10 ændres til det ønskede antal
		for (int i = 0; i <= 10; i++) {
			int x1 = 10 + i * 14;
			if (i == 0 || i == 5 || i == 10){
				gc.strokeLine(x1, y1-4, x1, y2 + 4);

				gc.fillText(Integer.toString(i),x1,195);



			}
			gc.strokeLine(x1, y1, x1, y2);

		} gc.strokeLine(10, 180, 170, 180);
		int x = 180;
		int y = 180;
		gc.strokeLine(x, y, x - 10, y - 4);
		gc.strokeLine(x, y, x - 10, y + 4);
	}
}
