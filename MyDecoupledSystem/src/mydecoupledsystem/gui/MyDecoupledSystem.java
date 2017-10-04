/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydecoupledsystem.gui;

import mydecoupledsystem.bll.ASpecificClass;
import mydecoupledsystem.bll.AnotherClass;
import mydecoupledsystem.bll.ISomeText;

/**
 *
 * @author pgn
 */
public class MyDecoupledSystem
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("This is an awesome application");
        System.out.println("It's console based!");
        System.out.println("My GUI (This class) is based on a dependency to a specific class");

        ISomeText dependency = new AnotherClass();
        
        System.out.println("Let me get some text: " + dependency.getSomeText());
    }

}
