package com.handy.drawer.solutions.pathfinding.network;

public interface CostCalculator<T extends GraphNode> {
    double computeCost(T startPoint, T endPoint);
}
