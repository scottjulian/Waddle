package net.scottjulian.Waddle;

import net.scottjulian.Waddle.util.misc.Islands;

public final class Misc {

    /**
     * Given an hour and a minute, calculate the angle in degrees between
     * the Hour hand and the Minute Hand on a clock.
     *
     * https://en.wikipedia.org/wiki/Clock_angle_problem
     *
     * @param hour
     * @param min
     * @return angle in degrees
     */
    public static double getAngleBetweenHourMin(int hour, int min){
        return Math.abs(0.5*((60*hour) - (11*min)));
    }

    /**
     * Given a 2-dimensional grid of 1's & 0's, find the number of "1's" islands.
     *
     * @param grid
     * @return number of islands
     */
    public static int countNumberOfIslands(int[][] grid){
        return Islands.countNumberOfIslands(grid);
    }

    /**
     * Find out if a given int is a power of 2
     * https://leetcode.com/problems/power-of-two/
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n){
        if(n <= 0){
            return false;
        }
        else if (((n - 1) & n) == 0){
            return true;
        }
        return false;
    }
}
