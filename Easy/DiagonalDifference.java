package Easy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DiagonalDifference {

    public static int diagonalDifference(List<List<Integer>> arr) {
        int left_to_right_diag = 0, right_to_left_diag = 0;
        int rows = arr.size(), columns = arr.get(0).size();
        int i = 0, j = 0, k = 0, l = arr.size() - 1;
        while (i < rows && j < columns && k < rows && l >= 0) {
            left_to_right_diag += arr.get(i).get(j);
            right_to_left_diag += arr.get(k).get(l);
            i++;
            j++;
            k++;
            l--;
        }
        return Math.abs(left_to_right_diag - right_to_left_diag);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = DiagonalDifference.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
