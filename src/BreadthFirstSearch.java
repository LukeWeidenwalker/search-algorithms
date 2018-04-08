package src;

import java.util.ArrayList;
import java.util.LinkedList;

public class BreadthFirstSearch extends Algorithm {
    // First-in-first-out queue.
    private LinkedList<Node> frontier;

    BreadthFirstSearch(Node start, char goalState, char[][] map) {
        // Initialise variables
        super(start, goalState, map);
        this.frontier = new LinkedList<>();
        this.frontier.add(this.start);

        // Conduct search and obtain performance
        this.wrapupSearch();
    }


    @Override
    public ArrayList<Node> searchPath() {
        // Depth-first search implementation.
        Node currentNode;
        while (true) {
            // Always expand nodes in the order they have been generated.
            currentNode = this.frontier.pollFirst();
            //System.out.println("Currently looking at node: (" + currentNode.getX() + ", " + currentNode.getY() + ")");

            // Add current node to explored set
            this.exploredSet.put(currentNode, currentNode.getParent());

            // Check for goal state
            if (currentNode.isGoal(this.goalState)) {
                System.out.println("Solution found!");
                // Return ArrayList of Nodes that make up the found path.
                return reconstructPath(currentNode);
            }

            // Generate children nodes from current node and add them to frontier if not previously examined.
            for (Node child: currentNode.getChildren()) {
                if(!this.exploredSet.containsKey(child) && !this.frontier.contains(child)) {
                    this.frontier.addLast(child);
                }
            }

            // If the frontier is empty after expanding the current node, no solution has been found
            if (this.frontier.isEmpty()) {
                System.out.println("No solution found!");
                return new ArrayList<>();
            }

            //System.out.println("Frontier: " + this.frontier);
            //System.out.println("Explored Set: " + this.exploredSet);
            //System.out.println("------------------------------------------------------------");
        }
    }
}
