package opgave1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GuiDemo3 extends Application {

    private TextField txfName;

    private TextField txfName1;

    private TextField txfName2;

    private Button combine;

    @Override
    public void start(Stage stage) {
        stage.setTitle("opgave1");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(true);

        // set padding of the pane
        pane.setPadding(new Insets(50));
        // set horizontal gap between components
        pane.setHgap(50);
        // set vertical gap between components
        pane.setVgap(50);

        // add a label to the pane (at col=0, row=0)
        Label lblName = new Label("Full name:");
        pane.add(lblName, 0, 1);

        // add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
         txfName = new TextField();
        pane.add(txfName, 1, 1, 2, 1);

        Label lblName1 = new Label("First name:");
        pane.add(lblName1, 0, 0);

        // add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
         txfName1 = new TextField();
        pane.add(txfName1, 1, 0, 2, 1);

        Label lblName2 = new Label("Last name:");
        pane.add(lblName2, 3, 0);

        // add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
         txfName2 = new TextField();
        pane.add(txfName2, 4, 0, 2, 1);


        // add a button to the pane (at col=1, row=1)
        combine = new Button("Combine");
        pane.add(combine, 2, 2);
        combine.setOnAction(event -> this.combineAction());
        GridPane.setMargin(combine, new Insets(10, 10, 0, 10));

    }

    public void combineAction(){
        txfName.setText(txfName1.getText() + " " + txfName2.getText());
    }
}
