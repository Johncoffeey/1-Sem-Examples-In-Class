/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithjavafx_cs17;

/**
 *
 * @author pgn
 */
public class FunModel
{
    
    public String getSomeText()
    {
        return "Some text";
    }
    
    public String toUpperCase(String text)
    {
        
        
        return text.toUpperCase();
    }
    
    public int doSomeMagic(int x, int y)
    {
        return Math.min(x, y);
    }
    
}
