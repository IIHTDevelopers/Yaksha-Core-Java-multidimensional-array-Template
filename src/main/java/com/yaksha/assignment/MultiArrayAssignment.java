package com.yaksha.assignment;

public class MultiArrayAssignment {

    public static void main(String[] args) {

        // Task 1: Print Elements of a 2D Array
        System.out.println("Task 1: Print Elements of a 2D Array");
        int[][] arr1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }

        // Task 2: Find the Length of a Row in a 2D Array
        System.out.println("\nTask 2: Find the Length of a Row in a 2D Array");
        int[][] arr2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Length of row 1: " + arr2[0].length);

        // Task 3: Find the Maximum Value in a 2D Array
        System.out.println("\nTask 3: Find the Maximum Value in a 2D Array");
        int[][] arr3 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int max = arr3[0][0];
        for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr3[i].length; j++) {
                if (arr3[i][j] > max) {
                    max = arr3[i][j];
                }
            }
        }
        System.out.println("Maximum Value: " + max);

        // Task 4: Sum of Elements in a Row of a 2D Array
        System.out.println("\nTask 4: Sum of Elements in a Row of a 2D Array");
        int[][] arr4 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int sum = 0;
        for (int j = 0; j < arr4[1].length; j++) {
            sum += arr4[1][j];  // Sum of elements in row 2
        }
        System.out.println("Sum of row 2 elements: " + sum);

        // Task 5: Transpose a 2D Array
        System.out.println("\nTask 5: Transpose a 2D Array");
        int[][] arr5 = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int[][] transposed = new int[arr5[0].length][arr5.length];
        for (int i = 0; i < arr5.length; i++) {
            for (int j = 0; j < arr5[i].length; j++) {
                transposed[j][i] = arr5[i][j];
            }
        }

        System.out.println("Transposed Array:");
        for (int i = 0; i < transposed.length; i++) {
            for (int j = 0; j < transposed[i].length; j++) {
                System.out.print(transposed[i][j] + " ");
            }
            System.out.println();
        }
    }
}
