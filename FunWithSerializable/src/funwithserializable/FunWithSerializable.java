/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithserializable;

import be.House;
import be.Person;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stegger
 */
public class FunWithSerializable
{

    public static void main(String[] args)
    {
        //First I create some SERIALIZABLE Person objects:
        Person p1 = new Person("Peter", 34, "M");
        Person p2 = new Person("Ole", 45, "M");
        Person p3 = new Person("Anne-Mette", 44, "F");

        ArrayList<Person> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);

        //Saving to file:
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("persons.ser")))
        {
            for (Person person : persons) //For all persons in the list:
            {
                //I write a aingle Person object to the file:
                oos.writeObject(person);
            }
        } catch (IOException ex)
        {
            //Do nothing
            System.out.println(ex.getMessage());
        }
        System.out.println("3 persons written to file!");

        //Reading from file:
        ArrayList<Person> altPersons = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("persons.ser")))
        {
            while (true) //Infinite loop... (Is this good?)
            {
                Person o = (Person) ois.readObject();
                altPersons.add(o);
            }
        } catch (EOFException eofe)
        {
            //Do nothing. Expecting to reach the end of file.
        } catch (IOException | ClassNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }

        //I print out all the persons I read from the file..!
        for (Person altPerson : altPersons)
        {
            System.out.println(altPerson.getName());
        }

    }
    
    
    
    
    
    
    

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) throws Exception
//    {
//
//        SerializableRepository repo = SerializableRepository.getInstance();
//
//        try
//        {
//            repo.loadState();
//        } catch (Exception e)
//        {
//            System.out.println(e.getMessage());
//        }
//
//        ArrayList<Person> ps = new ArrayList<>();
//        ArrayList<House> houses = new ArrayList<>();
//        for (House house : repo.getAll(House.class))
//        {
//            houses.add(house);
//        }
//        for (House house : houses)
//        {
//            for (Person p : house.getOccupants())
//            {
//                if (ps.contains(p))
//                {
//                    System.out.println(p.getName() + " exists, succes!!");
//                }
//                else
//                {
//                    ps.add(p);
//                }
//            }
//        }
//
////        for (Person px : h1.getOccupants())
////        {
////            for (Person py : h2.getOccupants())
////            {
////                if (px.equals(py))
////                {
////                    System.out.println(px.getName() + " equals " + py.getName());
////                }
////            }
////        }
////        for (Person person : repo.getAll(Person.class))
////        {
////            System.out.println(person.getName());
////        }
////
////        repo.saveState();
////        FunWithSerializable.storeObjectToFile(h1, "House1.ser");
////        FunWithSerializable.storeObjectToFile(h2, "House2.ser");
////
////        House houseA = FunWithSerializable.readObjectFromFile("House1.ser");
////        House houseB = FunWithSerializable.readObjectFromFile("House2.ser");
////
////        System.out.println("Objects from file:");
////
////        for (Person px : houseA.getOccupants())
////        {
////            for (Person py : houseB.getOccupants())
////            {
////                if (px.equals(py))
////                {
////                    System.out.println(px.getName() + " equals " + py.getName());
////                }
////
////            }
////        }
//    }
    private static void storeObjectToFile(Serializable ser, String file)
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file)))
        {
            oos.writeObject(ser);
        } catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    private static House readObjectFromFile(String house1ser)
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(house1ser)))
        {
            return (House) ois.readObject();
        } catch (IOException | ClassNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
        return null;
    }

}
