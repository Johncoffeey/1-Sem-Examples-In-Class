/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc_sde_week39;

import com.sun.glass.ui.Screen;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pgn
 */
public class ADifferentViewController implements Initializable
{

    @FXML
    private TextField txtName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }

    @FXML
    private void handleClickMeButton(ActionEvent event) throws IOException
    {
        for (int i = 0; i < 100; i++) //Change to "while(true)" to really mess with the user:
        {
            Parent root = FXMLLoader.load(getClass().getResource("MyRadioButtonView.fxml"));

            Scene scene = new Scene(root);

            
            //Stage stage = (Stage) txtName.getScene().getWindow(); //Gets the current stage
            Stage stage = new Stage(); //Create new stage

            Random rnd = new Random();

            stage.setX(rnd.nextDouble() * Screen.getMainScreen().getWidth());
            stage.setY(rnd.nextDouble() * Screen.getMainScreen().getHeight());

            stage.setScene(scene);
            stage.show();
        }
    }

    public void getScores()
    {
        
    }

}
