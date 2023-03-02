package itmo.software.test.lab1.task2;

import java.util.LinkedList;

public class Graph {
    private int v;
    private final LinkedList<Integer>[] adj;
    private int cnt = 0;

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
        cnt++;
    }

    public void resetCounter() {
        cnt = 0;
    }

    public int bfs(int s) {
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
        return cnt;
    }
}

