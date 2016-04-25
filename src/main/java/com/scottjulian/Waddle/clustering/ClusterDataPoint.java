package com.scottjulian.Waddle.clustering;

public class ClusterDataPoint{
    private int _x;
    private int _y;

    public ClusterDataPoint(int x, int y){
        _x = x;
        _y = y;
    }

    public ClusterDataPoint(ClusterDataPoint dp){
        _x = dp.getX();
        _y = dp.getY();
    }

    public Boolean equalTo(ClusterDataPoint in){
        return (_x == in.getX() && _y == in.getY());
    }

    public int getX() {
        return _x;
    }

    public int getY() {
        return _y;
    }

    public String toString(){
        String out = _x + ", " + _y;
        return out;
    }
}
