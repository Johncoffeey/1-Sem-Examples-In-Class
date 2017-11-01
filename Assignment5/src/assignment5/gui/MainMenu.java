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
public class MainMenu extends AbstractMenu
{

    public MainMenu()
    {
        super("Main menu", "Option A", "Person menu", "Option C");
    }

    @Override
    protected void doAction(int option)
    {
        switch(option)
        {
            case 1:
                System.out.println("You chose option 1");
                break;
            case 2:
                new PersonMenu().run();
                break;
            case 3:
                System.out.println("Hest");
                break;
            default:
                System.out.println("This should not happen");
                break;
        }
    }
    
}
