/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inn2power.pkg1sem2017.bll;

import inn2power.pkg1sem2017.dal.CompanyDAO;
import inn2power.pkg1sem2017.dal.IRelationDAO;

/**
 *
 * @author Stegger
 */
public class Inn2PowerLogic
{
    
    private CompanyDAO companyDao;
    private IRelationDAO relationDAO;

    public Inn2PowerLogic(IRelationDAO relationDAO)
    {
        this.relationDAO = relationDAO;
        
    }
    
    
    
}
