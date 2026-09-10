import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of lines
        int n = sc.nextInt();

        // Store all lines
        ArrayList<ArrayList<Integer>> lines = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            // Number of integers in this line
            int d = sc.nextInt();

            ArrayList<Integer> list = new ArrayList<>();

            for (int j = 0; j < d; j++) {
                list.add(sc.nextInt());
            }

            lines.add(list);
        }

        // Number of queries
        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {

            // x = line number, y = position
            int x = sc.nextInt();
            int y = sc.nextInt();

            // Convert to 0-based indexing
            if (x >= 1 && x <= lines.size()
                    && y >= 1 && y <= lines.get(x - 1).size()) {

                System.out.println(lines.get(x - 1).get(y - 1));

            } else {
                System.out.println("ERROR!");
            }
        }

        sc.close();
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna