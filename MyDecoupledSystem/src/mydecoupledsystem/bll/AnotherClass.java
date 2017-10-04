/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydecoupledsystem.bll;

/**
 *
 * @author pgn
 */
public class AnotherClass implements ISomeText
{

    @Override
    public String getSomeText()
    {
        return "This is some different text";
    }

}
