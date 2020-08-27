package com.handy.drawer.solutions.pathfinding.network.example.navigation.points;


import com.handy.drawer.solutions.pathfinding.network.CostCalculator;

public class HaversineCostCalculator implements CostCalculator<NavigationPoint> {
    @Override
    public double computeCost(NavigationPoint startPoint, NavigationPoint endPoint) {
        final double EARTH_RADIUS_IN_KM = 6372.8;

        double dLat = Math.toRadians(endPoint.getLatitude() - startPoint.getLatitude());
        double dLon = Math.toRadians(endPoint.getLongitude() - startPoint.getLongitude());
        double lat1 = Math.toRadians(startPoint.getLatitude());
        double lat2 = Math.toRadians(endPoint.getLatitude());

        double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return EARTH_RADIUS_IN_KM * c;
    }
}
