import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;

public class DayThreePartOne {
    
    public static void main(String[] args) {
        BufferedReader reader;
        int out = 0;
        Pattern pattern = Pattern.compile("mul\\((-?\\d+),(-?\\d+)\\)|do\\(\\)|don't\\(\\)");

        try {
            reader = new BufferedReader(new FileReader("/Users/naren/Code/fun/aoc_24/3/input.txt"));
            String line = reader.readLine();

            boolean multiply = true;
            while (line != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    if (matcher.group().equals("do()")) {
                       multiply = true; 
                    } else if (matcher.group().equals("don't()")) {
                        multiply = false;
                    } else {
                        if (multiply) out += Integer.parseInt(matcher.group(1))*Integer.parseInt(matcher.group(2));
                    }
                }
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }


        System.out.println(out);
    }
}
