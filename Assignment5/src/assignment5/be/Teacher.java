/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5.be;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pgn
 */
public class Teacher extends Person
{

    private List<String> subjects;
    private String initials;
    private double salary;

    public Teacher(int id, String name, String initials)
    {
        super(id, name);
        subjects = new ArrayList<>();
        this.initials = initials;
    }

    public List<String> getSubjects()
    {
        return subjects;
    }

    public String getInitials()
    {
        return initials;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    public void addSubject(String subject)
    {
        subjects.add(subject);
    }

    @Override
    public String toString()
    {
        return super.toString() + " " + initials + " " + subjects.get(0);
    }

}
