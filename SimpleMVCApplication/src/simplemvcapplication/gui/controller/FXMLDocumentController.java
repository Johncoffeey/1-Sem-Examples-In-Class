/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemvcapplication.gui.controller;

import simplemvcapplication.gui.model.CompanyModel;
import be.Company;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author pgn
 */
public class FXMLDocumentController implements Initializable
{

    @FXML
    private Label label;
    @FXML
    private ListView<Company> listCompanies;
    @FXML
    private TextField txtSearch;

    private CompanyModel companyModel;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        try
        {
            companyModel = new CompanyModel();
            listCompanies.setItems(companyModel.getCompaniesList());
        } catch (IOException ex)
        {
            //DO nothing for now...
        }
    }

    @FXML
    private void handleCompanySearch(ActionEvent event)
    {
        String searchText = txtSearch.getText().trim();
        if (!searchText.isEmpty())
        {
            companyModel.search(searchText);
        }
    }

}
