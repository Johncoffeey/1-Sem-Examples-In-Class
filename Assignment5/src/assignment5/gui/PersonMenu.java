/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5.gui;

/**
 *
 * @author pgn
 */
public class PersonMenu extends AbstractMenu
{

    public PersonMenu()
    {
        super("Person menu", "A", "B", "Hest");
    }

    @Override
    protected void doAction(int option)
    {
        switch (option)
        {
            case 1:
                System.out.println("You pressed 1");
                break;
            case 2:
                System.out.println("You pressed 2");
                break;
            case 3:
                doOptionThree();
                break;
            default:
                System.out.println("???");
                break;
        }
    }

    private void doOptionThree()
    {
        System.out.println("Line 1");
        System.out.println("Line 2");
        System.out.println("Line 3");
    }

}
