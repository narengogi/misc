import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DayFourPartOne {
    
    private static int out = 0;
    private static char[][] m = new char[140][140];
    private static int[][] dirs = new int[][]{{1, 1}, {1, 0}, {0, 1}, {-1, 0}, {-1, -1}, {0, -1}, {-1, 1}, {1, -1}};
    public static void main(String[] args) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("/Users/naren/Code/fun/aoc_24/4/input.txt"));
            String line = reader.readLine();
            
            int i = 0;
            while (line != null) {
                int j = 0;
                for (char c:line.toCharArray()) {
                    m[i][j] = c;
                    j++;
                } 
                i++;
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        for (int i=0;i<140;i++) {
            for (int j=0;j<140;j++) {
                if (m[i][j] == 'X') {
                    for (int[] dir:dirs) {
                        helper(i, j, 'M', dir);
                    }
                }
            }
        }
        System.out.println(out);

    }

    private static void helper(int i, int j, char c, int[] dir) {
        int newI = i+dir[0];
        int newJ = j+dir[1];
        if (newI > -1 && newJ > -1 && newI < 140 && newJ < 140) {
            if (m[newI][newJ] == c) {
                if (c == 'S') {
                    out++;
                    return;
                } else {
                    char nextChar = c == 'M' ? 'A' : 'S';
                    helper(newI, newJ, nextChar, dir); 
                }
            }
        }
    }

}
