/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import be.Person;
import java.util.List;

/**
 *
 * @author Stegger
 */
public class PersonRepository
{
    public SerializableRepository repo;
    
    public PersonRepository()
    {
        repo = SerializableRepository.getInstance();
    }
    
    public List<Person> getAllPersons()
    {
        return repo.getAll(Person.class);
    }
    
    public void createPerson()
    {
        
    }
            
}
