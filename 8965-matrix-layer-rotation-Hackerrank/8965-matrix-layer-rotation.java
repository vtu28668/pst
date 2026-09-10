import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'matrixRotation' function below.
     *
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY matrix
     *  2. INTEGER r
     */

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
    int m = matrix.size();
    int n = matrix.get(0).size();

    int[][] a = new int[m][n];

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            a[i][j] = matrix.get(i).get(j);
        }
    }

    for (int layer = 0; layer < Math.min(m, n) / 2; layer++) {

        int top = layer;
        int left = layer;
        int bottom = m - 1 - layer;
        int right = n - 1 - layer;

        int count = 2 * (bottom - top + right - left);
        int rotations = r % count;

        for (int x = 0; x < rotations; x++) {
            int temp = a[top][left];

            for (int i = left; i < right; i++) {
                a[top][i] = a[top][i + 1];
            }

            for (int i = top; i < bottom; i++) {
                a[i][right] = a[i + 1][right];
            }

            for (int i = right; i > left; i--) {
                a[bottom][i] = a[bottom][i - 1];
            }

            for (int i = bottom; i > top; i--) {
                a[i][left] = a[i - 1][left];
            }

            a[top + 1][left] = temp;
        }
    }

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            System.out.print(a[i][j] + " ");
        }
        System.out.println();
    }
}

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna