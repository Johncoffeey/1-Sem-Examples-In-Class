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
public class Horse extends Animal
{

    @Override
    public void eat()
    {
        System.out.println("The horse eats.");
    }

    @Override
    public void move()
    {
        System.out.println("The horse gallops");
    }

}
