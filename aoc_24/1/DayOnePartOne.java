import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DayOnePartOne {
    
    public static void main(String[] args) {
        BufferedReader reader;
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();

        try {
            reader = new BufferedReader(new FileReader("path"));
            String line = reader.readLine();

            while (line != null) {
                String[] parts = line.split("   ");
                l1.add(Integer.parseInt(parts[0]));
                l2.add(Integer.parseInt(parts[1]));
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        Collections.sort(l1);
        Collections.sort(l2);

        int sum = 0;
        for(int i=0;i<l1.size();i++) {
            sum += Math.abs(l1.get(i)-l2.get(i));
        }
        
        System.out.println(sum);
    }
}
