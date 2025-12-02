package com.gdstruc.quiz5;

public class Main {
    public static void main(String[] args)
    {
        //Sample array, set targets here
        int[] arrayToBeSearched = {1, 10, 5, 6, 18, 23, 9, 7, 14};
        int target = 25;
        int indexOfTarget;

        //Find the target
        indexOfTarget = StatisticPurgatory(target, arrayToBeSearched);

        if (indexOfTarget == -1)
        {
            System.out.println("Index of number " + target + " cannot be found in the array.");
        }
        else
        {
            System.out.println("Index of number " + target + " is at " + indexOfTarget + ".");
        }

    }

    private static int StatisticPurgatory(int target, int[] array)
    {
        //Index to be returned
        int index = 0;

        //Stat values
        float average;
        float stDev;
        int stDevCounter = 0;

        //Value filter
        boolean[] isValid = new boolean[array.length];

        //Calculate Stat terms
        average = CalculateAverage(array);
        System.out.println("Average: " + average);

        stDev = CalculateStandardDeviation(array, average);
        System.out.println("Standard Deviation: " + stDev);
        //Count the # of standard deviations away the target is from the average
        do {
            stDevCounter++;
        } while (!IsWithinBounds(target, average, stDev, stDevCounter));

        System.out.println("Standard Deviation Counter: " + stDevCounter);

        //Set all values of isValid to true
        for (int i = 0; i < isValid.length; i++)
        {
            isValid[i] = true;
        }

        //Filter out the values not within the stDev range
        //Limit is set to 4 as 99.7% of values are already within three STDev away from the average
        for (int i = 1; i <= 4; i++) {
            // If i == stdevcounter, skip the loop as those values are in the same range as the target
            if (i != stDevCounter) {
                for (int j = 0; j < array.length; j++) {
                    if (IsWithinBounds(array[j], average, stDev, i) && !IsWithinBounds(array[j], average, stDev, stDevCounter)) {
                        isValid[j] = false;
                    }
                }
            }
        }

        //Find the index in the filtered array thru linear probing
        while (index < array.length)
        {
            if (isValid[index])
            {
                if (array[index] == target)
                {
                    return index;
                }
            }

            index++;
        }

        index = -1;

        return index;
    }

    private static float CalculateAverage(int[] array)
    {
        float sum = 0;
        float average;

        for (int num : array) {
            sum += num;
        }

        average = sum / array.length;

        return average;
    }

    private static float CalculateStandardDeviation(int[] array, float average)
    {
        float summation = 0;
        float standardDeviation;

        for (int num : array)
        {
            summation += (float) Math.pow(((float)num - average), 2);
        }

        standardDeviation = (float)Math.sqrt((summation / (float)array.length));

        return standardDeviation;
    }

    private static boolean IsWithinBounds(int value, float average, float standardDeviation, int counter)
    {
        return (value > average - (standardDeviation * counter) && value < average + (standardDeviation * counter));
    }
}