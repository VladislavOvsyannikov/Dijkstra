import java.util.*;
public class Dijkstra {

    public int distances[];
    private Set<Integer> settled;
    private Set<Integer> unsettled;
    private int size;
    private int matrix[][];

    public Dijkstra(int size, int[][] matrix) {
        this.size = size;
        this.matrix = matrix;
        distances = new int[size + 1];
        settled = new HashSet<>();
        unsettled = new HashSet<>();
    }

    public void dijkstra_algorithm(int source) {
        int evaluationNode;

        for (int i = 1; i <= size; i++) {
            distances[i] = Integer.MAX_VALUE;
        }

        unsettled.add(source);
        distances[source] = 0;
        while (!unsettled.isEmpty()) {
            evaluationNode = getNodeWithMinimumDistanceFromUnsettled();
            unsettled.remove(evaluationNode);
            settled.add(evaluationNode);
            evaluateNeighbours(evaluationNode);
        }
    }

    private int getNodeWithMinimumDistanceFromUnsettled() {
        int min;
        int node;

        Iterator<Integer> iterator = unsettled.iterator();
        node = iterator.next();
        min = distances[node];
        for (int i = 1; i <= distances.length; i++) {
            if (unsettled.contains(i)) {
                if (distances[i] <= min) {
                    min = distances[i];
                    node = i;
                }
            }
        }
        return node;
    }

    private void evaluateNeighbours(int evaluationNode) {
        int edgeDistance;
        int newDistance;

        for (int destinationNode = 1; destinationNode <= size; destinationNode++) {
            if (!settled.contains(destinationNode)) {
                if (matrix[evaluationNode][destinationNode] != Integer.MAX_VALUE) {
                    edgeDistance = matrix[evaluationNode][destinationNode];
                    newDistance = distances[evaluationNode] + edgeDistance;
                    if (newDistance < distances[destinationNode]) {
                        distances[destinationNode] = newDistance;
                    }
                    unsettled.add(destinationNode);
                }
            }
        }
    }
}
