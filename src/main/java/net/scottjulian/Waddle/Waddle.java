package net.scottjulian.Waddle;


import net.scottjulian.Waddle.classes.Islands;

public class Waddle {

    /**
     * Given a 2-dimensional grid of 1's & 0's, find the number of "1's" islands.
     *
     * @param grid
     * @return number of islands
     */
    public static int countNumberOfIslands(int[][] grid){
        return Islands.countNumberOfIslands(grid);
    }
}
