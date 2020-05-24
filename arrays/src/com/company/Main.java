package com.company;
import java.util.Arrays;

public class Main {

    // remove item from the end of the array
    // return the array
    // NOTE: pop returns an array, not the popped item, since we cannot mutate the input array
    public static int[] pop (int[] arr) {

        // init res
        int[] res = new int[arr.length - 1];

        // copy all items except last item into res
        for (int i = 0; i < arr.length - 1; i++) {
            res[i] = arr[i];
        }

        // return
        return res;
    }

    // insert item into an index in an array
    // return array
    public static int[] insert (int[] arr, int item, int index) {

        // init res
        int[] res = new int[arr.length + 1];

        // takeFrom is the index we should take an item from during the loop
        int takeFrom = 0;

        // loop
        for (int i = 0; i < res.length; i++) {
            if (i == index) {
                // if found index to insert, add item
                res[i] = item;
            } else {
                // else, add arr[takeFrom] to res, and increment takeFrom
                res[i] = arr[takeFrom];
                takeFrom++;
            }
        }

        // return
        return res;
    }

    // pushes an item to the end of the array
    // return the array
    public static int[] push (int[] arr, int item) {

        // push just uses insert
        return Main.insert(arr, item, arr.length);
    }

    public static void main(String[] args) {
        // test 1: (push)
        int[] test1 = {1, 2, 3};
        System.out.println(Arrays.toString(Main.push(test1, 4)));
        // should print [1, 2, 3, 4]

        // test 2: (pop)
        int[] test2 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(Main.pop(test2)));
        // should print [1, 2, 3]

        // test 2: (insert)
        int[] test3 = {1, 2, 3, 5};
        System.out.println(Arrays.toString(Main.insert(test3, 4, 3)));
        // should print [1, 2, 3, 4, 5]
    }
}
