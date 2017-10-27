/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

import assignment5.be.GradeInfo;
import assignment5.be.Person;
import assignment5.be.Student;
import assignment5.be.Teacher;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pgn
 */
public class Mytester
{
    
    public void testStudents()
    {
        List<Person> students = new ArrayList<>();
        
        Student a = new Student(1, "Anders And", "DMU");
        a.addGrade(new GradeInfo("SCO", 7));
        a.addGrade(new GradeInfo("SDE", 2));
        
        Student b = new Student(2, "Fætter Højben", "DMU");
        b.addGrade(new GradeInfo("SCO", 12));
        b.addGrade(new GradeInfo("SDE", 10));
        
        Student c = new Student(3, "Fætter Guf", "MDU");
        c.addGrade(new GradeInfo("Interaktive Medier", 0));
        c.addGrade(new GradeInfo("Spiludvikling", 12));

        students.add(a);
        students.add(b);
        students.add(c);
        
        for (Person student : students)
        {
            System.out.println(student);
        }
    }

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
