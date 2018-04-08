package src;

import java.util.ArrayList;
import java.util.Stack;

public class DepthFirstSearch extends Algorithm {
    // Last-in-first-out queue.
    private Stack<Node> frontier;

    DepthFirstSearch(Node start, char goalState, char[][] map) {
        // Initialise variables
        super(start, goalState, map);
        this.frontier = new Stack<>();
        this.frontier.add(this.start);

        // Conduct search and obtain performance
        this.wrapupSearch();
    }


    @Override
    public ArrayList<Node> searchPath() {
        // Depth-first search implementation.
        Node currentNode;
        while (true) {
            currentNode = this.frontier.pop();
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
                    this.frontier.push(child);
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
