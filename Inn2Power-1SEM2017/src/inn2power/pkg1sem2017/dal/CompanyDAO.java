/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inn2power.pkg1sem2017.dal;

import inn2power.pkg1sem2017.be.Company;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stegger
 */
public class CompanyDAO
{

    private static CompanyDAO INSTANCE;
    
    private File data = new File("data/COMPANIES.csv");
    private List<Company> companies;

    private CompanyDAO()
    {
        
    }

    public List<Company> getAllCompanies() throws FileNotFoundException
    {
        ArrayList<Company> companies = new ArrayList<>();
        String line = "";
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(data));)
        {
            while ((line = br.readLine()) != null)
            {
                // use comma as separator
                String[] company = line.split(cvsSplitBy);
                Company comp = new Company(Integer.parseInt(company[0]), company[1]);
                companies.add(comp);
            }

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return companies;
    }
}
