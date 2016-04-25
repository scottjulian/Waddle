package com.scottjulian.Waddle;

import com.scottjulian.Waddle.clustering.ClusterDataPoint;
import com.scottjulian.Waddle.clustering.KMedoids.KMedoidCluster;
import com.scottjulian.Waddle.clustering.KMedoids.KMedoids;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class KMedoidsTest {

    public static ArrayList<ClusterDataPoint> _ClusterDataPoints1;

    @BeforeClass
    public static void beforeClass(){
        _ClusterDataPoints1 = new ArrayList<ClusterDataPoint>();
        _ClusterDataPoints1.add(new ClusterDataPoint(178, 83));
        _ClusterDataPoints1.add(new ClusterDataPoint(156, 83));
        _ClusterDataPoints1.add(new ClusterDataPoint(157, 103));
        _ClusterDataPoints1.add(new ClusterDataPoint(179, 102));
        _ClusterDataPoints1.add(new ClusterDataPoint(167, 93));
        _ClusterDataPoints1.add(new ClusterDataPoint(637, 289));
        _ClusterDataPoints1.add(new ClusterDataPoint(686, 323));
        _ClusterDataPoints1.add(new ClusterDataPoint(731, 293));
        _ClusterDataPoints1.add(new ClusterDataPoint(730, 383));
        _ClusterDataPoints1.add(new ClusterDataPoint(635, 372));
    }

    @Test
    public void testTwoMedoids(){
        KMedoids km = new KMedoids(2, _ClusterDataPoints1, 9);
        KMedoidCluster[] clusters = km.getClusters();

        //km.printOut();

        ClusterDataPoint medoid_0 = new ClusterDataPoint(635, 372);
        ClusterDataPoint medoid_1 = new ClusterDataPoint(156, 83);

        assertTrue( clusters[0].getMedoid().equalTo(medoid_0) );
        assertTrue( clusters[1].getMedoid().equalTo(medoid_1) );
    }

    @Test
    public void testThreeMedoids(){
        KMedoids km = new KMedoids(3, _ClusterDataPoints1, 7);
        KMedoidCluster[] clusters = km.getClusters();

        //km.printOut();

        ClusterDataPoint medoid_0 = new ClusterDataPoint(686, 323);
        ClusterDataPoint medoid_1 = new ClusterDataPoint(179, 102);
        ClusterDataPoint medoid_2 = new ClusterDataPoint(730, 383);

        assertTrue( clusters[0].getMedoid().equalTo(medoid_0) );
        assertTrue( clusters[1].getMedoid().equalTo(medoid_1) );
        assertTrue( clusters[2].getMedoid().equalTo(medoid_2) );
    }

    @Test
    public void testFourMedoids(){
        KMedoids km = new KMedoids(4, _ClusterDataPoints1, 7);
        KMedoidCluster[] clusters = km.getClusters();

        //km.printOut();

        ClusterDataPoint medoid_0 = new ClusterDataPoint(686, 323);
        ClusterDataPoint medoid_1 = new ClusterDataPoint(167, 93);
        ClusterDataPoint medoid_2 = new ClusterDataPoint(637, 289);
        ClusterDataPoint medoid_3 = new ClusterDataPoint(178, 83);

        assertTrue( clusters[0].getMedoid().equalTo(medoid_0) );
        assertTrue( clusters[1].getMedoid().equalTo(medoid_1) );
        assertTrue( clusters[2].getMedoid().equalTo(medoid_2) );
        assertTrue( clusters[3].getMedoid().equalTo(medoid_3) );
    }
}

