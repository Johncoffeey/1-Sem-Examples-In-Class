/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraysandlists_cs17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author pgn
 */
public class FunWithArrays
{

    private String[] names;

    public FunWithArrays()
    {

    }
    
    public void binarySearch()
    {
        int[] numbers = new int[100000000];
        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = i;
        }
        
        Arrays.sort(numbers);
        
        int value = 42;
        
        int idx = Arrays.binarySearch(numbers, value);
        
        System.out.println("42 at " + idx);
        
        
        
        
    }

    public void linearSearchingInArrays()
    {
        int[] numbers = new int[100000000];
        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = numbers.length - (i + 1);
        }
        
        int indexOf9000 = -1;
        int value = 1;
        for(int j = 0; j<numbers.length; j++)
        {
            if(numbers[j] == value)
            {
                indexOf9000 = j;
                break;
            }
        }
        
        System.out.println("Value found at " + indexOf9000);
    }

    public void arrayListFun()
    {
        ArrayList<String> moreNames = new ArrayList<>();
        int length = moreNames.size();
        System.out.println("Elements in moreNames = " + length);

        moreNames.add("Peter Stegger");
        moreNames.add("  Jeppe");
        moreNames.add(" Stig ");

        length = moreNames.size();
        System.out.println("Elements in moreNames = " + length);

        for (String moreName : moreNames)
        {
            System.out.println("A name " + moreName);
            System.out.println("Characters in name "
                    + moreName + " is " + moreName.trim().length());
        }

    }

    public void arrayFun()
    {
        names = new String[3];

        int l = names.length;

        System.out.println("Length of array = " + l);

        names[0] = "Peter";
        names[1] = "Jeppe";
        names[2] = "Stig";

        System.out.println(names[0]);
        System.out.println(names[1]);
        System.out.println(names[2]);

        for (String name : names)
        {
            System.out.println("Teacher: " + name);
        }
    }

}
