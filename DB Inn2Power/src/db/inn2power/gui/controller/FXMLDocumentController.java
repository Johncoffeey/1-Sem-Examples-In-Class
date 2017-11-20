/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.inn2power.gui.controller;

import db.inn2power.be.Company;
import db.inn2power.bll.exception.Inn2PowerException;
import db.inn2power.gui.model.CompanyModel;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

/**
 *
 * @author pgn
 */
public class FXMLDocumentController implements Initializable
{

    @FXML
    private ListView<Company> lstCompanies;

    private CompanyModel companyModel;

    public FXMLDocumentController()
    {
        try
        {
            companyModel = new CompanyModel();
        } catch (Inn2PowerException ex)
        {
            //SHow ERROR box
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        lstCompanies.setItems(companyModel.getCompanies());
    }

}
