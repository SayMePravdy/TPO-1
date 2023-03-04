package itmo.software.test.lab1.task2;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    private int v;
    private final List<Integer>[] adj;
    private final List<Integer> path = new LinkedList<>();

    Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void visit(boolean[] visited, LinkedList<Integer> queue, int s) {
        visited[s] = true;
        queue.add(s);
        path.add(s);
    }

    public List<Integer> bfs(int s) {
        if (adj.length != 0) {
            boolean[] visited = new boolean[v];

            LinkedList<Integer> queue
                    = new LinkedList<>();

            visit(visited, queue, s);

            while (queue.size() != 0) {
                s = queue.poll();

                for (int v : adj[s]) {
                    if (!visited[v]) {
                        visit(visited, queue, v);
                    }
                }
            }
        }
        return path;
    }
}

