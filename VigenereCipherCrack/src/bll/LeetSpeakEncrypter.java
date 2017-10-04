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
public class LeetSpeakEncrypter implements IEncrypter
{
    
    private static final String NORMAL_SPEAK = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LEET_SPEAK =   "48(?3F6#1JX7MN09Q25+UVWXY2";
    
    
    
    @Override
    public String decode(String encryptedText, String key)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String encode(String clearText, String key)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
