package net.scottjulian.Waddle.clustering.KMedoids;

import net.scottjulian.Waddle.clustering.ClusterDataPoint;

import java.util.ArrayList;
import java.util.Random;

/**
 * K-Medoids (PAM)
 *
 * [1] arbitrary choose K objects as initial medoids
 * [2] assign remaining objects to nearest medoids (cluster)
 * [3] randomly select a non-medoid object, O(random)
 * [4] compute total cost of swapping
 * [5] swap O(i) with O(random) if quality is improved
 * [6] repeat [3] - [5] until no more swaps
 *
 * @author scott julian
 */
public class KMedoids {

    private int _K;
    private ArrayList<ClusterDataPoint> _ClusterDataPoints;
    private KMedoidCluster[] _clusters;
    private Random _random;

    public KMedoids(int k, ArrayList<ClusterDataPoint> inClusterDataPoints) {
        _K = k;
        _clusters = new KMedoidCluster[_K];
        _random = new Random();
        _ClusterDataPoints = new ArrayList<ClusterDataPoint>();
        for(ClusterDataPoint dp : inClusterDataPoints){
            _ClusterDataPoints.add(new ClusterDataPoint(dp));
        }
        verifyInput();
        runClustering();
    }

    public KMedoids(int k, ArrayList<ClusterDataPoint> inClusterDataPoints, long seed) {
        _K = k;
        _clusters = new KMedoidCluster[_K];
        _random = new Random(seed);
        _ClusterDataPoints = new ArrayList<ClusterDataPoint>();
        for(ClusterDataPoint dp : inClusterDataPoints){
            _ClusterDataPoints.add(new ClusterDataPoint(dp));
        }
        verifyInput();
        runClustering();
    }

    private void verifyInput(){
        if(_K < 1){
            throw new IllegalArgumentException("The number of clusters cannot be less than 1");
        }
        else if(_ClusterDataPoints.size() < 2){
            throw new IllegalArgumentException("The number of Data Points cannot be less than 2");
        }
        else if(_K > _ClusterDataPoints.size()){
            throw new IllegalArgumentException("The number of clusters cannot exceed the number of Data Points");
        }
    }

    private void runClustering(){

        ArrayList<Integer> prevMedoidsIndexes = new ArrayList<Integer>();

        // [1] arbitrary choose K objects as initial medoids
        int randInt = _random.nextInt(_ClusterDataPoints.size());
        for (int i = 0; i < _K; i++) {
            while (prevMedoidsIndexes.contains(randInt)) {
                randInt = _random.nextInt(_ClusterDataPoints.size());
            }
            _clusters[i] = new KMedoidCluster(_ClusterDataPoints.get(randInt));
            _clusters[i].setLabel(i + 1);
            prevMedoidsIndexes.add(randInt);
        }

        // [2] assign remaining objects to nearest medoid (cluster)
        assignClusterDataPointsToClusters(_clusters);

        // [6] repeat steps 3 through 5
        KMedoidCluster[] testClusters = new KMedoidCluster[_K];
        KMedoidCluster swapCluster;
        do {
            // [3] randomly select a non-medoid object, O(random)
            randInt = _random.nextInt(_ClusterDataPoints.size());
            while (prevMedoidsIndexes.contains(randInt)) {
                randInt = _random.nextInt(_ClusterDataPoints.size());
            }
            swapCluster = new KMedoidCluster(_ClusterDataPoints.get(randInt));
            prevMedoidsIndexes.add(randInt);

            // [4] compute total cost of swapping
            double swapCosts[] = new double[_K];
            int swapIndex = 0;
            for(int count = 0; count < _K; count++){
                // put medoids into a testing clusters
                for (int i = 0; i < _K; i++) {
                    if(swapIndex == i) {
                        testClusters[i] = new KMedoidCluster(swapCluster);
                    }
                    else {
                        testClusters[i] = new KMedoidCluster(_clusters[i]);
                    }
                }

                assignClusterDataPointsToClusters(testClusters);
                swapCosts[count] = getTotalCostOfClusters(testClusters);
                swapIndex++;
            }

            // [5] swap O(i) with O(random) if quality is improved
            int cheapIndex = 0;
            for (int u = 1; u < _K; u++) {
                if (swapCosts[u] < swapCosts[cheapIndex]) {
                    cheapIndex = u;
                }
            }
            if (swapCosts[cheapIndex] < getTotalCostOfClusters(_clusters)) {
                _clusters[cheapIndex] = new KMedoidCluster(swapCluster);
            }
        }
        while (prevMedoidsIndexes.size() < _ClusterDataPoints.size());

        // set labels
        for(int x = 1; x <= _K; x++){
            _clusters[x-1].setLabel(x);
        }

        assignClusterDataPointsToClusters(_clusters);
    }

    private void assignClusterDataPointsToClusters(KMedoidCluster[] clusters){
        for(KMedoidCluster c : clusters){
            c.clearClusterDataPoints();
        }
        for(ClusterDataPoint dp : _ClusterDataPoints){
            int nearestCluster = 0;
            double distance = clusters[nearestCluster].getDistanceFromMedoid(dp);
            for(int x = 1; x < _K; x++){
                double tmpDistance = clusters[x].getDistanceFromMedoid(dp);
                if(tmpDistance < distance){
                    nearestCluster = x;
                    distance = tmpDistance;
                }
            }
            clusters[nearestCluster].add(dp);
        }
    }

    private double getTotalCostOfClusters(KMedoidCluster[] clusters){
        double cost = 0.0;
        for(KMedoidCluster c : clusters){
            cost += c.getTotalDistanceFromMedoid();
        }
        return cost;
    }

    //////// PUBLIC ////////

    public KMedoidCluster[] getClusters(){
        return _clusters;
    }

    public int getK(){
        return _K;
    }

    public ArrayList<ClusterDataPoint> getClusterDataPoints(){
        return _ClusterDataPoints;
    }

    public void printOut(){
        System.out.println(toString());
    }

    public String toString(){
        String out = "";
        for(int x = 0; x < _K; x++){
            out += _clusters[x].toString() + "\n";
        }
        return out;
    }

}

