import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DayFourPartOne {
    
    public static void main(String[] args) {
        BufferedReader reader;

        int i = 0;
        try {
            reader = new BufferedReader(new FileReader("/Users/naren/Code/fun/aoc_24/4/input.txt"));
            String line = reader.readLine();
            System.out.println(line.length());

            while (line != null) {
                i++;
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        System.out.println(i);
    }
}
