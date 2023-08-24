package gui;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.YatzyDice;

import java.nio.channels.Pipe;
import java.util.ArrayList;

public class YatzyGui extends Application {
    private YatzyDice dice = new YatzyDice();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Yatzy");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // -------------------------------------------------------------------------

    // txfValues shows the face values of the 5 dice.
    private final TextField[] txfValues = new TextField[5];
    // cbxHolds shows the hold status of the 5 dice.
    private final CheckBox[] cbxHolds = new CheckBox[5];
    // txfResults shows the obtained results.
    // For results not set yet, the possible result of
    // the actual face values of the 5 dice are shown.
    private final ArrayList<TextField> txfResults = new ArrayList<>(15);
    // Shows points in sums, bonus and total.
    private final TextField txfSumSame = new TextField();
    private final TextField txfBonus = new TextField();
    private final TextField txfSumOther = new TextField();
    private final TextField txfTotal = new TextField();

    private final Label lblThrowCount = new Label();
    private final Button btnThrow = new Button(" Throw ");
    private final TextField[] txfPoints = new TextField[dice.getResults().length];

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        // ---------------------------------------------------------------------

        GridPane dicePane = new GridPane();
        pane.add(dicePane, 0, 0);
        dicePane.setGridLinesVisible(false);
        dicePane.setPadding(new Insets(10));
        dicePane.setHgap(10);
        dicePane.setVgap(10);
        dicePane.setStyle("-fx-border-color: black");

        // add txfValues, chbHolds
        for (int i = 0; i < txfValues.length; i++) {
            TextField textField = new TextField();
            textField.setEditable(false);
            textField.setAlignment(Pos.CENTER);
            textField.setPrefWidth(100);
            textField.setPrefHeight(100);
            txfValues[i] = textField;
            dicePane.add(txfValues[i], i, 0);

            cbxHolds[i] = new CheckBox("Hold");
            cbxHolds[i].setOnAction(event -> this.checkBoxAction());
            dicePane.add(cbxHolds[i], i, 1);
        }
        // add lblThrowCount and btnThrow
        btnThrow.setPrefHeight(30);
        btnThrow.setPrefWidth(100);
        btnThrow.setOnAction(event -> btnThrowAction());
        dicePane.add(btnThrow, 4, 3);

        // ---------------------------------------------------------------------

        GridPane scorePane = new GridPane();
        pane.add(scorePane, 0, 1);
        scorePane.setGridLinesVisible(false);
        scorePane.setPadding(new Insets(10));
        scorePane.setVgap(5);
        scorePane.setHgap(10);
        scorePane.setStyle("-fx-border-color: black");
        int width = 50; // width of the text fields

        // add labels for results
        // add txfResults,
        String[] resultTexts = {
                "1 -s",
                "2 -s",
                "3 -s",
                "4 -s",
                "5 -s",
                "6 -s",
                null,
                "One pair",
                "Two pairs",
                "Three same",
                "Four same",
                "Full house",
                "Small straight",
                "Large straight",
                "Chance",
                "Yatzy"
        };
        for (int i = 0; i < resultTexts.length; i++) {
            if (resultTexts[i] != null) {
                Label label = new Label(resultTexts[i]);
                scorePane.add(label, 0, i);
                TextField txf = new TextField();
                txf.setPrefWidth(width);
                //txf.setOnMouseClicked(event -> this.mousePickResult(event));
                scorePane.add(txf, 1, i);
                txfResults.add(txf);
                txf.setEditable(false);
            }
        }
        // add labels and text fields for sums, bonus and total.
        String[] sumText = {
                "Sum ",
                "Bonus ",
                "Sum ",
                "TOTAL"
        };
        TextField[] textFieldsSum = {txfSumSame, txfBonus, txfSumOther, txfTotal};
        int j = 5;
        for (int i = 0; i < textFieldsSum.length; i++) {
            if (i == 2) {
                j = 13;
            }
            if (j == 13) {
                textFieldsSum[i].setStyle("Baggrund - hvid");
            }
            Label label = new Label(sumText[i]);
            scorePane.add(label, 2, i + j);
            textFieldsSum[i].setPrefWidth(width);
            textFieldsSum[i].setEditable(false);
            scorePane.add(textFieldsSum[i], 3, i + j);
        }

    }


    // -------------------------------------------------------------------------

    private void checkBoxAction() {
        for (int i = 0; i < cbxHolds.length; i++) {
            if (cbxHolds[i].isSelected()) {
                txfValues[i].setEditable(false);
            } else {
                txfValues[i].setEditable(true);
            }
        }
    }

    // Create an action method for btnThrow's action.
    // Hint: Create small helper methods to be used in the action method.
    // TODO
    private void btnThrowAction() {
        boolean[] holds = new boolean[5];
        for (int i = 0; i < cbxHolds.length; i++) {
            holds[i] = cbxHolds[i].isSelected();
        }
        dice.throwDice(holds);
        btnThrow.setText("Throw " + dice.getThrowCount());
        if (dice.getThrowCount() == 3) {
            updateResultsAndDisableThrowButton();
        }
        if (dice.getThrowCount() == 4) {
            btnThrow.setDisable(true);
        }
        updateValues();
    }

    private void updateValues() {
        int[] v = dice.getValues();
        for (int i = 0; i < txfValues.length; i++) {
            String value = String.valueOf(v[i]);
            txfValues[i].setText(value);

        }
        int[] res = dice.getResults();
        for (int i = 0; i < dice.getResults().length; i++) {
            String res1 = String.valueOf(res[i]);
            txfPoints[i].setText(res1);

        }
    }

    private void updateResultsAndDisableThrowButton() {
        // Update the result checkboxes based on the dice.results. As the returned results array is
        // the same order as our txfResults ArrayList, we can update all the result textfields based on array index
        int[] results = dice.getResults();
        for (int i = 0; i < results.length; i++) {
            // If result field has already been picked (is disabled), skip updating that field
            if (txfResults.get(i).isDisabled()) {
                continue;
            }
            txfResults.get(i).setText(String.valueOf(results[i]));
        }
        // -------------------------------------------------------------------------

        // Create a method for mouse click on one of the text fields in txfResults.
        // Hint: Create small helper methods to be used in the mouse click method.
        // TODO
    }
}
