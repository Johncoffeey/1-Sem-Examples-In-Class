/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.inn2power.dal;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import db.inn2power.Company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pgn
 */
public class CompanyDAO
{

    private DataBaseConnector dbConnector;

    public CompanyDAO()
    {
        dbConnector = new DataBaseConnector();
    }

    public Company createCompany(String name, String address, String country, String website, String supplyChainCat, String businessRole, double lat, double lng, int isSME) throws SQLServerException, SQLException
    {
        try (Connection con = dbConnector.getConnection())
        {
            String sql = "INSERT INTO Company VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, name);
            statement.setString(2, country);
            statement.setString(3, address);
            statement.setString(4, website);
            statement.setString(5, supplyChainCat);
            statement.setString(6, businessRole);
            statement.setDouble(7, lat);
            statement.setDouble(8, lng);
            statement.setInt(9, isSME);
            
            if (statement.executeUpdate() == 1)
            {
                //Good
                ResultSet rs = statement.getGeneratedKeys();                
                rs.next();
                int id = rs.getInt(1);
                Company c = new Company(id, name, country, address, website, supplyChainCat, businessRole, lat, lng, isSME);
                return c;
            }
            throw new RuntimeException("Can't create company");
        }
    }

    public List<Company> getAllCompanies() throws SQLException
    {
        try(Connection con = dbConnector.getConnection())
        {
            String sql = "SELECT * FROM Company";
            
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            List<Company> allCompanies = new ArrayList<>();
            while(rs.next())
            {
                int id = rs.getInt("Id");
                System.out.println("ID: " + id);
                //TODO Extract all data about company.
                //TODO Create company from data.
                //TODO Add company to lidt.
            }
            return allCompanies;
        }
    }
    
    
}
