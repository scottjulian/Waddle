package com.scottjulian.Waddle;


import com.scottjulian.Waddle.util.misc.Islands;
import org.junit.Test;

import static org.junit.Assert.*;

public class IslandsTest {

    @Test
    public void test4x4(){
        int[][] grid = {
                { 0, 0, 1, 1 },
                { 1, 0, 0, 0 },
                { 1, 0, 0, 0 },
                { 0, 0, 1, 0 }
        };
        int numIslands = Islands.countNumberOfIslands(grid);
        assertEquals(3, numIslands);
    }

    @Test
    public void test6x6(){
        int[][] grid = {
                { 0, 0, 1, 1, 1, 0 },
                { 1, 0, 0, 1, 1, 0 },
                { 1, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 1, 1 },
                { 0, 0, 1, 0, 1, 1 },
                { 1, 1, 1, 0, 0, 0}
        };
        int numIslands = Islands.countNumberOfIslands(grid);
        assertEquals(4, numIslands);
    }

    @Test
    public void test10x10(){
        int[][] grid = {
                { 1, 1, 1, 1, 1, 0, 0, 0, 1, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 0, 1, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 1, 0, 0, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 0, 0, 1, 0 },
                { 1, 0, 0, 1, 0, 0, 1, 0, 1, 0 },
                { 1, 1, 0, 0, 0, 0, 1, 0, 1, 1 },
                { 0, 1, 1, 0, 0, 0, 0, 1, 1, 0 },
        };
        int numIslands = Islands.countNumberOfIslands(grid);
        assertEquals(6, numIslands);
    }
}
