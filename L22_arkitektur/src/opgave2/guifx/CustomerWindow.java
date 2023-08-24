package opgave2.guifx;

import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import opgave2.application.controller.Controller;
import opgave2.application.model.Company;
import opgave2.application.model.Customer;
import opgave2.application.model.Employee;

public class CustomerWindow extends Stage {
    private Customer customer;

    private Controller controller;

    private CheckBox chbCompany;
    private ComboBox<Company> cbbCompany;


    public CustomerWindow(String titel, Customer customer) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.customer = customer;

        this.setTitle(titel);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    public CustomerWindow(String titel) {
        this(titel, null);

    }

    private TextField txfName;
    private Label lblError;


    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);


        cbbCompany = new ComboBox<>();
        pane.add(cbbCompany, 0, 5);
        cbbCompany.getItems().addAll(Controller.getCompanies());
        cbbCompany.setDisable(false);

        chbCompany = new CheckBox("Company");
        pane.add(chbCompany, 0, 7);
        ChangeListener<Boolean> listener = (ov, oldValue, newValue) -> selectedCompanyChanged(newValue);
        chbCompany.selectedProperty().addListener(listener);

        Label lblName = new Label("Name");
        pane.add(lblName, 0, 0);
        txfName = new TextField();
        pane.add(txfName, 0, 1);
        txfName.setPrefWidth(200);

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 2);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 3);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnOK.setOnAction(event -> okAction());


    }

    private void selectedCompanyChanged(Boolean newValue) {
    }

    private void cancelAction() {
        this.hide();

    }

    private void okAction() {
        String name = txfName.getText().trim();
        if (name.length() == 0) {
            lblError.setText("Name is empty");
        } else {
            boolean companyIsSelected = chbCompany.isSelected();
            Company newCompany = cbbCompany.getSelectionModel().getSelectedItem();

            // Call application.controller methods
            if (customer != null) {
                Controller.updateCustomer(customer, name);
                if (companyIsSelected) {
                    Controller.addCustomerToCompany(customer, newCompany);
                } else {
                    Controller.removeCustomerFromCompany(customer, customer.getCompany());
                }
            } else {
                if (companyIsSelected) {
                    Controller.createCustomer(name, newCompany);
                } else {
                    Controller.createCustomer(name, newCompany);
                }
            }
            hide();
        }
    }
}





            
