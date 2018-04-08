package src;

import java.util.*;

abstract public class Algorithm {
    // Search Components
    HashMap<Node, Node> exploredSet;
    ArrayList<Node> foundPath;

    // Inputs
    protected Node start, goal;
    protected char goalState;
    protected char[][] map;

    // Performance attributes
    int pathcost;
    int nodesExpanded;
    static String newline = System.getProperty("line.separator");


    // -----------------------
    // Constructor
    // -----------------------

    Algorithm(Node start, char goalState, char[][] map) {
        this.start = start;
        this.map = map;
        this.goalState = goalState;
        this.exploredSet = new HashMap<>();
        // The first entry in the explored set is the start state, which does not have a parent node.
        this.exploredSet.put(start, null);
    }


    // -----------------------
    // Methods
    // -----------------------

    abstract public ArrayList<Node> searchPath();

    void wrapupSearch() {
        // Start search algorithm
        this.foundPath = searchPath();

        // Set performance measures
        this.nodesExpanded = exploredSet.size();
        this.pathcost = foundPath.size();
        System.out.println(this);
    }

    ArrayList<Node> reconstructPath(Node node) {
        // Going back through the explored set to reconstruct best path.
        ArrayList<Node> foundPath = new ArrayList<>();
        do {
            foundPath.add(node);
            node = this.exploredSet.get(node);
        } while (node.getParent() != null);

        // Add initial node to output
        foundPath.add(node);

        Collections.reverse(foundPath);
        return foundPath;
    }


    @Override
    public String toString() {
        return "Path found: " + foundPath + newline +
                "Search states visited: " + nodesExpanded + newline +
                "Path length: " + foundPath.size();
    }
}


