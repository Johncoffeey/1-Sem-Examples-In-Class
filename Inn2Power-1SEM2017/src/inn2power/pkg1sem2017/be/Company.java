/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inn2power.pkg1sem2017.be;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Stegger
 */
public class Company
{
    /**
     * Constructs a company with the given ID and name.
     * @param id
     * @param name 
     */
    public Company(int id, String name)
    {
        this.id.set(id);
        this.name.setValue(name);
    }
    
    private final IntegerProperty id = new SimpleIntegerProperty();
    
    public int getId()
    {
        return id.get();
    }
    
    public IntegerProperty idProperty()
    {
        return id;
    }
    
    private final StringProperty name = new SimpleStringProperty();
    
    public String getName()
    {
        return name.get();
    }
    
    public void setName(String value)
    {
        name.set(value);
    }
    
    public StringProperty nameProperty()
    {
        return name;
    }
    
}
