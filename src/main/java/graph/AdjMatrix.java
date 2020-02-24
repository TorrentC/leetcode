package graph;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author torrent
 * @date 20-2-24 下午4:27
 */
public class AdjMatrix {
    private int V;
    private int E;
    private int[][] adj;

    public AdjMatrix(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            V = scanner.nextInt();
            E = scanner.nextInt();

            adj = new int[V][V];
            for (int i = 0; i < E; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                adj[a][b] = 1;
                adj[b][a] = 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Vertex: %d Edge: %d\n", V, E));
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                builder.append(String.format("%d ", adj[i][j]));
            }
            builder.append('\n');
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        AdjMatrix adjMatrix = new AdjMatrix("adjMatrix.txt");
        System.out.println(adjMatrix);
    }
}
