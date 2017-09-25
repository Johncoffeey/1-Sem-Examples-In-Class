/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithjavafx_cs17;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author pgn
 */
public class FXMLDocumentController implements Initializable
{

    private FunModel model;

    @FXML
    private Label label;

    public FXMLDocumentController()
    {
        model = new FunModel();
    }

    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        System.out.println("You clicked me! Again");
        String t = "bla bla bla";
        label.setText(model.toUpperCase(t) + model.doSomeMagic(2, 20909327));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

    }

}
