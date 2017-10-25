/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pgn
 */
public class Mytester
{

    public void test()
    {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Peter"));
        persons.add(new Person(2, "Ole"));
        persons.add(new Person(3, "Jeppe"));
        Person p1 = new Person(4, "Stig");
        persons.add(p1);
        for (Person person : persons)
        {
            System.out.println(person.toString());
        }
    }

}
