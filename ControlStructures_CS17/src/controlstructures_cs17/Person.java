/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlstructures_cs17;

/**
 *
 * @author pgn
 */
public class Person
{

    private String name;
    private int age;
    
    
    
    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    

    /**
     * Get the value of age
     *
     * @return the value of age
     */
    public int getAge()
    {
        return age;
    }

    /**
     * Set the value of age
     *
     * @param age new value of age
     */
    public void setAge(int age)
    {
        this.age = age;
    }

    
    
}
