/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3.proposed.solution;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 *
 * @author pgn
 */
public class FXMLDocumentController implements Initializable
{

    private static final String[] selections =
    {
        "Number conversion"
    };

    @FXML
    private ComboBox<String> comboAssignments;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        ObservableList<String> sels = FXCollections.observableArrayList(selections);
        comboAssignments.setItems(sels);
    }

    @FXML
    private void handleLaunchButton(ActionEvent event)
    {
        try
        {
            int selIndex = comboAssignments.getSelectionModel().getSelectedIndex();

            switch (selIndex)
            {
                case 0:
                    runNumberConversion();
                    break;
                default:
                    System.out.println("Sel: " + selIndex);
                    break;
            }
        } catch (IOException ex)
        {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void runNumberConversion() throws IOException
    {
        Stage stage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("numberConversion/NumberConversion.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.showAndWait();

    }

}
