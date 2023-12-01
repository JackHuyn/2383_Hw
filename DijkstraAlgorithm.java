import java.util.Arrays;

public class DijkstraAlgorithm {

    public static int[] dijkstra(int[][] graph, int start) {
        int vertices = graph.length;
        int[] distances = new int[vertices];
        boolean[] visited = new boolean[vertices];

        // Initialize distances with infinity for all vertices except the start vertex
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        for (int i = 0; i < vertices - 1; i++) {
            int currentVertex = findMinVertex(distances, visited);
            visited[currentVertex] = true;

            System.out.println("Processing vertex: " + currentVertex);

            // Explore neighbors of the current vertex
            for (int j = 0; j < vertices; j++) {
                if (graph[currentVertex][j] != 0 && !visited[j]) {
                    int newDistance = distances[currentVertex] + graph[currentVertex][j];

                    // Update the distance if a shorter path is found
                    if (newDistance < distances[j]) {
                        distances[j] = newDistance;
                        System.out.println("Updating distance to vertex " + j + ": " + newDistance);
                    }
                }
            }
        }

        return distances;
    }

    private static int findMinVertex(int[] distances, boolean[] visited) {
        int minVertex = -1;
        for (int i = 0; i < distances.length; i++) {
            if (!visited[i] && (minVertex == -1 || distances[i] < distances[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0,4,2,0,0,0},
                {4,0,1,5,0,0},
                {2,1,0,8,10,0},
                {0,5,8,0,3,6},
                {0,0,10,3,0,5},
                {0,0,0,6,5,0}
        };

        int startVertex = 0;
        int[] shortestDistances = dijkstra(graph, startVertex);

        System.out.println("Shortest distances from vertex " + startVertex + ": " + Arrays.toString(shortestDistances));
    }
}
