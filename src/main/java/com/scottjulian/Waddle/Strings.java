package com.scottjulian.Waddle;

import java.util.Arrays;

public final class Strings {

    /**
     * Determines if a string is an anagram of a palindrome
     * @param str
     * @return
     */
    public static boolean isAnagramPalindrome(String str){
        if(str.length() <= 1){
            return true;
        }

        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        int tally = 1;
        int odd_count = 0;
        for(int x = 1; x < chars.length; x++){
            if(chars[x] == chars[x-1]){
                tally++;
            }
            else{
                odd_count += (tally%2);
                tally = 1;
            }
        }
        return ((odd_count + (tally%2)) < 2);
    }

    /**
     * Returns the shortest palindrome from the given string
     *
     * https://leetcode.com/problems/shortest-palindrome/
     */
    public static String getShortestPalindrome(String str){
        StringBuilder builder = new StringBuilder(str).reverse();
        String revStr = builder.toString();
        int len = str.length();
        int k;
        for(k = len; k >= 0; k--){
            if(str.substring(0,k).equals(revStr.substring(len-k))){
                break;
            }
        }
        return revStr.substring(0,len-k) + str;
    }
}
