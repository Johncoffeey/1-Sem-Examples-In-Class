/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.inn2power.gui.model;

import db.inn2power.be.Company;
import db.inn2power.bll.CompanyManager;
import db.inn2power.bll.exception.Inn2PowerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author pgn
 */
public class CompanyModel
{

    private final ObservableList<Company> companiesInView;
    private CompanyManager companyManager;
    
    public CompanyModel() throws Inn2PowerException
    {
        this.companiesInView = FXCollections.observableArrayList();
        companyManager = new CompanyManager();
        companiesInView.addAll(companyManager.getAllCompanies());
    }

    public ObservableList<Company> getCompanies()
    {
        return companiesInView;
    }
    
    public void createCompany(String name)
    {
        
    }

}
