/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Stegger
 */
public class SerializableRepository implements IRepository
{

    private static SerializableRepository INSTANCE;

    HashMap<Class, List<Serializable>> objectStore;

    private SerializableRepository()
    {
        objectStore = new HashMap<>();
    }

    public synchronized static SerializableRepository getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new SerializableRepository();
        }
        return INSTANCE;
    }

    /**
     * Adds an serilizable object to our persistent storage. But only if it
     * isn't already there.
     *
     * @param ser Object to store.
     */
    public void addObject(Serializable ser)
    {
        if (objectStore.containsKey(ser.getClass()))
        {
            if (!objectStore.get(ser.getClass()).contains(ser))
            {
                objectStore.get(ser.getClass()).add(ser);
            }
        } else
        {
            objectStore.put(ser.getClass(), new ArrayList<>());
            objectStore.get(ser.getClass()).add(ser);
        }
    }

    /**
     * Deletes the given object from the object hierachy.
     *
     * @param ser
     */
    public void deleteObject(Serializable ser)
    {
        if (objectStore.containsKey(ser.getClass()))
        {
            if (objectStore.get(ser.getClass()).contains(ser))
            {
                objectStore.get(ser.getClass()).remove(ser);
            }
        }
    }

    /**
     * Returns all of a given type.
     *
     * @param <T>
     * @param type
     * @return
     */
    public <T> List<T> getAll(Class<T> type)
    {
        ArrayList<T> results = new ArrayList<>();
        objectStore.get(type).stream().forEach((t)
                -> 
                {
                    results.add((T) t);
        });
        return results;
    }

    @Override
    public void saveState() throws IOException
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("objectStore.ser")))
        {
            oos.writeObject(objectStore);
            oos.flush();
        }
    }

    @Override
    public void loadState() throws IOException
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("objectStore.ser")))
        {
            objectStore = (HashMap<Class, List<Serializable>>) ois.readObject();
        } catch (ClassNotFoundException ex)
        {
            throw new IOException(ex);
        }
    }

}
