package eksempel;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Gui extends Application {

    // LISTVIEW
    private ListView lvw1; // Husk at indsætte <Klasse> efter listview her. Eksempel: ListView<Udflugt>
    private ListView lvw2; // Husk at indsætte <Klasse> efter listview her. Eksempel: ListView<Udflugt>

    // LABELS
    Label lbl1; // - Bliver intialiseret længere nede
    Label lbl2; // - Bliver intialiseret længere nede
    Label lbl3; // - Bliver intialiseret længere nede
    Label lbl4; // - Bliver intialiseret længere nede
    Label lbl5; // - Bliver intialiseret længere nede

    // TEXTFIELDS

    TextField txf1; // - Bliver intialiseret længere nede
    TextField txf2; // - Bliver intialiseret længere nede
    TextField txf3; // - Bliver intialiseret længere nede

    // BUTTONS

    Button btn1; // Knap 1 - Bliver intialiseret længere nede
    Button btn2; // Knap 2 - Bliver intialiseret længere nede

    @Override
    public void start(Stage stage) {
        stage.setTitle("Semesterprøve - Programmering");
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane);
        this.initContent(pane);
        stage.setScene(scene);
        stage.show();
    }

    public void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));

        /*
        OBS
        HVIS LISTVIEWS IKKE VIRKER KIG I FELTVARIABLERNE OG TILFØJ <"Klassenavn> efter listview.
         */

        lbl1 = new Label("Første listview");
        lbl1.setPadding(new Insets(10));
        pane.add(lbl1, 1,1);

        lvw1 = new ListView(); // Kig i feltvariablerne og indsæt <>, hvis der er problemer
        lvw1.setPadding(new Insets(20));

        pane.add(lvw1, 1,2);

        Label lblm = new Label("    "); // Ved ikk hvordan jeg laver mellemrum
        pane.add(lblm,2, 2); // Så dette er min lorte løsning


        lbl2 = new Label("Andet listview");
        lbl2.setPadding(new Insets(10));
        pane.add(lbl2, 3, 1);


        lvw2 = new ListView(); // Kig i feltvariablerne og indsæt <>, hvis der er problemer
        lvw2.setPadding(new Insets(20));
        pane.add(lvw2,3,2);

        Label lblm2 = new Label("    "); // Ved ikk hvordan jeg laver mellemrum
        pane.add(lblm2,4, 2); // Så dette er min lorte løsning


        HBox hb1 = new HBox(); // Laver hboxe for at kunne indsætte label og tekstfelt på samme linje
        HBox hb2 = new HBox(); // -||-
        HBox hb3 = new HBox(); // -||-
        HBox hb4 = new HBox(); // -||-
        HBox hb5 = new HBox(); // -||-
        HBox hb6 = new HBox(); // -||-
        VBox vBox = new VBox(hb1, hb2, hb3, hb4, hb5, hb6); // TIlføjer alt til en vbox
        pane.add(vBox,5,2);

        lbl3 = new Label("Label 3");
        lbl3.setPadding(new Insets(10));
        hb1.getChildren().add(lbl3);
        txf1 = new TextField();
        hb1.getChildren().add(txf1);

        lbl4 = new Label("Label 4");
        lbl4.setPadding(new Insets(10));
        hb2.getChildren().add(lbl4);
        txf2 = new TextField();
        hb2.getChildren().add(txf2);

        btn1 = new Button("Knap 1");

        hb3.getChildren().add(btn1);

        btn1.setOnAction(actionEvent -> btn1Action()); // Funktion til knap1. Kig længere nede for at skrive metoden.

        Label lblmellemrum = new Label("     "); // Mellemrum mellem øverste og nederste textfelter.
        lblmellemrum.setPadding(new Insets(20));
        hb4.getChildren().add(lblmellemrum);

        lbl5 = new Label("Label 5");
        lbl5.setPadding(new Insets(10));
        hb5.getChildren().add(lbl5);


        txf3 = new TextField();
        hb5.getChildren().add(txf3);

        btn2 = new Button("Knap 2");
        hb6.getChildren().add(btn2);


        btn2.setOnAction(actionEvent -> btn2Action()); // Funktion til knap2. Kig længere nede for at skrive metoden.




    }

    public void btn1Action() {
        // Metode til første knap
    }

    public void btn2Action() {
        // Metode til anden knap
    }

}
