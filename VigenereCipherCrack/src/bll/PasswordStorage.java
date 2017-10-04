/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import be.EncryptionKey;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pgn
 */
public class PasswordStorage
{

    private List<String> storedPasswords;

    public PasswordStorage()
    {
        storedPasswords = new ArrayList<>();
        populatePasswords();
    }

    /**
     * Populates the list of stored passwords, using the top 10 most common
     * passwords.
     */
    private void populatePasswords()
    {
        storedPasswords.add("password");
        storedPasswords.add("football");
        storedPasswords.add("qwerty");
        storedPasswords.add("princess");
        storedPasswords.add("login");
        storedPasswords.add("welcome");
        storedPasswords.add("solo");
        storedPasswords.add("admin");
        storedPasswords.add("flower");
    }

    /**
     * Gets the list of stored encryption keys.
     *
     * @return
     */
    public List<EncryptionKey> getEncryptionKeys()
    {
        List<EncryptionKey> all = new ArrayList<>();
        for (String pass : storedPasswords)
        {
            all.add(new EncryptionKey(pass));
        }
        return all;
    }

    /**
     * Stores a new encryptionkey in the list of passwords.
     *
     * @param key
     */
    public void storeEncryptionKey(EncryptionKey key)
    {
        storedPasswords.add(key.getEncryptionKey());
    }

}
