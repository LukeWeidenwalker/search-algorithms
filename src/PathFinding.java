package src;

import java.util.NoSuchElementException;

public class PathFinding {
    public src.Node start;
    public char startState;
    public char goalState;

    public char[][] map;

    PathFinding(int mapNumber, char startState, char goalState) {
        loadMap(mapNumber);
        int[] startCoords = findUnitPosition(startState, this.map);
        this.start = new Node(startCoords[0], startCoords[1], null, findUnitPosition(goalState, this.map));
        //System.out.println("Found start position at: " + this.start);
        this.goalState = goalState;
    }

    void loadMap(int mapNumber) {
        // Load Map from map class into a 2D char array
        this.map = Map.getMap(mapNumber);
        Node.setMap(this.map);
        System.out.println("Loaded map " + mapNumber + ".");
    }

    char[][] getMap() {
        return this.map;
    }

    char getGoalState() {
        return this.goalState;
    }


    static int[] findUnitPosition(char uniqueState, char[][] map) throws NoSuchElementException {
        // Search through map to find e.g. robot start position and goal positions

        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if (uniqueState == map[y][x]) {
                    return new int[] {x, y};
                }
            }
        }
        throw new NoSuchElementException();
    }

    public static void main(String[] args) {
        try {
            int mapNumber = Integer.parseInt(args[0]);

            System.out.println("Applying A* Search to map " + mapNumber);
            PathFinding pathfinder3 = new PathFinding(mapNumber, 'I', 'B');
            Algorithm AStaralgo1 = new AStarAlgorithm(pathfinder3.start, pathfinder3.getGoalState(), pathfinder3.getMap());
            PathFinding pathfinder4 = new PathFinding(mapNumber, 'B', 'G');
            Algorithm AStaralgo2 = new AStarAlgorithm(pathfinder4.start, pathfinder4.getGoalState(), pathfinder4.getMap());

            System.out.println("Applying Best-First Search to map " + mapNumber);
            PathFinding pathfinder1 = new PathFinding(mapNumber, 'I', 'B');
            Algorithm BestFirstalgo1 = new BestFirstSearch(pathfinder1.start, pathfinder1.getGoalState(), pathfinder1.getMap());
            PathFinding pathfinder2 = new PathFinding(mapNumber, 'B', 'G');
            Algorithm BestFirstalgo2 = new BestFirstSearch(pathfinder2.start, pathfinder2.getGoalState(), pathfinder2.getMap());
        }

        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("usage: Pathfinding mapNumber");
        }

//  Used these to generate results for all maps:
//        for (int i = 1; i < 7; i++) {
//            // Finding to Bob
//            PathFinding pathfinder1 = new PathFinding(i, 'I', 'B');
//            Algorithm BFalgo1 = new BreadthFirstSearch(pathfinder1.start, pathfinder1.getGoalState(), pathfinder1.getMap());
//            // Finding from Bob to Goal
//            PathFinding pathfinder2 = new PathFinding(i, 'B', 'G');
//            Algorithm BFalgo2 = new BreadthFirstSearch(pathfinder2.start, pathfinder2.getGoalState(), pathfinder2.getMap());
//        }
//
//        for (int i = 1; i < 7; i++) {
//            PathFinding pathfinder1 = new PathFinding(i, 'I', 'B');
//            Algorithm DFalgo1 = new DepthFirstSearch(pathfinder1.start, pathfinder1.getGoalState(), pathfinder1.getMap());
//            PathFinding pathfinder2 = new PathFinding(i, 'B', 'G');
//            Algorithm DFalgo2 = new DepthFirstSearch(pathfinder2.start, pathfinder2.getGoalState(), pathfinder2.getMap());
    }
}
