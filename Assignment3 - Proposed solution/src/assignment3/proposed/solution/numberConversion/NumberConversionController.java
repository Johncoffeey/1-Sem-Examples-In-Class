/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3.proposed.solution.numberConversion;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

/**
 * FXML Controller class
 *
 * @author pgn
 */
public class NumberConversionController implements Initializable
{

    @FXML
    private Button btnKmToMiles;
    @FXML
    private Button btnMilesToKm;
    @FXML
    private Label label;
    @FXML
    private TextField txtNumberInput;

    private NumberConversionModel ncmodel;

    public NumberConversionController()
    {
        ncmodel = new NumberConversionModel();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        TextInputDialog dialog = new TextInputDialog("");

        dialog.setTitle("Text Input Dialog");
        dialog.setContentText("Please enter your name:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent())
        {
            String message = ncmodel.getGreetingsMessage(result.get());
            label.setText(message);
        }

    }

    /**
     * Handles the eventhandling of the km to miles, and miles to km, buttons.
     *
     * @param event
     */
    @FXML
    private void handleButtonConversion(ActionEvent event)
    {
        Button source = (Button) event.getSource();
        String resultAsString = "N/A";
        double txtFieldValue = Double.parseDouble(txtNumberInput.getText());
        double result = 0;
        if (source == btnMilesToKm)
        {
            result = ncmodel.getMilesFromKilometers(txtFieldValue);

        } else if (source == btnKmToMiles)
        {
            result = ncmodel.getKilometersFromMiles(txtFieldValue);
        }
        resultAsString = String.format("%.3f", result);
        label.setText(resultAsString);
    }

}
