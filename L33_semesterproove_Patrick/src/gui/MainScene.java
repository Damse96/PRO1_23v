package gui;

import application.Model.Festival;
import application.Model.Frivillig;
import application.Model.Job;
import application.Model.Vagt;
import application.controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import storage.Storage;

public class MainScene extends Application {
    // Define the GUI components
    private static ListView<Festival> festivalListView;
    private static ListView<Job> jobListView;
    private static ListView<Frivillig> frivilligListView;
    private static TextArea info;
    private static TextField timerInput;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Festival System");

        // Create the main gridpane
        GridPane pane = new GridPane();
        this.initContent(pane);

        // Create the scene and set it on the stage
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private void initContent(GridPane pane) {
        // Set gridpane properties
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        // ------------------------------- Labels ----------------------------------
        // Create the labels
        Label festivalLabel = new Label("Festivaler");
        pane.add(festivalLabel, 0, 0);

        Label jobLabel = new Label("Jobs");
        pane.add(jobLabel, 1, 0);

        Label frivilligLabel = new Label("Frivillige");
        pane.add(frivilligLabel, 2, 0);

        Label infoLabel = new Label("Information");
        pane.add(infoLabel, 3, 0);

        // ------------------------------- ListViews ---------------------------------

        // Create listview for festivals
        festivalListView = new ListView<>();
        festivalListView.getItems().addAll(Storage.getFestivaller());
        pane.add(festivalListView, 0, 1);

        // Select the first festival by default
        if (!festivalListView.getItems().isEmpty()) {
            festivalListView.getSelectionModel().selectFirst();
        }

        // Create listview for jobs
        jobListView = new ListView<>();
        pane.add(jobListView, 1, 1);

        // Select the first festival by default
        if (!festivalListView.getItems().isEmpty()) {
            Festival defaultFestival = festivalListView.getItems().get(0);
            festivalListView.getSelectionModel().select(festivalListView.getItems().get(0));
            jobListView.getItems().setAll(defaultFestival.getJobs());
        }

        // Event handler to display jobs when a festival is selected
        festivalListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, selectedFestival) -> {
            if (selectedFestival != null) {
                jobListView.getItems().setAll(selectedFestival.getJobs());
            } else {
                jobListView.getItems().clear();
            }
        });

        // Create listview for frivillige
        frivilligListView = new ListView<>();
        frivilligListView.getItems().addAll(Storage.getFrivillige());
        pane.add(frivilligListView, 2, 1);

        // ----------------------------- TextArea ---------------------------------
        // Create a TextArea to display information
        info = new TextArea();
        info.setEditable(false);
        info.setPrefWidth(200);
        info.setPrefHeight(200);
        pane.add(info, 3, 1);

        // Event handler to display information when a volunteer is selected
        frivilligListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, selectedFrivillig) -> {
            if (selectedFrivillig != null) {
                info.setText("Navn: " + selectedFrivillig.getNavn() + "\n"
                        + "Tlf: " + selectedFrivillig.getMobil() + "\n"
                        + "Maks timer: " + selectedFrivillig.getMaksAntalTimer() + "\n"
                        + "--------------------------------\n"
                        + "Vagter: ");
                for (Vagt vagt : selectedFrivillig.getVagter()) {
                    info.appendText("\n" + vagt.getTimer() + " timer på " + vagt.getJob().getTitel());
                }
            } else {
                info.clear();
            }
        });
        
        // Create a label for the timer input
        Label timer = new Label("Timer: ");
        pane.add(timer, 0, 2);

        // Create a textfield for the timer input
        timerInput = new TextField();
        pane.add(timerInput, 1, 2);

        // Create a button to take a vagt
        Button tagVagt = new Button("Tag vagt");
        pane.add(tagVagt, 2, 2);
        tagVagt.setOnAction(e -> tagVagt());
    }

    // METHOD to take a vagt
    public void tagVagt() {
        try {
            // Get the selected items needed to create a new Vagt
            Job selectedJob = jobListView.getSelectionModel().getSelectedItem();
            Frivillig selectedFrivillig = frivilligListView.getSelectionModel().getSelectedItem();
            int timerVagt = Integer.parseInt(timerInput.getText());

            // Create a new Vagt and add it to the selected frivillig through the Controller
            Controller.tagVagt(selectedJob, selectedFrivillig, timerVagt);

            // Update the info TextArea with the new information
            String infoText = "Navn: " + selectedFrivillig.getNavn() + "\n"
                    + "Tlf: " + selectedFrivillig.getMobil() + "\n"
                    + "Maks timer: " + selectedFrivillig.getMaksAntalTimer() + "\n"
                    + "--------------------------------\n"
                    + "Vagter: ";

            // Add the new vagt to the info TextArea
            for (Vagt vagt : selectedFrivillig.getVagter()) {
                infoText += "\n" + vagt.getTimer() + " timer på " + vagt.getJob().getTitel();
            }

            // Update the info TextArea
            jobListView.refresh();

            // Update the info TextArea to display the new information (infoText)
            info.setText(infoText);

        }

        // Add catch exceptions and display them in an alert
        catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fejl");
            alert.setHeaderText("Fejl");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }
}