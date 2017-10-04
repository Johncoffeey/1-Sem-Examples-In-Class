/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

/**
 *
 * @author stegg_000
 */
public class VigenereCipherEncrypter implements IEncrypter
{

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!\"#¤%&/()=?,.;:-_´|`";

    /**
     * Encodes the given text using the given key.
     *
     * @param clearText
     * @param key
     * @return
     */
    @Override
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
    @Override
    public String decode(String encryptedText, String key)
    {
        return crypto(encryptedText, key, false);
    }

    /**
     * The encryption algorithm. En- or decrypts the text using the key.
     *
     * @param payload The text to en or decrypt.
     * @param key     The key.
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
            int ki = ALPHABET.indexOf(k);
            int vi = ALPHABET.indexOf(v);
            int ti = encrypt ? (vi + ki) : (vi - ki);
            ti = (ti + ALPHABET.length()) % ALPHABET.length();
            char target = ALPHABET.charAt(ti);
            sb.append(target);
            keyIndex = ++keyIndex % key.length();
        }
        return sb.toString();
    }

}
