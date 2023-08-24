package opgave2_exercise3_figur1;

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

	//	private void drawShapes(GraphicsContext gc) {
//		// Replace the statement here with your code.
//		// draw an arrowhead at (50,30)
//		int x1 = 20; // start point: (x1,y1)
//		int y1 = 20;
//		int y2 = 190;
//		while (x1 <= 180) {
//			gc.strokeLine(x1, y1, x1, y2);
//			x1 = x1 + 40;
//		}
	/*private void drawShapes(GraphicsContext gc) {

		int x1 = 20; // start point: (x1,y1)
		int y1 = 20;
		int x2 = 190;
		while (x1 <= 180) {
			gc.strokeLine(x1, y1, x2, y1);
			y1 = y1 + 40;
		}*/

	private void drawShapes(GraphicsContext gc) {

		int y1 = 190; // start point: (x1,y1)
		int x1 = 20;
		int x2 = 180;
		while (x1 <= 180) {
			gc.strokeLine(x1, y1, x2, y1);
			x1 = x1 + 17;
			x2 = x2 - 17;
			y1 = y1 - 40;
		}
	}
}
