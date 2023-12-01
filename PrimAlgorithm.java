import java.util.Arrays;

public class PrimAlgorithm {
    public static void main(String[] args) {
        int[][] arr = {
            {'-', 4, 5, '-', '-', '-', '-'},
            {4, '-', 3, 11, 12, '-', 14},
            {5, 3, '-', 6, '-', '-', '-'},
            {'-', 11, 6, '-', 1, '-', '-', '-'},
            {'-', 12, '-', 1, '-', '-', 9, 8},
            {'-', '-', '-', '-', 9, '-', 7},
            {'-', 14, '-', '-', 8, 7, '-'}
        };

        int startVertex = 0;
        primAndPrint(arr, startVertex);
    }

    public static void primAndPrint(int[][] graph, int start) {
        int n = graph.length;
        int[] parent = new int[n];
        int[] key = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(key, Integer.MAX_VALUE);
        key[start] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = extractMin(key, visited);

            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] != '-' && !visited[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        printMinimumSpanningTree(parent, graph);
    }

    public static void printMinimumSpanningTree(int[] parent, int[][] graph) {
        int n = parent.length;
        System.out.println("Edges in the Minimum Spanning Tree:");

        for (int i = 1; i < n; i++) {
            int weight = graph[i][parent[i]];
            System.out.println(parent[i] + " - " + i + " (Weight: " + weight + ")");
        }
    }

    public static int extractMin(int[] key, boolean[] visited) {
        int minKey = Integer.MAX_VALUE;
        int minVertex = -1;

        for (int v = 0; v < key.length; v++) {
            if (!visited[v] && key[v] < minKey) {
                minKey = key[v];
                minVertex = v;
            }
        }

        return minVertex;
    }
}
