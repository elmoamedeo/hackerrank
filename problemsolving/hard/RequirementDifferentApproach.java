package problemsolving.hard;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class RequirementDifferentApproach {

    // Inspired in dbarbu. This one passes in performance but I just don't get it LMAO.
    // And it is necessary to change psvm.
    static int n = 15;
    static int[][] adj;
    static Map<Integer, Map<Long, Long>> memoMap = new HashMap<>();

    static {
        for (int v = 0; v <= n; v++) {
            memoMap.put(v, new HashMap<>());
        }
    }

    static long calcR(int[] vals, int k) {
        int[] maxV = calcFK(vals, k);
        long key = 0;
        for (int mv : maxV) {
            key = key * 10+mv;
        }
        Long ans = memoMap.get(k).get(key);
        if (ans != null) {
            return ans;
        }
        if (k == n-1) {
            ans = maxV[0] + 1L;
            memoMap.get(k).put(key, ans);
            return ans;
        } else {
            ans = 0L;
            for(int v = maxV[0]; v >= 0; v--) {
                vals[k] = v;
                ans += calcR(vals, k+1);
            }
            memoMap.get(k).put(key, ans);
            return ans;
        }
    }

    static private int[] calcFK(int[] vals, int k) {
        int[] ans = new int[n-k];
        for(int i = 0; i < n-k; i++) {
            ans[i] = 9;
        }
        for (int i = 0; i < k; i++) {
            int mv = vals[i];
            int[] np = adj[i];
            for (int npAV : np) {
                if (npAV >= k) {
                    int val = ans[npAV - k];
                    if (val > mv) {
                        ans[npAV - k] = mv;
                    }
                }
            }
        }
        return ans;
    }

    static class Node {
        int v;
        List<Integer> adjL = new ArrayList<>();
        List<Integer> adjTGL = new ArrayList<>();
        int index;

        int color = 0;
        int startT = 0;
        int endT = 0;

        public Node(int v) {
            this.v = v;
        }
    }

    static long requirement(int[][] req) {
        int m = req.length;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < m; i++) {
            int to = req[i][0];
            int from = req[i][1];
            nodes[from].adjL.add(to);
            nodes[to].adjTGL.add(from);
        }
        process(nodes);
        return calcR(new int[n], 0);
    }

    static LinkedList<Set<Node>> listSCC = new LinkedList<>();

    private static void process(Node[] nodes) {
        DFS(nodes);
        for (int i = 0; i < n; i++) {
            nodes[i].color = 0;
        }
        List<Node> tSL2 = tSL;
        tSL = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Node node = tSL2.get(i);
            if (node.color == 0) {
                Set<Node> set = new HashSet<>();
                set.add(node);
                DFS_VISIT(set, nodes, node, true);
                listSCC.add(set);
            }
        }
        int k = 0;
        for (Set<Node> nodeSet : listSCC) {
            Set<Node> cc = nodeSet;
            for (Node node : cc) {
                node.index = k;
            }
            k++;
        }
        adj = new int[k][];
        for (int i = 0; i < listSCC.size(); i++) {
            Set<Integer> set = new HashSet<>();
            Set<Node> cc = listSCC.get(i);
            for (Node node : cc) {
                for (int ad : node.adjL) {
                    Node na = nodes[ad];
                    if (na.index != node.index) {
                        set.add(na.index);
                    }
                }
            }
            int[] adN = new int[set.size()];
            int p = 0;
            for (int a : set) {
                adN[p++] = a;
            }
            adj[i] = adN;
        }
        n = k;
    }

    static int time = 0;
    static LinkedList<Node> tSL = new LinkedList<>();

    private static void DFS(Node[] nodes) {
        for (int i = 0; i < n; i++) {
            Node node = nodes[i];
            if (node.color == 0) {
                Set<Node> set = new HashSet<>();
                set.add(node);
                DFS_VISIT(set, nodes, nodes[i], false);
            }
        }
    }

    private static void DFS_VISIT(Set<Node> set, Node[] nodes, Node u, boolean transposeG) {
        time++;
        u.startT = time;
        u.color = 1;
        List<Integer> adL = transposeG ? u.adjTGL : u.adjL;
        for (int adjN : adL) {
            Node v = nodes[adjN];
            if (v.color == 0) {
                set.add(v);
                DFS_VISIT(set, nodes, v, transposeG);
            }
        }
        u.color = 2;
        tSL.addFirst(u);
        time++;
        u.endT = time;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] nm = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
        n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);
        int[][] req = new int[m][2];

        for (int reqRowItr = 0; reqRowItr < m; reqRowItr++) {
            String[] reqRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

            for (int reqColumnItr = 0; reqColumnItr < 2; reqColumnItr++) {
                int reqItem = Integer.parseInt(reqRowItems[reqColumnItr]);
                req[reqRowItr][reqColumnItr] = reqItem;
            }
        }

        long result = requirement(req);

        bufferedWriter.write(String.valueOf(result % 1007));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
