/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;

import be.EncryptionKey;
import gui.model.EncryptionModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Stegger
 */
public class EncryptionViewController implements Initializable
{
    
    @FXML
    private TextField txtKey;
    @FXML
    private TextArea txtPayload;
    @FXML
    private ListView<EncryptionKey> listPasswords;
    
    private EncryptionModel model;

    /**
     * Constructs the controller.
     */
    public EncryptionViewController()
    {
        model = new EncryptionModel();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        listPasswords.setItems(model.getAllEncryptionKeys());
    }
    
    @FXML
    private void handleEncrypt(ActionEvent event)
    {
        //TODO Do this
    }
    
    @FXML
    private void handleDecrypt(ActionEvent event)
    {
        //TODO Do this
    }
    
    @FXML
    private void handleSaveKey(ActionEvent event)
    {
        //TODO Do this
    }
    
}
