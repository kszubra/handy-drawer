package com.handy.drawer.solutions.pathfinding.network.example.navigation.points;

import com.handy.drawer.solutions.pathfinding.network.Network;
import com.handy.drawer.solutions.pathfinding.network.PathFinder;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PathFinderTest {

    private Network<NavigationPoint> navpoints;
    private PathFinder<NavigationPoint> pathFinder;

    @Before
    public void setUp() throws Exception {
        Set<NavigationPoint> navigationPoints = new HashSet<>();
        Map<String, Set<String>> connections = new HashMap<>();

        navigationPoints.add(new NavigationPoint("1", "navPoint1", 51.5028, -0.2801));
        navigationPoints.add(new NavigationPoint("2", "navPoint2", 51.5143, -0.0755));
        navigationPoints.add(new NavigationPoint("3", "navPoint3", 51.5154, -0.0726));
        navigationPoints.add(new NavigationPoint("4", "navPoint4", 51.5107, -0.013));
        navigationPoints.add(new NavigationPoint("5", "navPoint5", 51.5407, -0.2997));
        navigationPoints.add(new NavigationPoint("6", "navPoint6", 51.6736, -0.607));
        navigationPoints.add(new NavigationPoint("7", "navPoint7", 51.5322, -0.1058));
        navigationPoints.add(new NavigationPoint("8", "navPoint8", 51.5653, -0.1353));
        navigationPoints.add(new NavigationPoint("9", "navPoint9", 51.6164, -0.1331));
        navigationPoints.add(new NavigationPoint("10", "navPoint10", 51.5586, -0.1059));


        connections.put("1", Stream.of("2","5","7","10").collect(Collectors.toSet()));
        connections.put("2", Stream.of("1", "3", "5").collect(Collectors.toSet()));
        connections.put("3", Stream.of("2", "4", "5").collect(Collectors.toSet()));
        connections.put("4", Stream.of("3", "5", "6").collect(Collectors.toSet()));
        connections.put("5", Stream.of("4", "6", "3", "8", "1", "2", "7").collect(Collectors.toSet()));
        connections.put("6", Stream.of("4", "9", "5", "8").collect(Collectors.toSet()));
        connections.put("7", Stream.of("5", "8", "1", "10").collect(Collectors.toSet()));
        connections.put("8", Stream.of("10", "7", "5", "6", "9").collect(Collectors.toSet()));
        connections.put("9", Stream.of("6", "8", "10").collect(Collectors.toSet()));
        connections.put("10", Stream.of("1", "7", "8", "9").collect(Collectors.toSet()));


        navpoints = new Network<>(navigationPoints, connections);
        pathFinder = new PathFinder<>(navpoints, new HaversineCostCalculator(), new HaversineCostCalculator());
    }

    @Test
    public void findRoute() {
        List<NavigationPoint> route = pathFinder.findRoute(navpoints.getNode("1"), navpoints.getNode("6"));

        System.out.println(route.stream().map(NavigationPoint::getName).collect(Collectors.toList()));
    }
}
