package com.scottjulian.Waddle.clustering;


import java.util.ArrayList;

public interface Cluster {
    int getLabel();
    ArrayList<ClusterDataPoint> getClusterDataPoints();
    String toString();
    Boolean contains(ClusterDataPoint in);

    void setLabel(int label);
    void add(ClusterDataPoint in);
    void remove(ClusterDataPoint dp);
}
