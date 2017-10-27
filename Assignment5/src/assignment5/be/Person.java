/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5.be;

/**
 *
 * @author pgn
 */
public class Person
{

    private int id;
    private String name;
    private String email;

    public Person(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email)
    {
        this.email = email;
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
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return id + " " + name + " " + email;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Person)
        {
            Person p = (Person) obj;
            return this.id == p.getId();
        } else
        {
            return super.equals(obj);
        }
    }

}
