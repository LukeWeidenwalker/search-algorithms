package src;

import java.util.ArrayList;
import java.util.Objects;

public class Node {
    // Variables
    protected int x;
    protected int y;
    protected int pathcost;
    protected int gcost;
    protected char nodeState;
    protected Node parent;
    protected int[] goalCoords;
    protected static char[][] map;
    protected static int mapXSize;
    protected static int mapYSize;
    protected static char obstacleIdentifier;

    // Constructor, calling this generates the Node's children nodes
    Node(int x, int y, Node parent, int[] goalCoords) {
        this.x = x;
        this.y = y;
        this.parent = parent;
        this.nodeState = map[this.y][this.x];
        if (!(this.parent == null)) {
            this.pathcost = this.parent.pathcost + 1;
        }
        this.goalCoords = goalCoords;
        // Manhattan distance heuristic
        this.gcost = Math.abs(this.x - goalCoords[0]) + Math.abs(this.y - goalCoords[1]);
    }

    // -----------------------
    // Methods
    // -----------------------
    ArrayList<Node> getChildren() {
        // Children nodes need to be reachable from parent node by movement of one unit on one coordinate axis.
        ArrayList<Node> children = new ArrayList<>(4);
        // Add x-axis reachable nodes.
        for (int xDelta = -1; xDelta <= 1; xDelta += 2) {
            int nextX = this.x + xDelta;
            // Ensure the boundaries of the map are respected.
            if (nextX >= 0 && nextX < mapXSize) {
                Node child = new Node(nextX, this.y, this, this.goalCoords);
                if (child.isPassable()) {
                    children.add(child);
                }
            }
        }

        // Add y-axis reachable nodes.
        for (int yDelta = -1; yDelta <= 1; yDelta += 2) {
            int nextY = this.y + yDelta;
            if (nextY >= 0 && nextY < mapYSize) {
                Node child = new Node(this.x, nextY, this, this.goalCoords);
                if (child.isPassable()) {
                    children.add(child);
                }
            }
        }
        return children;
    }

    static void setMap(char[][] newMap) {
        // Set map related variables.
        map = newMap;
        mapXSize = map[0].length;
        mapYSize = map.length;
        obstacleIdentifier = 'X';
    }

    @Override
    public String toString() {
        return ("(" + this.getX() + ", " + this.getY() + ")");
    }

    @Override
    public boolean equals(Object obj) {
        // Needed to make checking for existance in frontier and explored set work.
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Node)) {
            return false;
        }
        Node other = (Node) obj;
        // Attributes to uniquely identify a node: x- and y-coordinates and nodeState.
        return this.getX() == other.getX() && this.getY() == other.getY() && this.getNodeState() == other.getNodeState();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getX(), this.getY(), this.getNodeState());
    }

    // -----------------------
    // Getter Methods
    // -----------------------

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }

    char getNodeState() {
        return this.nodeState;
    }

    Node getParent() {
        return this.parent;
    }

    boolean isGoal(char goalState) {
        return this.nodeState == goalState;
    }

    boolean isPassable() {
        return this.nodeState != obstacleIdentifier;
    }

    int getHeuristicCost() {
        return this.pathcost + this.gcost;
    }

    int getBestFirstCost() { return this.gcost;}



    // -----------------------
    // Subclasses
    // -----------------------


}

