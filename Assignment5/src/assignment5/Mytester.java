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
import assignment5.bll.PersonManager;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pgn
 */
public class Mytester
{
    
    public void testPersonManager()
    {
        PersonManager pm = new PersonManager();
        
        Teacher t1 = new Teacher(1, "Peter", "PGN");
        Teacher t2 = new Teacher(2, "Jeppe", "JLE");
        
        Student s1 = new Student(101, "Anders And", "DMU");
        Student s2 = new Student(102, "Fætter Højben", "DMU");
        Student s3 = new Student(103, "Fætter Guf", "DMU");
        
        pm.addPerson(t1);
        pm.addPerson(t2);
        pm.addPerson(s1);
        pm.addPerson(s2);
        pm.addPerson(s3);
        
        System.out.println("Person count: Actual=" + pm.getAllPersons().size() + ", expected=5");
        System.out.println("Student count: Actual=" + pm.getAllStudents().size() + ", expected=3");
        System.out.println("Teacher count: Actual=" + pm.getAllTeachers().size() + ", expected=2");
        
        Person p = pm.getPerson(1);
        System.out.println("Person with id=1 is " + p.getName() + ", actual id=" + p.getId());
        
        Person pNull = pm.getPerson(3);
        System.out.println("Person with id 3 is null?: " + pNull);
        
        Person pDobbelganger = new Teacher(1, "bØRGE", "NaN");
        pm.addPerson(pDobbelganger);
        System.out.println("Is size still 5? Size is " + pm.getAllPersons().size());
        
        pm.removePerson(101);
        System.out.println("Remove test: P size = " + pm.getAllPersons().size() + "(4)");
    }
    
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

//    public void testPersons()
//    {
//        List<Person> persons = new ArrayList<>();
//        persons.add(new Person(1, "Peter"));
//        persons.add(new Person(2, "Ole"));
//        persons.add(new Person(3, "Jeppe")); //Inline addition of Person
//        Person p1 = new Person(4, "Stig");   //Using multiple lines to add a Person
//        persons.add(p1);
//        for (Person person : persons)
//        {
//            System.out.println(person.toString());
//        }
//    }

    public void testTeachers()
    {
        List<Person> hest = new ArrayList<>();

        Teacher a = new Teacher(666, "Stig", "SSI");
        a.addSubject("ITO");
        a.addSubject("Game Dev");

        Teacher b = new Teacher(1, "Peter", "PGN");
        b.addSubject("SCO");
        b.addSubject("SDE");
        b.addSubject("Game Dev");
        b.addSubject("Life on the streets");

        hest.add(a);
        hest.add(b);

        for (Person teacher : hest)
        {
            System.out.println(teacher);
        }
    }

}
