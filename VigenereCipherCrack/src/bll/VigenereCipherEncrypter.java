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
 * @author stegg_000
 */
public class VigenereCipherEncrypter
{

    private ViginereCipherAlphabet alphabet;
    private List<String> storedPasswords;

    /**
     * Constructs a new VigenereCipherEncrypter object
     */
    public VigenereCipherEncrypter()
    {
        alphabet = new ViginereCipherAlphabet();
        storedPasswords = new ArrayList<>();
        populatePasswords();
    }

    /**
     * Populates the list of stored passwords, using the top 10 most common passwords.
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

    /**
     * Encodes the given text using the given key.
     *
     * @param clearText
     * @param key
     * @return
     */
    public String encode(String clearText, String key)
    {
        return crypto(clearText, key, true);
    }

    /**
     * Decodes the given text using the given key.
     *
     * @param encryptedText
     * @param key
     * @return
     */
    public String decode(String encryptedText, String key)
    {
        return crypto(encryptedText, key, false);
    }

    /**
     * The encryption algorithm. En- or decrypts the text using the key.
     *
     * @param payload The text to en or decrypt.
     * @param key The key.
     * @param encrypt To encrypt or not to encrypt? That is the question!
     * @return
     */
    private String crypto(String payload, String key, boolean encrypt)
    {
        payload = payload.toUpperCase().replace(" ", "");
        key = key.toUpperCase().replace(" ", "");
        StringBuilder sb = new StringBuilder();
        int keyIndex = 0;
        for (int i = 0; i < payload.length(); i++)
        {
            char k = key.charAt(keyIndex);
            char v = payload.charAt(i);
            int ki = alphabet.getAlphabet().indexOf(k);
            int vi = alphabet.getAlphabet().indexOf(v);
            int ti = encrypt ? (vi + ki) : (vi - ki);
            ti = (ti + alphabet.getAlphabet().length()) % alphabet.getAlphabet().length();
            char target = alphabet.getAlphabet().charAt(ti);
            sb.append(target);
            keyIndex = ++keyIndex % key.length();
        }
        return sb.toString();
    }

}
