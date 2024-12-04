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
                if (m[i][j] == 'A') if (isValid(i, j)) out++;
            }
        }
        System.out.println(out);

    }

    private static boolean isValid(int i, int j) {
       if (isLeftValid(i, j) && isRightValid(i, j)) return true; 
       return false;
    }

    private static boolean isLeftValid(int i, int j) {
        if (!inBounds(i-1, j-1) || !inBounds(i+1, j+1)) return false;
        if ((m[i-1][j-1] == 'M' && m[i+1][j+1] == 'S') || (m[i-1][j-1] == 'S' && m[i+1][j+1] == 'M')) return true;
        return false;
    }

    private static boolean isRightValid(int i, int j) {
        if (!inBounds(i+1, j-1) || !inBounds(i-1, j+1)) return false;
        if ((m[i+1][j-1] == 'M' && m[i-1][j+1] == 'S') || (m[i+1][j-1] == 'S' && m[i-1][j+1] == 'M')) return true;
        return false;
    }

    private static boolean inBounds(int i, int j) {
        if (i > -1 && j > -1 && i < 140 && j < 140) return true;
        return false;
    }

}
