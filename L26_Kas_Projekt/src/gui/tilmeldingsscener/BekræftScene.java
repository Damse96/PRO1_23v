package gui.tilmeldingsscener;

import application.model.Tilmelding;
import gui.LoginScene;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BekræftScene {
    private Stage primaryStage;
    private GridPane nextPane;
    private Tilmelding tilmelding;
    private Label lblSceneTitel;
    private Label lblNavn, lblAdresse, lblLand, lblTlf, lblAnkomst,lblForedragsholder, lblAfrejse, lblFirmaNavn, lblFirmaTlf, lblKonference, lblLedsagerNavn, lblUdflugt, lblHotel, lblTillæg, lblSamletPris;

    public BekræftScene(Stage primaryStage, Tilmelding tilmelding) {
        this.tilmelding = tilmelding;
        this.primaryStage = primaryStage;
        this.nextPane = new GridPane();
        nextPane.setPadding(new Insets(20));
        nextPane.setAlignment(Pos.CENTER);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setGridLinesVisible(false);
//      -------------------- Indhold i gridPane --------------------
        lblSceneTitel = new Label("Tilmeldingsbekræftelse");
        lblSceneTitel.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        GridPane.setHalignment(lblSceneTitel, HPos.CENTER);
        gridPane.add(lblSceneTitel, 0, 0, 4, 1);

        lblKonference = new Label("Konference: " + tilmelding.getKonference());

        lblNavn = new Label("Navn: " + tilmelding.getDeltager().getNavn());
        lblAdresse = new Label("Adresse: " + tilmelding.getDeltager().getAdresse());
        lblLand = new Label("Land: " + tilmelding.getDeltager().getLand());
        lblTlf = new Label("Tlf.Nr.: " + tilmelding.getDeltager().getTlfNr());
        lblAnkomst = new Label("Ankomstdato: " + tilmelding.getAnkomstdato().toString());
        lblAfrejse = new Label("Afrejsedato: " + tilmelding.getAfrejsedato().toString());
        lblFirmaNavn = new Label("Firmanavn: " + tilmelding.getDeltager().getFirmaNavn());
        lblFirmaTlf = new Label("Firma Tlf.Nr.: " + tilmelding.getDeltager().getFirmaTlfNr());
        lblForedragsholder= new Label("Foredragsholder: " + tilmelding.isForedragsholder());

        lblLedsagerNavn = new Label("Ledsagernavn: " + tilmelding.getDeltager().getLedsager().getNavn());
        lblUdflugt = new Label("Udflugter: " + tilmelding.getDeltager().getLedsager().getUdflugter());

        lblHotel = new Label("Hotel: " + tilmelding.getHotel().getNavn());
        lblTillæg = new Label("Tillæg: " + tilmelding.getTillæg());

        lblSamletPris = new Label("Samlet pris: " + tilmelding.getSamletPris());
        gridPane.add(lblSamletPris,1,1);

        ArrayList<Label> labels = new ArrayList<>();
        labels.add(lblKonference);
        labels.add(lblNavn);
        labels.add(lblAdresse);
        labels.add(lblLand);
        labels.add(lblTlf);
        labels.add(lblAnkomst);
        labels.add(lblAfrejse);
        labels.add(lblFirmaNavn);
        labels.add(lblFirmaTlf);
        labels.add(lblForedragsholder);
        labels.add(lblLedsagerNavn);
        labels.add(lblUdflugt);
        labels.add(lblHotel);
        labels.add(lblTillæg);

        for (int i = 1; i < labels.size(); i++) {
            gridPane.add(labels.get(i),0,i);
        }

//      -------------------- Bekræft --------------------
        Button btnBekræft = new Button("Bekræft tilmelding");
        btnBekræft.setOnAction(e -> goToLogin());
        HBox buttonBox = new HBox(10,btnBekræft);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);

//      -------------------- Tilføj --------------------
        this.nextPane.add(gridPane,0,0);
        this.nextPane.add(buttonBox,0,1);

    }
    public void show() {
        Scene scene = new Scene(nextPane, 800,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void goToLogin() {
        LoginScene loginScene = new LoginScene(primaryStage);
        loginScene.show();
    }
}
