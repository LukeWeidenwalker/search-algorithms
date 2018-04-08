package src;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AStarAlgorithm extends Algorithm {
    private PriorityQueue<Node> frontier;

    AStarAlgorithm(Node start, char goalState, char[][] map) {
        // Search for Node with goal state in map
        super(start, goalState, map);
        int[] goalCoords = PathFinding.findUnitPosition(goalState, map);

        Comparator<Node> aStarNodeComparator = new NodeComparator();

        this.frontier = new PriorityQueue<>(1, aStarNodeComparator);
        this.frontier.add(start);

        this.wrapupSearch();
    }

    @Override
    public ArrayList<Node> searchPath() {

        // AStar Search implementation

        Node currentNode;
        while (true) {
            // Always expand nodes in the order they have been generated.
            currentNode = this.frontier.poll();

            // If the frontier is empty after expanding the current node, no solution has been found
            if (currentNode == null) {
                System.out.println("No solution found!");
                return new ArrayList<>();
            }

            System.out.println("Currently looking at node: (" + currentNode.getX() + ", " + currentNode.getY() + ")");

            // Add current node to explored set
            this.exploredSet.put(currentNode, currentNode.getParent());

            // Check for goal state
            if (currentNode.isGoal(this.goalState)) {
                System.out.println("Solution found!");
                // Return ArrayList of Nodes that make up the found path.
                return reconstructPath(currentNode);
            }

            // Generate children nodes from current node and add them to frontier if not previously examined.
            for (Node child : currentNode.getChildren()) {
                if (!this.exploredSet.containsKey(child) && !this.frontier.contains(child)) {
                    this.frontier.add(child);
                }
            }


            System.out.println("Frontier: " + this.frontier);
            System.out.println("Explored Set: " + this.exploredSet);
            System.out.println("------------------------------------------------------------");
        }
    }


    public class NodeComparator implements Comparator<Node> {
        // Used to sort nodes into the priority queue.
        public int compare(Node o1, Node o2) {
            if (o1.getHeuristicCost() < o2.getHeuristicCost()) {
                return -1;
            }

            if (o1.getHeuristicCost() > o2.getHeuristicCost()) {
                return 1;
            }
            return 0;
        }
    }
}
