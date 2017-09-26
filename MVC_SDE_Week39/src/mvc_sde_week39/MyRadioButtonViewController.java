/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc_sde_week39;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

/**
 *
 * @author pgn
 */
public class MyRadioButtonViewController implements Initializable
{

    @FXML
    private Button button;

    @FXML
    private RadioButton rBtn;
    @FXML
    private RadioButton rBtn2;
    @FXML
    private RadioButton rBtnX;

    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        int score = 0;
        if (rBtn.isSelected())
        {
            score = -1;
        } else if (rBtn2.isSelected())
        {
            score = 0;
        } else if (rBtnX.isSelected())
        {
            score = 1;
        }
        System.out.println("Score is " + score);
        
        ((Stage)button.getScene().getWindow()).close(); //This line will close the current window
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        
    }

}
