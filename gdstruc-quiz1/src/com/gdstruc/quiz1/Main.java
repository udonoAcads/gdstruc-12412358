package com.gdstruc.quiz1;

public class Main {
    public static void main(String[] args) {

        int[] numbers1 = GenerateNumbers();
        int[] numbers2 = GenerateNumbers();

        System.out.println("Unsorted Array 1: ");
        PrintArray(numbers1);

        BubbleSort(numbers1);

        System.out.println("\nSorted Array Thru Bubble Sort: ");
        PrintArray(numbers1);

        System.out.println("\nUnsorted Array 2: ");
        PrintArray(numbers2);

        SelectionSort(numbers2);

        System.out.println("\nSorted Array Thru Selection Sort: ");
        PrintArray(numbers2);

    }

    private static int[] GenerateNumbers()
    {
        int[] newNumbers = new int[10];

        for (int i = 0; i < newNumbers.length; i++)
        {
            newNumbers[i] = (int)(Math.random() * 100) + 1;
        }

        return newNumbers;
    }

    private static void BubbleSort(int[] arr)
    {
        for (int lastSortedIndex = arr.length - 1; lastSortedIndex >= 0; lastSortedIndex--)
        {
            for (int i = 0; i < lastSortedIndex; i++)
            {
                //Check if the succeeding element is bigger than the current element
                if (arr[i + 1] > arr[i])
                {
                    // If so, swap Values
                    arr[i + 1] += arr[i];
                    arr[i] = arr[i + 1] - arr[i];
                    arr[i + 1] -= arr[i];
                }
            }
        }
    }

    private static void SelectionSort(int[] arr)
    {
        for (int lastSortedIndex = arr.length - 1; lastSortedIndex >= 0; lastSortedIndex--)
        {

            int indexOfSmallest = 0;

            for (int i = 0; i <= lastSortedIndex; i++)
            {
                //Look for the smallest element
                if (arr[i] < arr[indexOfSmallest])
                {
                    indexOfSmallest = i;
                }
            }

            // Lock so that the values don't get needlessly switched (i.e. last sorted index is already the smallest)
            if (arr[indexOfSmallest] < arr[lastSortedIndex])
            {
                // Swap values with the last index
                arr[lastSortedIndex] += arr[indexOfSmallest];
                arr[indexOfSmallest] = arr[lastSortedIndex] - arr[indexOfSmallest];
                arr[lastSortedIndex] -= arr[indexOfSmallest];
            }

        }
    }

    private static void PrintArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Element " + i + ": " + arr[i]);
        }
    }
}