/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3.proposed.solution.numberConversion;

/**
 *
 * @author pgn
 */
public class NumberConversionModel
{

    private static final double MILE_TO_KM = 1.609344;

    /**
     * Returns the standard greeting.
     *
     * @param name The name to greet
     * @return
     */
    public String getGreetingsMessage(String name)
    {
        return "Hello, " + name + ". Greetings from the top Java developer class in town";
    }

    /**
     * Converts km to miles
     *
     * @param km The km to convert
     * @return
     */
    public double getMilesFromKilometers(double km)
    {
        return (km / MILE_TO_KM);
    }

    /**
     * Converts miles to km
     *
     * @param miles The miles to convert
     * @return
     */
    public double getKilometersFromMiles(double miles)
    {
        return (miles * MILE_TO_KM);
    }

}
