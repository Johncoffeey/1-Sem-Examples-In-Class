/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inn2power.pkg1sem2017.be;

/**
 *
 * @author Stegger
 */
public class Relation
{

    private Company source;
    private Company target;

    /**
     * Constructs a relation between two companies.
     *
     * @param source
     * @param target
     */
    public Relation(Company source, Company target)
    {
        this.source = source;
        this.target = target;
    }

    /**
     * Gets the source of the relation.
     *
     * @return
     */
    public Company getSource()
    {
        return source;
    }

    /**
     * Gets the target of the relation.
     *
     * @return
     */
    public Company getTarget()
    {
        return target;
    }

}
