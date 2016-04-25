package com.scottjulian.Waddle.util.misc;


public final class Islands {

    private static boolean[][] _visitedNodes;
    private static int[][] _grid;

    /**
     * Given a 2-dimensional grid of 1's & 0's, find the number of "1's" islands.
     *
     * @param grid
     * @return number of islands
     */
    public static int countNumberOfIslands(int[][] grid){
        int count = 0;
        _grid = grid;
        _visitedNodes = new boolean[_grid.length][_grid[0].length];
        for(int row = 0; row < _grid.length; row++){
            for(int col = 0; col < _grid[0].length; col++){
                if(_grid[row][col] == 1 && !_visitedNodes[row][col]){
                    findAttachedLand(row, col);
                    count++;
                }
            }
        }

        //printGrid(count);
        return count;
    }

    private static void findAttachedLand(int row, int col){
        _visitedNodes[row][col] = true;
        for(Neighbor n : Neighbor.values()){
            int nextRow = row + n.getDeltaRow();
            int nextCol = col + n.getDeltaCol();
            if(isValidLand(nextRow, nextCol)){
                findAttachedLand(nextRow, nextCol);
            }
        }
    }

    private static boolean isValidLand(int row, int col){
        if(row < 0 || row >= _grid.length)
            return false;
        else if(col < 0 || col >= _grid[0].length)
            return false;
        else if(_visitedNodes[row][col])
            return false;
        return (_grid[row][col] == 1);
    }

    private static enum Neighbor{
        TL(-1, -1),
        TP( 0, -1),
        TR(-1,  1),
        RT( 0,  1),
        BR( 1,  1),
        BT( 1,  0),
        BL( 1, -1),
        LT(-1,  0);

        private int _deltaRow;
        private int _deltaCol;

        Neighbor(int dRow, int dCol){
            _deltaRow = dRow;
            _deltaCol = dCol;
        }

        public int getDeltaRow(){
            return _deltaRow;
        }

        public int getDeltaCol(){
            return _deltaCol;
        }
    }

    private static void printGrid(int count){
        System.out.print(count + " islands: \n\n");
        for(int row = 0; row < _grid.length; row++){
            for(int col = 0; col < _grid[0].length; col++){
                if(_grid[row][col] != 1){
                    System.out.print("-");
                }
                else {
                    System.out.print(Integer.toString(_grid[row][col]));
                }
            }
            System.out.print("\n");
        }
    }
}
