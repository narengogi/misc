import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DayOnePartOne {
    
    public static void main(String[] args) {
        BufferedReader reader;
        List<Integer> l1 = new ArrayList<Integer>();
        Map<Integer, Integer> right = new HashMap<Integer, Integer>();

        try {
            reader = new BufferedReader(new FileReader("path"));
            String line = reader.readLine();

            while (line != null) {
                String[] parts = line.split("   ");
                l1.add(Integer.parseInt(parts[0]));
                right.compute(Integer.parseInt(parts[1]), (k, v)->v==null?1:v+1);
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        Collections.sort(l1);

        int sum = 0;
        for(int i=0;i<l1.size();i++) {
            sum += right.getOrDefault(l1.get(i), 0) * l1.get(i);
        }
        
        System.out.println(sum);
    }
}
