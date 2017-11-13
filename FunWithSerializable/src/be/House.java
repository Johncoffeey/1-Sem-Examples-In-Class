/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Stegger
 */
public class House implements Serializable
{
    
   transient private ArrayList<Person> occupants;
    private String adress;
    
    public House(String adress)
    {
        this.adress = adress;
        occupants = new ArrayList<>();
    }
    
    public House(String adress, Person... occupants)
    {
        this(adress);
        for (Person occupant : occupants)
        {
            this.occupants.add(occupant);
        }
    }
    
    public Person[] getOccupants()
    {
        return occupants.toArray(new Person[occupants.size()]);
    }
    
    public String getAdress()
    {
        return adress;
    }
    
    public void setAdress(String adress)
    {
        this.adress = adress;
    }
    
    public void removePerson(Person person)
    {
        if (occupants.contains(person))
        {
            occupants.remove(person);
        }
    }
    
}
