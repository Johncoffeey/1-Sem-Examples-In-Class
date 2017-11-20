/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.inn2power;

import db.inn2power.be.Company;
import db.inn2power.dal.CompanyDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author pgn
 */
public class DBInn2Power extends Application
{
    
    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IOException
    {
        CompanyDAO companyDao = new CompanyDAO();
        
        //SQL Injection Example ONE:
        List<Company> allCompaniesEmpty = companyDao.getCompaniesInAnSqlInjectionInsecureWay("Ole' OR 'a'='a");
        for (Company company : allCompaniesEmpty)
        {
            System.out.println(company);
        }
        
        //SQL Injection Exammple TWO (Carefull here):
//        List<Company> allCompaniesEmptyTwo = companyDao.getCompaniesInAnSqlInjectionInsecureWay("Ole'; DELETE FROM Company WHERE 'a'='a");
        
        
        
        //launch(args);
    }
    
}
