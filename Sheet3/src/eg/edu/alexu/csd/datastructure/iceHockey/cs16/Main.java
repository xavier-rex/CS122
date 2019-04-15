package eg.edu.alexu.csd.datastructure.iceHockey.cs16;

import java.awt.Point;

/**
 * A program to find the number of players in a photo.
 */
public class Main implements IPlayersFinder {
    /**
     * This is the description of some variables.
     *
     * @param one minimum values for x and y
     * @param two maximum values for x and y
     */
    private Point one, two;
    /**
     * @param maxY to know the maximum no of strings
     * @param maxX to know the maximum string length
     * @param squaresMoved to know the no of squares moved
     */
    private int maxY, maxX, squaresMoved;

    /**
     * Depth First Search(dfs) is a function to search the the array of strings.
     * @param s array of strings
     * @param visited array of booleans to know the visited squares
     * @param team the number we are searching for
     * @param z start searching from point z
     */
    public final void dfs(final String[] s, final boolean[][] visited,
                    final int team, final Point z) {
        Point p;
        visited[z.y][z.x] = true;

        if (z.x + 1 < maxX && s[z.y].charAt(z.x + 1) == team + '0'
                && !visited[z.y][z.x + 1]) {
            squaresMoved++;
            p = new Point(z.x + 1, z.y);
            if (z.x + 1 > two.x) {
                two.x = z.x + 1;
            }
            dfs(s, visited, team, p);
        }
        if (z.y + 1 < maxY && s[z.y + 1].charAt(z.x) == team + '0'
                && !visited[z.y + 1][z.x]) {
            squaresMoved++;
            p = new Point(z.x, z.y + 1);
            if (z.y + 1 > two.y) {
                two.y = z.y + 1;
            }
            dfs(s, visited, team, p);
        }
        if (z.x - 1 > 0 && s[z.y].charAt(z.x - 1) == team + '0'
                && !visited[z.y][z.x - 1]) {
            squaresMoved++;
            p = new Point(z.x - 1, z.y);
            if (z.x - 1 < one.x) {
                one.x = z.x - 1;
            }
            dfs(s, visited, team, p);
        }
        if (z.y - 1 > 0 && s[z.y - 1].charAt(z.x) == team + '0'
                && !visited[z.y - 1][z.x]) {
            squaresMoved++;
            p = new Point(z.x, z.y - 1);
            if (z.y - 1 < one.y) {
                one.y = z.y - 1;
            }
            dfs(s, visited, team, p);
        }
    }

    /**
     * The main function of the sheet.
     * @param photo array of strings
     * @param team the number we are searching for
     * @param threshold the minimum area valid
     * @return an array of points representing the players positions
     */
    public final java.awt.Point[] findPlayers(final String[] photo,
        final int team, final int threshold) {

        if (photo[0] == null) {
            return null;
        }

        maxY = photo.length;
        maxX = photo[0].length();
        final boolean[][] visited = new boolean[maxY][maxX];
        int maxNo = 1000;
        Point[] ans = new Point[maxNo];
        int k = 0;

        for (int i = 0; i < maxY; i++) {
            for (int j = 0; j < maxX; j++) {
                if (!visited[i][j] && photo[i].charAt(j) == team + '0') {
                    one = new Point(j, i);
                    two = new Point(j, i);
                    squaresMoved = 1;
                    dfs(photo, visited, team, one);
                    // Compare the area to the threshold
                    int area = 4;
                    if (squaresMoved * area >= threshold) {
                        Point position = new Point();
                        // (x1 * 2 + x2 * 2) / 2 + 1 = x1 + x2 + 1
                        position.x = one.x + two.x + 1;
                        // (y1 * 2 + y2 * 2) / 2 + 1 = y1 + y2 + 1
                        position.y = one.y + two.y + 1;
                        ans[k] = position;
                        k++;
                    }
                }
            }
        }

        // Sort the array
        int j;
        for (int i = 1, max = ans.length; i < max && ans[i] != null; i++) {
            Point key = new Point(ans[i]);
            j = i - 1;
            while (j >= 0 && ans[j].x >= key.x) {
                ans[j + 1] = ans[j];
                j--;
            }
            ans[j + 1] = key;
        }
        for (int i = 1, max = ans.length; i < max && ans[i] != null; i++) {
            if (ans[i - 1].x == ans[i].x) {
                Point key = new Point(ans[i]);
                j = i - 1;
                while (ans[j].x == ans[j + 1].x && ans[j].y >= key.y) {
                    ans[j + 1] = ans[j];
                    j--;
                }
                ans[j + 1] = key;
            }
        }
        return ans;
    }

    /**
     * The main function.
     * @param args arguments
     */
    public static void main(final String[] args) {
        Main main = new Main();
        String[] s = new String[1];
        int team = 8, threshold = 9;
        Point[] test = main.findPlayers(s, team, threshold);

        if (test != null) {
            for (int i = 0; i < test.length && test[i] != null; i++) {
                System.out.println(test[i]);
            }
        }


    }
}
