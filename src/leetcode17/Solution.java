package leetcode17;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        System.out.println("Hello World");

        int[] a = new int[] {1,2,4,4};
        int[] b = new int[] {6,7,7};

        // int[] res = mergeSortedArrays(a, b);
        // int[] expected = {1,2,4,6,7};
        // for(int i = 0 ; i < res.length ; i++) {
        //     assert (res[i] == expected[i]) : "Arrays not equal";
        //     System.out.println(res[i]); 
        // }

        Integer[] arr = mergeSortedArrays(a, b);
        System.out.println();

        for(int i = 0 ; i < arr.length ; i++) {

            System.out.println(arr[i]);
        }

        //1
//        a = new int[] {};
//        b = new int[] {};
//
//        //2
//
//        a = null;
//        b = new int[] {2, 3 ,4};
//
//        //3
//        a=  null;
//        b = null;
//
//        //Very Large arrays
//        a = new int[Integer.MAX_VALUE];
//        b =  new int[Integer.MAX_VALUE];

        //Negative numbers

        // Unsorted arrays (unpredictable results)


    }
    // public static validate(int[] actual, int[] expected) {

    // }
/*
create API consumed by other developers,
input - 2 sorted arrays, sorted in same order.
output - sorted array, containing values from both input arrays, but without duplicates.

Example:

input  - [1,2,4,4] - (1,4)  [6,7,7] - (6,7)

output - [1,2,4,6,7] - 5




input:
[0,0,0,0,0,0,0] [1,1,1,1,1,1,1,1,1,1] - what would be length of output, if a1+a2 then seems wasting memory.
output:
[0,1,0,0,0,0,0,0,0,0] - may have problems.
[0,1]
*/
    /**
     * Function that takes in two
     * @param arr1 (sorted, not null)
     * @param arr2 (sorted, not null)
     * output (without duplicates)
     * if one of inputs is null, then return other array without duplicates.
     * length of output array ? - combined length of arr1 and arr2, with rest of elements defined as 0.
     * 1,2,4,6,7,0,0,0,0,0,0,0,0,0
     * with dynamic list return will be [0,1] without wasted extra space.
     *
     */
    public static Integer[] mergeSortedArrays(int[] arr1, int[] arr2) {


        int i = 0;
        int j = 0;

        List<Integer> res = new LinkedList();

        // int[] res = new int[arr1.length + arr2.length];


        while(i < arr1.length || j < arr2.length) {

            if(i == arr1.length) {

                while(j < arr2.length) {
                    // res[k] = arr2[j];
                    res.add(arr2[j]);
                    while(j < arr2.length && arr2[j] == res.get(res.size()-1)) {
                        j++;
                    }
                }
                break;
            }

            if(j == arr2.length) {

                while(i < arr1.length) {
                    // res[k] = arr2[j];
                    res.add(arr1[i]);

                    while(i < arr1.length && arr1[i] == res.get(res.size()-1)) {
                        i++;
                    }

                }
                break;
            }

            if(arr1[i] < arr2[j]) {

                // res[k] = arr1[i];
                res.add(arr1[i]);

                while(i < arr1.length && arr1[i] == res.get(res.size()-1)) {
                    i++;
                }
            } else {
                // res[k] = arr2[j];
                res.add(arr2[j]);

                while(j < arr2.length && arr2[j] == res.get(res.size()-1)) {
                    j++;
                }
            }


        }


        return res.toArray(new Integer[0]);
    }

}