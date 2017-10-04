/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

/**
 *
 * @author pgn
 */
public interface IEncrypter
{

    /**
     * Decodes the given text using the given key.
     *
     * @param encryptedText
     * @param key
     * @return
     */
    String decode(String encryptedText, String key);

    /**
     * Encodes the given text using the given key.
     *
     * @param clearText
     * @param key
     * @return
     */
    String encode(String clearText, String key);
    
}
