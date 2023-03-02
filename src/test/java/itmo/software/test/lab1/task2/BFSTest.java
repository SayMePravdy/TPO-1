package itmo.software.test.lab1.task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BFSTest {

    @Test
    void testSimpleGraph() {
        Graph graph = new Graph(2);
        graph.addEdge(0, 1);
        assertEquals(2, graph.bfs(1));
    }

    @Test
    void testCycleGraph() {
        Graph graph = new Graph(3);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        assertEquals(3, graph.bfs(2));
    }

    @Test
    void testGraphWithLoop() {
        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        assertEquals(4, graph.bfs(2));
    }

    @Test
    void testDisconnectedGraph() {
        Graph graph = new Graph(8);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(6, 7);
        graph.addEdge(7, 4);

        assertEquals(4, graph.bfs(2));
        graph.resetCounter();
        assertEquals(4, graph.bfs(4));
    }
}
