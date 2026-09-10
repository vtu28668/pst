import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashSet<String> pairs = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String first = sc.next();
            String second = sc.next();

            // Create a unique representation of the pair
            String pair = first + " " + second;

            pairs.add(pair);

            System.out.println(pairs.size());
        }

        sc.close();
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna