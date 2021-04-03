package problemsolving.hard;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Requirement {

    // Solution inspired by riaanvo. What a brilliant logic.
    // It fails to run at the expected times by the platform.
    static int requirement(int n, int[][] requirement) {
        requirement = reduceRules(requirement);

        boolean finished = false;
        int numPossible = 0;

        int[] a = new int[n];
        Arrays.fill(a, 9);
        reorganizeToBaseRules(a, requirement);

        while (!finished) {
            numPossible += 1;
            boolean passedThroughNine = false;
            a[0]--;

            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] == -1) {
                    a[i] = 9;
                    a[i+1]--;
                    passedThroughNine = true;
                } else {
                    break;
                }
            }

            if (passedThroughNine) {
                reorganizeToBaseRules(a, requirement);
            }

            if (a[a.length - 1] == 0) {
                int sum = 0;
                for(int x : a) sum += x;
                finished = sum == 0;
            }
        }

        numPossible++;
        return numPossible % 1007;
    }

    static int[][] reduceRules(int[][] requirement){
        int ruleCount = 0;
        for (int i = 0; i < requirement.length - 1; i++) {
            if (requirement[i][0] != -1) {
                ruleCount++;
                for (int j = i + 1; j < requirement.length; j++) {
                    if (requirement[j][0] == -1) continue;
                    if (requirement[i][0] == requirement[j][0] && requirement[i][1] == requirement[j][1]) {
                        requirement[j][0] = -1;
                    }
                }
            }
        }

        if (requirement[requirement.length-1][0] != -1) ruleCount++;

        int[][] newRequirement = new int[ruleCount][2];
        ruleCount--;
        for (int i = requirement.length - 1; i >= 0; i--) {
            if (requirement[i][0] != -1) {
                newRequirement[ruleCount] = requirement[i];
                ruleCount--;
            }
        }
        return newRequirement;
    }

    static void reorganizeToBaseRules(int[] a, int[][] requirement) {
        for (int i = a.length - 2; i >= 0; i--) {
            for (int[] x : requirement) {
                if (!(a[x[0]] <= a[x[1]])) {
                    a[x[0]] = a[x[1]];
                }
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] requirement = new int[m][2];

        for (int reqRowItr = 0; reqRowItr < m; reqRowItr++) {
            String[] reqRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

            for (int reqColumnItr = 0; reqColumnItr < 2; reqColumnItr++) {
                int reqItem = Integer.parseInt(reqRowItems[reqColumnItr]);
                requirement[reqRowItr][reqColumnItr] = reqItem;
            }
        }

        int result = requirement(n, requirement);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
