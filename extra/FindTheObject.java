package extra;

import java.util.ArrayList;
import java.util.List;

public class FindTheObject {

    /*
        You're in charge of finding a missing object on a lot with trenches.

        Some assumptions:
        - The lot is flat and can be represented by an 2D grid.
        - You have to start the search from the top left corner, and you can move up, left, right, down.
        - You cannot enter a tile if there's a trench present.
        - Clean tiles are represented by 1, trenches by 0 and the missing object by 9.

        Input: (lot) - a 2D grid of integers
        Output: Return an integer that indicates the minimum distance

        The return should be "-1" if no path is possible
     */
    static int shortestPath = Integer.MAX_VALUE;
    static int[][] twoDPathArray;

    private static int findMissingObject(List<List<Integer>> lot) {
        // Verifies if lot equals null
        if (lot == null) {
            return -1;
        }

        // Verifies if lot is less or greater than 0
        if (lot.size() <= 0 || lot.get(0).size() <= 0) {
            return -1;
        }

        twoDPathArray = new int[lot.size()][lot.get(0).size()];

        depthFirstSearch(lot, 0, 0, 0);

        return shortestPath == Integer.MAX_VALUE ? -1 : shortestPath;
    }

    private static void depthFirstSearch(List<List<Integer>> grid, int i, int j, int dist) {
        if (i < 0 || i >= grid.size() || j < 0 || j >= grid.get(0).size() || grid.get(i).get(j) == 0) {
            return;
        }

        if (twoDPathArray[i][j] > 0 && dist >= twoDPathArray[i][j]) {
            return;
        }

        if (grid.get(i).get(j) == 9) {
            shortestPath = Math.min(shortestPath, dist);
        }

        twoDPathArray[i][j] = dist;

        depthFirstSearch(grid, i - 1, j, dist + 1);
        depthFirstSearch(grid, i + 1, j, dist + 1);
        depthFirstSearch(grid, i, j - 1, dist + 1);
        depthFirstSearch(grid, i, j + 1, dist + 1);
    }

    public static void main(String[] args) {
        List<List<Integer>> path = new ArrayList<>();
        System.out.println(findMissingObject(path));
    }
}
