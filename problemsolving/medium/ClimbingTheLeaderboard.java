package problemsolving.medium;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ClimbingTheLeaderboard {

    public static int[] climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        int n = ranked.size();
        int m = player.size();

        int[] res = new int[m];
        int[] rank = new int[n];

        rank[0] = 1;

        for (int i = 1; i < n; i++) {
            if (ranked.get(i).equals(ranked.get(i - 1))) {
                rank[i] = rank[i - 1];
            } else {
                rank[i] = rank[i - 1] + 1;
            }
        }

        for (int i = 0; i < m; i++) {
            int playerScore = player.get(i);
            if (playerScore > ranked.get(0)) {
                res[i] = 1;
            } else if (playerScore < ranked.get(n - 1)) {
                res[i] = rank[n - 1] + 1;
            } else {
                int index = binarySearch(ranked, playerScore);
                res[i] = rank[index];
            }
        }
        return res;
    }

    private static int binarySearch(List<Integer> a, int key) {
        int low = 0;
        int high = a.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a.get(mid) == key) {
                return mid;
            } else if (a.get(mid) < key && key < a.get(mid - 1)) {
                return mid;
            } else if (a.get(mid) > key && key >= a.get(mid + 1)) {
                return mid + 1;
            } else if (a.get(mid) < key) {
                high = mid - 1;
            } else if (a.get(mid) > key) {
                low = mid + 1;
            }
        }
        return -1;
    }
}

class SolutionLeaderboard {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int[] result = ClimbingTheLeaderboard.climbingLeaderboard(ranked, player);

        for (int j : result) {
            bufferedWriter.write(j + "\n");
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
