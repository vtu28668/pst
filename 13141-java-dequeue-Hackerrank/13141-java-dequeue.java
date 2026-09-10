import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> frequency = new HashMap<>();

        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            // Add current number to deque
            deque.addLast(num);

            // Update frequency
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);

            // Once window size becomes m
            if (deque.size() == m) {

                // Number of unique elements in current window
                maxUnique = Math.max(maxUnique, frequency.size());

                // Remove the first element before moving window
                int removed = deque.removeFirst();

                frequency.put(removed, frequency.get(removed) - 1);

                // Remove from map if frequency becomes zero
                if (frequency.get(removed) == 0) {
                    frequency.remove(removed);
                }
            }
        }

        System.out.println(maxUnique);

        sc.close();
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna