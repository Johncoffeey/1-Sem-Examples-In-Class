/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfun101;

/**
 *
 * @author pgn
 */
public class AbstractFun101
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Animal animal = new Fish();
        animal.doAnimalStuff();
        animal = new Goat();
        animal.doAnimalStuff();
        animal = new Horse();
        animal.doAnimalStuff();
    }

}
