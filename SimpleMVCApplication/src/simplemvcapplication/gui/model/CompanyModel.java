/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemvcapplication.gui.model;

import be.Company;
import dal.CompanyDAO;
import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import simplemvcapplication.bll.CompanySearcher;

/**
 *
 * @author pgn
 */
public class CompanyModel
{

    private ObservableList<Company> companiesInSearch;
    private CompanyDAO companyDao;
    private CompanySearcher companySearcher;

    public CompanyModel() throws IOException
    {
        companySearcher = new CompanySearcher();
        companiesInSearch = FXCollections.observableArrayList();
        companyDao = new CompanyDAO();
        companiesInSearch.addAll(companyDao.getAllCompanies());
    }

    /**
     * Gets the observable list of all the companies in view. The list responds
     * to changes made by the search method.
     *
     * @return The list of companies.
     */
    public ObservableList<Company> getCompaniesList()
    {
        return companiesInSearch;
    }

    public void search(String searchText)
    {
        List<Company> allCompanies = companyDao.getAllCompanies();
        List<Company> searchResults = companySearcher.searchByCompanyName(allCompanies, searchText);
        companiesInSearch.clear();
        companiesInSearch.addAll(searchResults);
    }

}
