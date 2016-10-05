package com.lackwits.rpgtoolkit;

/**
 * Created by Danny on 02/03/2016.
 */
public class Dice
{
    public Dice ()
    {}

    public int[] rollPool(int pool, int size )
    {
        int[] result = new int[pool];

        for (int i = 0; i < pool; i++)
        {
            //+ add loop to reroll results
                //+ add exploding dice to reroll
            result[i] = (int)( size * Math.random() ) + 1;
        }

        //+ add method to sort results

        return result;
    }

    public int rollSingle ( int size )
    {
        return (int)( size * Math.random() ) + 1;
    }
}
