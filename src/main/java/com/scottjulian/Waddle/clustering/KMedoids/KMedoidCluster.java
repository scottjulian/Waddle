package com.scottjulian.Waddle.clustering.KMedoids;

import com.scottjulian.Waddle.clustering.Cluster;
import com.scottjulian.Waddle.clustering.ClusterDataPoint;

import java.util.ArrayList;
import java.util.Iterator;


public class KMedoidCluster implements Cluster {
    private int _label;
    private ArrayList<ClusterDataPoint> _ClusterDataPoints;
    private ClusterDataPoint _medoid;

    public KMedoidCluster(ClusterDataPoint in){
        _medoid = new ClusterDataPoint(in);
        _ClusterDataPoints = new ArrayList<ClusterDataPoint>();
    }

    public KMedoidCluster(KMedoidCluster cluster){
        _label = cluster.getLabel();
        _ClusterDataPoints = cluster.getClusterDataPoints();
        _medoid = cluster.getMedoid();
    }

    public double getDistanceFromMedoid(ClusterDataPoint in){
        //using Euclidean distance
        return Math.sqrt(
                ((_medoid.getX() - in.getX())*(_medoid.getX() - in.getX())) +
                        ((_medoid.getY() - in.getY())*(_medoid.getY() - in.getY()))
        );
    }

    public ClusterDataPoint getMedoid() {
        return _medoid;
    }

    public void setMedoid(ClusterDataPoint in) {
        _medoid = new ClusterDataPoint(in);
    }

    public double getTotalDistanceFromMedoid() {
        double total = 0.0;
        for(ClusterDataPoint dp : _ClusterDataPoints){
            total += getDistanceFromMedoid(dp);
        }
        return total;
    }

    public void clearClusterDataPoints() {
        _ClusterDataPoints.clear();
    }

    @Override
    public int getLabel() {
        return _label;
    }

    @Override
    public void setLabel(int label) {
        _label = label;
    }

    @Override
    public ArrayList<ClusterDataPoint> getClusterDataPoints() {
        return _ClusterDataPoints;
    }

    @Override
    public Boolean contains(ClusterDataPoint in) {
        for(ClusterDataPoint dp : _ClusterDataPoints){
            if(dp.equalTo(in)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(ClusterDataPoint in) {
        _ClusterDataPoints.add(in);
    }

    @Override
    public void remove(ClusterDataPoint in) {
        Iterator<ClusterDataPoint> it = _ClusterDataPoints.iterator();
        while(it.hasNext()){
            ClusterDataPoint dp = it.next();
            if(dp.equalTo(in)){
                it.remove();
                break;
            }
        }
    }

    public String toString(){
        String out = "Cluster: " + _label + "\n";
        out += "Medoid: (" + _medoid.toString() + ") \n";
        for(ClusterDataPoint dp : _ClusterDataPoints){
            out += "\t" + dp.getX() + "\t" + dp.getY() + "\n";
        }
        return out;
    }

}
