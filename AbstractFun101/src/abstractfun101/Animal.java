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
public abstract class Animal extends Object
{

    public void doAnimalStuff()
    {
        System.out.println("This animal moves:");
        this.move();
        System.out.println("Then it eats:");
        this.eat();
    }
    
    
    public abstract void move();

    public abstract void eat();

    @Override
    public String toString()
    {
        return "An animal";
    }

}
