import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;

public class DayThreePartTwoo {
    
    public static void main(String[] args) {
        BufferedReader reader;
        int out = 0;
        Pattern pattern = Pattern.compile("mul\\((-?\\d+),(-?\\d+)\\)");

        try {
            reader = new BufferedReader(new FileReader("/Users/naren/Code/fun/aoc_24/3/input.txt"));
            String line = reader.readLine();

            while (line != null) {
                String[] parts = line.split("do\\(\\)"); 
                for (int i=0;i<parts.length;i++) {
                    String[] subParts = parts[i].split("don't\\(\\)");
                    Matcher matcher = pattern.matcher(subParts[0]);
                    while(matcher.find()) {
                        out += Integer.parseInt(matcher.group(1))*Integer.parseInt(matcher.group(2));
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
