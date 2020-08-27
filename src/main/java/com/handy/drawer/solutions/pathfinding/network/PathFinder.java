package com.handy.drawer.solutions.pathfinding.network;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

@Slf4j
public class PathFinder<T extends GraphNode> {
    private final Network<T> network;
    private final CostCalculator<T> nextNodeCostCalculator;
    private final CostCalculator<T> targetCostCalculator;

    public PathFinder(Network<T> network, CostCalculator<T> nextNodeCostCalculator, CostCalculator<T> targetCostCalculator) {
        this.network = network;
        this.nextNodeCostCalculator = nextNodeCostCalculator;
        this.targetCostCalculator = targetCostCalculator;
    }

    public List<T> findRoute(T startPoint, T endPoint) {
        Map<T, PathNode<T>> allNodes = new HashMap<>();
        Queue<PathNode> openSet = new PriorityQueue<>();

        PathNode<T> start = new PathNode<>(startPoint, null, 0d, targetCostCalculator.computeCost(startPoint, endPoint));
        allNodes.put(startPoint, start);
        openSet.add(start);

        while (!openSet.isEmpty()) {
            PathNode<T> next = openSet.poll();
            log.debug("Checking node: {}", next);
            if (next.getCurrentNode().equals(endPoint)) {
                log.debug("Destination found");

                List<T> route = new ArrayList<>();
                PathNode<T> current = next;
                do {
                    route.add(0, current.getCurrentNode());
                    current = allNodes.get(current.getPreviousNode());
                } while (current != null);

               log.debug("Path: {}", route);
                return route;
            }

            network.getConnections(next.getCurrentNode()).forEach(connection -> {
                double newScore = next.getPathCost() + nextNodeCostCalculator.computeCost(next.getCurrentNode(), connection);
                PathNode<T> nextNode = allNodes.getOrDefault(connection, new PathNode<>(connection));
                allNodes.put(connection, nextNode);

                if (nextNode.getPathCost() > newScore) {
                    nextNode.setPreviousNode(next.getCurrentNode());
                    nextNode.setPathCost(newScore);
                    nextNode.setEstimatedCost(newScore + targetCostCalculator.computeCost(connection, endPoint));
                    openSet.add(nextNode);
                }
            });
        }

        log.error("No path found");
        throw new IllegalStateException("No path found");
    }

}
