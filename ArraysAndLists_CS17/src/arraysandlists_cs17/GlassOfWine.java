/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraysandlists_cs17;

/**
 *
 * @author pgn
 */
public class GlassOfWine
{

    public GlassOfWine(int number, String taste, String color)
    {
        this.number = number;
        this.taste = taste;
        this.color = color;
    }

    private int number;

    /**
     * Get the value of number
     *
     * @return the value of number
     */
    public int getNumber()
    {
        return number;
    }

    /**
     * Set the value of number
     *
     * @param number new value of number
     */
    public void setNumber(int number)
    {
        this.number = number;
    }

    private String taste;

    /**
     * Get the value of taste
     *
     * @return the value of taste
     */
    public String getTaste()
    {
        return taste;
    }

    /**
     * Set the value of taste
     *
     * @param taste new value of taste
     */
    public void setTaste(String taste)
    {
        this.taste = taste;
    }

    private String color;

    /**
     * Get the value of color
     *
     * @return the value of color
     */
    public String getColor()
    {
        return color;
    }

    /**
     * Set the value of color
     *
     * @param color new value of color
     */
    public void setColor(String color)
    {
        this.color = color;
    }

}
