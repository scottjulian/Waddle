package com.scottjulian.Waddle;

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


    /**
     *
     * https://leetcode.com/problems/word-search/
     *
     * @param board
     * @param word
     * @return
     */
    public static boolean doesWordExistInBoard(char[][] board, String word){
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                if(doesWordExist(board, row, col, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean doesWordExist(char[][] board, int row, int col, String word, int pos){
        if(pos == word.length())
            return true;
        else if(row < 0 || row >= board.length)
            return false;
        else if(col < 0 || col >= board[row].length)
            return false;
        else if(board[row][col] != word.charAt(pos))
            return false;

        board[row][col] = '!';
        boolean exist = doesWordExist(board, row-1, col  , word, pos+1) ||
                        doesWordExist(board, row  , col-1, word, pos+1) ||
                        doesWordExist(board, row  , col+1, word, pos+1) ||
                        doesWordExist(board, row+1, col  , word, pos+1);
        board[row][col] = word.charAt(pos);
        return exist;
    }


    /**
     *
     * https://leetcode.com/problems/two-sum/
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] findTwoSumIndices(int[] numbers, int target){
        for(int i = 0; i < numbers.length; i ++){
            for(int k = i + 1; k < numbers.length; k++){
                if(numbers[i] + numbers[k] == target){
                    int[] indices = {i+1, k+1};
                    return indices;
                }

            }
        }
        int[] zeroes = {0, 0};
        return zeroes;
    }

}
