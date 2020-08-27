package com.handy.drawer.solutions.pathfinding.network;

import java.util.StringJoiner;

class PathNode<T extends GraphNode> implements Comparable<PathNode> {
    private final T currentNode;
    private T previousNode;
    private double pathCost;
    private double estimatedCost;

    PathNode(T currentNode) {
        this(currentNode, null, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    PathNode(T currentNode, T previousNode, double pathCost, double estimatedCost) {
        this.currentNode = currentNode;
        this.previousNode = previousNode;
        this.pathCost = pathCost;
        this.estimatedCost = estimatedCost;
    }

    T getCurrentNode() {
        return currentNode;
    }

    T getPreviousNode() {
        return previousNode;
    }

    double getPathCost() {
        return pathCost;
    }

    double getEstimatedCost() {
        return estimatedCost;
    }

    void setPreviousNode(T previousNode) {
        this.previousNode = previousNode;
    }

    void setPathCost(double pathCost) {
        this.pathCost = pathCost;
    }

    void setEstimatedCost(double estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    @Override
    public int compareTo(PathNode other) {
        if (this.estimatedCost > other.estimatedCost) {
            return 1;
        } else if (this.estimatedCost < other.estimatedCost) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PathNode.class.getSimpleName() + "[", "]").add("current=" + currentNode)
                .add("previous=" + previousNode).add("routeScore=" + pathCost).add("estimatedScore=" + estimatedCost)
                .toString();
    }
}
