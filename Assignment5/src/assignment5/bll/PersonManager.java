/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5.bll;

import assignment5.be.Person;
import assignment5.be.Student;
import assignment5.be.Teacher;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pgn
 */
public class PersonManager
{

    private List<Person> persons;

    public PersonManager()
    {
        persons = new ArrayList<>();
    }

    public Person getPerson(int id)
    {
        for (Person person : persons)
        {
            if (person.getId() == id)
            {
                return person;
            }
        }
        return null;
    }
    
    
    
    

    public void removePerson(int id)
    {
        for (int i = 0; i < persons.size(); i++)
        {
            if (persons.get(i).getId() == id)
            {
                persons.remove(i);
                return;
            }
        }
    }

    public List<Person> getAllPersons()
    {
        return persons;
    }

    public List<Student> getAllStudents()
    {
        List<Student> students = new ArrayList<>();
        for (Person person : persons)
        {
            if (person instanceof Student)
            {
                students.add((Student) person);
            }
        }
        return students;
    }

    public List<Teacher> getAllTeachers()
    {
        List<Teacher> teachers = new ArrayList<>();
        for (Person person : persons)
        {
            if (person instanceof Teacher)
            {
                teachers.add((Teacher) person);
            }
        }
        return teachers;
    }

    public void addPerson(Person p)
    {
        if (!persons.contains(p))
        {
            persons.add(p);
        }
    }

}
