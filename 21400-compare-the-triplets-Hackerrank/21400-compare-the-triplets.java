import java.io.*;
import java.util.*;

class Result {

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int alice = 0;
        int bob = 0;

        for (int i = 0; i < 3; i++) {
            if (a.get(i) > b.get(i)) {
                alice++;
            } else if (a.get(i) < b.get(i)) {
                bob++;
            }
        }

        List<Integer> result = new ArrayList<>();
        result.add(alice);
        result.add(bob);

        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        String[] x = br.readLine().split(" ");
        String[] y = br.readLine().split(" ");

        for (int i = 0; i < 3; i++) {
            a.add(Integer.parseInt(x[i]));
            b.add(Integer.parseInt(y[i]));
        }

        List<Integer> result = Result.compareTriplets(a, b);

        System.out.println(result.get(0) + " " + result.get(1));
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna