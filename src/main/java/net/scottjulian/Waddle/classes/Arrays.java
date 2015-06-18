package net.scottjulian.Waddle.classes;

import java.util.TreeSet;

public final class Arrays {

    /**
     *
     * https://leetcode.com/problems/contains-duplicate-ii/
     *
     * @param numbers
     * @param k
     * @return
     */
    public static boolean containsDuplicateWithinK(int[] numbers, int k){
        if(numbers.length <= 0 || k <= 0){
            return false;
        }

        if(k > numbers.length) {
            k = numbers.length - 1;
        }

        TreeSet <Integer> numSet = new TreeSet<Integer>();
        for(int x = 0; x < numbers.length; x++){
            if(x > k){
                numSet.remove(numbers[x-k-1]);
            }
            if(!numSet.add(numbers[x])){
                return true;
            }
        }
        return false;
    }

}
