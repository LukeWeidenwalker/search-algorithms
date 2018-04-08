package src;

abstract public class Map {
    // Sample maps to test algorithms on.

    private static char[][] map1 = new char [][] {

            //            0    1    2    3    4    5    6    7    8    9
            /* y = 0 */ {'I', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
            /* y = 1 */ {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
            /* y = 2 */ {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
            /* y = 3 */ {'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O'},
            /* y = 4 */ {'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O'},
            /* y = 5 */ {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
            /* y = 6 */ {'O', 'O', 'X', 'X', 'O', 'X', 'O', 'O', 'O', 'O'},
            /* y = 7 */ {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'B', 'O'},
            /* y = 8 */ {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
            /* y = 9 */ {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'G'},
    };


    private static char[][] map2 = new char [][] {
            {'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'X'},
            {'O', 'X', 'O', 'X', 'O', 'O', 'B', 'O', 'O', 'X'},
            {'O', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'O', 'O'},
            {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
            {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
            {'O', 'O', 'O', 'X', 'X', 'X', 'X', 'O', 'O', 'O'},
            {'O', 'O', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O'},
            {'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O'},
            {'O', 'X', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O'},
            {'G', 'O', 'I', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
    };


    private static char[][] map3 = new char [][] {
            {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
            {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
            {'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O'},
            {'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O'},
            {'O', 'I', 'O', 'O', 'O', 'X', 'X', 'O', 'B', 'O'},
            {'O', 'O', 'O', 'X', 'X', 'X', 'O', 'O', 'O', 'O'},
            {'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O'},
            {'O', 'O', 'X', 'X', 'X', 'X', 'O', 'O', 'O', 'O'},
            {'O', 'O', 'O', 'O', 'G', 'O', 'O', 'O', 'O', 'O'},
            {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}
    };

    private static char[][] map4 = new char [][] {
            {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X'},
            {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O'},
            {'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O'},
            {'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O'},
            {'O', 'I', 'O', 'O', 'O', 'X', 'X', 'O', 'B', 'O'},
            {'O', 'O', 'O', 'X', 'X', 'X', 'O', 'X', 'X', 'O'},
            {'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'X'},
            {'O', 'O', 'X', 'X', 'X', 'X', 'O', 'O', 'O', 'O'},
            {'O', 'O', 'O', 'O', 'G', 'O', 'O', 'O', 'O', 'O'},
            {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}
    };

    private static char[][] map5 = new char [][] {
            {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
            {'O', 'O', 'B', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
            {'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O'},
            {'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O'},
            {'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'O'},
            {'O', 'O', 'O', 'X', 'X', 'X', 'O', 'O', 'O', 'O'},
            {'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'X'},
            {'O', 'O', 'X', 'X', 'X', 'X', 'O', 'O', 'O', 'O'},
            {'O', 'X', 'O', 'O', 'G', 'O', 'X', 'O', 'I', 'O'},
            {'X', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O'}
    };

    private static char[][] map6 = new char [][] {
            {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X'},
            {'O', 'O', 'B', 'O', 'O', 'X', 'X', 'O', 'O', 'O'},
            {'O', 'X', 'X', 'X', 'O', 'O', 'X', 'O', 'O', 'I'},
            {'O', 'X', 'X', 'X', 'O', 'O', 'X', 'X', 'O', 'O'},
            {'O', 'O', 'O', 'O', 'O', 'X', 'X', 'X', 'X', 'O'},
            {'X', 'O', 'O', 'X', 'X', 'X', 'X', 'O', 'O', 'O'},
            {'X', 'X', 'O', 'O', 'O', 'X', 'X', 'O', 'X', 'X'},
            {'O', 'O', 'O', 'X', 'X', 'X', 'O', 'X', 'O', 'X'},
            {'O', 'X', 'X', 'X', 'G', 'O', 'X', 'X', 'O', 'X'},
            {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O'}
    };

    private static char[][][] maps = {map1, map2, map3, map4, map5, map6};

    public static char[][] getMap(int mapNumber) {
        return maps[mapNumber - 1];
    }
}
