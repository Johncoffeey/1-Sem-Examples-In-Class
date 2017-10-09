/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inn2power.pkg1sem2017.gui.controller;

import inn2power.pkg1sem2017.be.Company;
import inn2power.pkg1sem2017.be.Relation;
import inn2power.pkg1sem2017.gui.model.Inn2PowerModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author Stegger
 */
public class Inn2PowerViewController implements Initializable
{

    @FXML
    private Label lblCompanyId;
    @FXML
    private Label lblCompanyName;
    @FXML
    private ListView<Company> listCompanies;
    @FXML
    private ListView<Relation> listRelations;

    private Inn2PowerModel model;

    public Inn2PowerViewController()
    {
        model = new Inn2PowerModel();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }

}
