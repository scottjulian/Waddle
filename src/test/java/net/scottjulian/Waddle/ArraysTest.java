package net.scottjulian.Waddle;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArraysTest {

    @Test
    public void testFindTwoSumIndices(){
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] resultIndexes = Arrays.findTwoSumIndices(numbers, target);
        int[] answerIndexes = {1, 2};

        assertEquals(resultIndexes.length, answerIndexes.length);

        boolean equals = true;
        for(int x = 0; x < resultIndexes.length; x++){
            if(resultIndexes[x] != resultIndexes[x]){
                equals = false;
                break;
            }
        }
        assertTrue(equals);
    }

    @Test
    public void testDoesWordExistInBoard(){
        char[][] board =
            {
                { 'A','B','C','E'},
                { 'S','F','C','S'},
                { 'A','D','E','E'},
            };

        boolean exists1 = Arrays.doesWordExistInBoard(board, "ABCCED");
        assertTrue(exists1);

        boolean exists2 = Arrays.doesWordExistInBoard(board, "SEE");
        assertTrue(exists2);

        boolean exists3 = Arrays.doesWordExistInBoard(board, "ABCB");
        assertFalse(exists3);
    }
}
