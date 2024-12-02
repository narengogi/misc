import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DayTwoPartOne {
    
    public static void main(String[] args) {
        BufferedReader reader;
        int out = 0;

        try {
            reader = new BufferedReader(new FileReader("/Users/naren/Code/fun/aoc_24/2/day_two.txt"));
            String line = reader.readLine();

            while (line != null) {
                String[] numString = line.split(" ");
                int[] nums = new int[numString.length];
                int[] reversedNums = new int[numString.length];
                for (int i=0;i<numString.length;i++){
                    nums[i] = Integer.parseInt(numString[i]);
                    reversedNums[i] = Integer.parseInt(numString[numString.length-1-i]);
                }
                boolean increasing = checkDecreasing(nums); 
                boolean decreasing = checkDecreasing(reversedNums);
                if (increasing || decreasing) out++;
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        System.out.println(out);
    }

    private static boolean checkDecreasing(int[] nums) {
        int i = 1;
        boolean tolerated = false;
        while (i<nums.length) {
            int prev = nums[i-1];
            int curr = nums[i];
            int diff = prev - curr;
            if (diff > 0 && diff < 4) {
                i++;
            } else return false;
        }
        return true;
    }

}
