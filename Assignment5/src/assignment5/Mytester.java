/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

import assignment5.be.Person;
import assignment5.be.Teacher;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pgn
 */
public class Mytester
{

    public void testPersons()
    {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Peter"));
        persons.add(new Person(2, "Ole"));
        persons.add(new Person(3, "Jeppe")); //Inline addition of Person
        Person p1 = new Person(4, "Stig");   //Using multiple lines to add a Person
        persons.add(p1);
        for (Person person : persons)
        {
            System.out.println(person.toString());
        }
    }

    public void testTeachers()
    {
        List<Person> teachers = new ArrayList<>();

        Teacher a = new Teacher(666, "Stig", "SSI");
        a.addSubject("ITO");
        a.addSubject("Game Dev");

        Teacher b = new Teacher(1, "Peter", "PGN");
        b.addSubject("SCO");
        b.addSubject("SDE");
        b.addSubject("Game Dev");
        b.addSubject("Life on the streets");

        teachers.add(a);
        teachers.add(b);

        for (Person teacher : teachers)
        {
            System.out.println(teacher);
        }
    }

}
