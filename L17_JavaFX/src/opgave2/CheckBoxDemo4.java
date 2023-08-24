package opgave2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CheckBoxDemo4 extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Demo CheckBox");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfnumber = new TextField();

    private Button incbtn;

    private Button decbtn;

    private int number = 0;

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);

        Label lblName = new Label("number:");
        pane.add(lblName, 0, 0);

        pane.add(txfnumber, 1, 0);
        txfnumber.setText("0");
        txfnumber.setEditable(true);
        incbtn = new Button("Increase");
        decbtn = new Button("Decrease");
        pane.add(incbtn,1, 0);

        incbtn.setOnAction(event -> this.increase());
        // CheckBox to indicate upper / lower case
    }

    private void increase() {
        
        txfnumber.getText();
    }


    // -------------------------------------------------------------------------

    /*private void upperCaseAction() {
        String number = txfName.setText(Integer.parseInt(""));
        txfName.setText(name.toUpperCase());
    }

    private void lowerCaseAction() {
        String name = txfName.getText().trim();
        txfName.setText(name.toLowerCase());
    }*/
}
