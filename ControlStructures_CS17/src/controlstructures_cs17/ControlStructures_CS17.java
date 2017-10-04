/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlstructures_cs17;

/**
 *
 * @author pgn
 */
public class ControlStructures_CS17
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ControlStructures_CS17 cs = new ControlStructures_CS17();
//        cs.logicalExpressionsAndObjects();
        cs.funWithLoops();;
    }

    public String logicalExpression1(int x)
    {
        if (x != 10)
        {
            return "X(" + x + ") er ikke lig med 10";
        } else
        {
            return "X(" + x + ") er lig med 10";
        }
    }

    public void logicalExpressionsAndObjects()
    {
        Person p1 = new Person("Jeppe", 36);
        Person p2 = new Person("Jeppe", 36);

        if (p1 == p2)
        {
            System.out.println("Jeppe and Jeppe are the same");
        } else
        {
            System.out.println("Jeppe and Jeppe are not the same");
        }

    }

    /**
     * Many ways to count to 10
     */
    public void funWithLoops()
    {
        //Normal for loop:
        for (int i = 1; i <= 10; i++)
        {
            System.out.println("i is " + i);
        }

        //Fragmented for loop:
        int x = 1;
        for (; x <= 10;)
        {
            System.out.println("i == " + x);
            x++;
        }

        //While loop:
        System.out.println("While loop:");
        int i = 0;
        while (i < 10)
        {
            i++;
            System.out.println("i is " + i);
        }

        do
        {
            System.out.println("I will always run");
        } while(false);
                
                
    }

}
