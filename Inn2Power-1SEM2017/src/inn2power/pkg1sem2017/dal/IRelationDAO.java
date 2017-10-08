/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inn2power.pkg1sem2017.dal;

import inn2power.pkg1sem2017.be.Relation;
import java.util.List;

/**
 *
 * @author Stegger
 */
public interface IRelationDAO
{

    public List<Relation> getAllRelations();
    
}
