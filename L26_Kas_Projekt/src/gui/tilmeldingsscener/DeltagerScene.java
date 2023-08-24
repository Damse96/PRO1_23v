package gui.tilmeldingsscener;

import application.controller.Controller;
import application.model.Deltager;
import application.model.Tilmelding;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.time.LocalDate;

public class DeltagerScene {
    private Stage primaryStage;
    private GridPane nextPane;
    private Tilmelding tilmelding;
    private Label lblSceneTitel, lblNavn, lblAdresse, lblLand, lblTlf, lblAnkomst, lblAfrejse, lblFirmaNavn, lblFirmaTlf;
    private TextField txfNavn, txfAdresse, txfLand, txfTlf, txfFirma, txfFirmaTlf;
    private DatePicker dtpAnkomst, dtpAfrejse;
    private CheckBox chbForedragsholder, chbLedsager, chbHotel;

    public DeltagerScene(Stage primaryStage, Tilmelding tilmelding) {
        this.tilmelding = tilmelding;
        this.primaryStage = primaryStage;
        this.nextPane = new GridPane();
        nextPane.setPadding(new Insets(20));
        nextPane.setHgap(20);
        nextPane.setVgap(10);
        nextPane.setAlignment(Pos.CENTER);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setGridLinesVisible(false);
        gridPane.setHgap(20);
        gridPane.setVgap(10);
//      -------------------- Indhold i gridPane --------------------
        lblSceneTitel = new Label("Tilmelding til konference");
        lblSceneTitel.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        GridPane.setHalignment(lblSceneTitel, HPos.CENTER);
        gridPane.add(lblSceneTitel,0,0,4,1);

//       ------- Labels -------
        lblNavn = new Label("Navn: ");
        gridPane.add(lblNavn, 0,1);

        lblAdresse = new Label("Adresse: ");
        gridPane.add(lblAdresse,0,2);

        lblLand = new Label("Land: ");
        gridPane.add(lblLand,0,3);

        lblTlf = new Label("Tlf.Nr.: ");
        gridPane.add(lblTlf,0,4);

        lblAnkomst = new Label("Ankomstdato: ");
        gridPane.add(lblAnkomst,0,5);

        lblFirmaNavn = new Label("Firmanavn: ");
        gridPane.add(lblFirmaNavn,0,6);

        lblAfrejse = new Label("Afrejsedato: ");
        gridPane.add(lblAfrejse,2,5);

        lblFirmaTlf = new Label("Firma Tlf.Nr.: ");
        gridPane.add(lblFirmaTlf,2,6);

//      ------- Textfields -------
        txfNavn = new TextField();
        gridPane.add(txfNavn,1,1);

        txfAdresse = new TextField();
        gridPane.add(txfAdresse,1,2);

        txfLand = new TextField();
        gridPane.add(txfLand,1,3);

        txfTlf = new TextField();
        gridPane.add(txfTlf,1,4);

        txfFirma = new TextField();
        gridPane.add(txfFirma,1,6);

        txfFirmaTlf = new TextField();
        gridPane.add(txfFirmaTlf,3,6);

//      ------- Datepickers -------
        dtpAnkomst = new DatePicker(tilmelding.getKonference().getStartDato());
//        dtpAnkomst = new DatePicker();
        gridPane.add(dtpAnkomst,1,5);

        dtpAfrejse = new DatePicker(tilmelding.getKonference().getStartDato());
//        dtpAfrejse = new DatePicker();
        gridPane.add(dtpAfrejse,3,5);

//      ------- Datepickers -------
        chbForedragsholder = new CheckBox("Foredragsholder");
        gridPane.add(chbForedragsholder,3,1);

        chbLedsager = new CheckBox("Ledsager");
        gridPane.add(chbLedsager,3,2);

        chbHotel = new CheckBox("Ønsker Hotel");
        gridPane.add(chbHotel,3,3);

//      ------- AutoFill -------
        if (tilmelding.getDeltager() != null) {
            txfNavn.setText(tilmelding.getDeltager().getNavn());
            txfAdresse.setText(tilmelding.getDeltager().getAdresse());
            txfLand.setText(tilmelding.getDeltager().getLand());
            txfTlf.setText(tilmelding.getDeltager().getTlfNr());
            txfFirma.setText(tilmelding.getDeltager().getFirmaNavn());
            txfFirmaTlf.setText(tilmelding.getDeltager().getFirmaTlfNr());
            dtpAnkomst.setValue(tilmelding.getAnkomstdato());
            dtpAfrejse.setValue(tilmelding.getAfrejsedato());
            chbForedragsholder.setSelected(tilmelding.isForedragsholder());
            chbHotel.setSelected(tilmelding.isHotelisSelected());
        }

//      -------------------- Næste/Tilbage --------------------
        Button btnBack = new Button("Tilbage");
        btnBack.setOnAction(e -> goBack());
        Button btnNext = new Button("Næste");
        btnNext.setOnAction(e -> goToNext());

        HBox buttonBox = new HBox(10,btnBack,btnNext);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);

//      -------------------- Tilføj --------------------
        this.nextPane.add(gridPane,0,0);
        this.nextPane.add(buttonBox,0,1);

    }

    public void show() {
        Scene scene = new Scene(nextPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void goToNext() {
        String navn = txfNavn.getText();
        String adresse = txfAdresse.getText();
        String land = txfLand.getText();
        String tlf = txfTlf.getText();
        String firma = txfFirma.getText();
        String firmaTlf = txfFirmaTlf.getText();
        LocalDate ankomst = dtpAnkomst.getValue();
        LocalDate afrejse = dtpAfrejse.getValue();
        boolean hotelIsSelected = chbHotel.isSelected();
        boolean foredragsholder = chbForedragsholder.isSelected();

        Deltager deltager = Controller.createDeltager(navn,adresse,land,tlf,firma,firmaTlf);
        tilmelding.setDeltager(deltager);
        tilmelding.setHotelisSelected(hotelIsSelected);
        tilmelding.setAnkomstdato(ankomst);
        tilmelding.setAfrejsedato(afrejse);
        tilmelding.setForedragsholder(foredragsholder);

        if (chbLedsager.isSelected()) {
            LedsagerScene ledsagerScene = new LedsagerScene(primaryStage, tilmelding);
            ledsagerScene.show();
        } else if (chbHotel.isSelected()) {
            HotelScene hotelScene = new HotelScene(primaryStage, tilmelding);
            hotelScene.show();
        } else {
            BekræftScene bekræftScene = new BekræftScene(primaryStage, tilmelding);
            bekræftScene.show();
        }
    }

    private void goBack() {
        KonferenceScene konferenceScene = new KonferenceScene(primaryStage, tilmelding);
        konferenceScene.show();
    }
}
