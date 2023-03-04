package itmo.software.test.lab1.task2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BFSTest {

    @DisplayName("Testing algorithm on an empty graph")
    @Test
    void testEmptyGraph() {
        Graph graph = new Graph(0);
        var expectedPath = Collections.emptyList();
        var actualPath = graph.bfs(0);
        assertEquals(expectedPath, actualPath);
    }

    @DisplayName("Testing algorithm on a graph with loop")
    @Test
    void testSimpleGraph() {
        Graph graph = new Graph(2);
        graph.addEdge(0, 1);
        var expectedPath = Stream.of(0, 1).collect(Collectors.toList());
        var actualPath = graph.bfs(0);
        assertEquals(expectedPath, actualPath);
    }

    @DisplayName("Testing algorithm on a cycle graph")
    @Test
    void testCycleGraph() {
        Graph graph = new Graph(3);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);

        var expectedPath = Stream.of(2, 0, 1).collect(Collectors.toList());
        var actualPath = graph.bfs(2);
        assertEquals(expectedPath, actualPath);
    }

    @DisplayName("Testing algorithm on a graph with loop")
    @Test
    void testGraphWithLoop() {
        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        var expectedPath = Stream.of(2, 0, 1, 3).collect(Collectors.toList());
        var actualPath = graph.bfs(2);
        assertEquals(expectedPath, actualPath);
    }

    @DisplayName("Testing algorithm on a disconnected graph")
    @Test
    void testDisconnectedGraph() {
        Graph graph = new Graph(7);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        graph.addEdge(4, 5);
        graph.addEdge(4, 6);

        var expectedPath = Stream.of(2, 0, 1, 3).collect(Collectors.toList());
        var actualPath = graph.bfs(2);
        assertEquals(expectedPath, actualPath);
    }

    @DisplayName("Testing algorithm on a large graph")
    @Test
    void testLargeGraph() {
        Graph graph = new Graph(13);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(6, 7);
        graph.addEdge(6, 5);
        graph.addEdge(6, 8);
        graph.addEdge(6, 9);
        graph.addEdge(9, 10);
        graph.addEdge(9, 12);
        graph.addEdge(11, 12);

        var expectedPath = Stream.of(2, 1, 3, 4, 0, 5, 6, 7, 8, 9, 10, 12, 11).collect(Collectors.toList());
        var actualPath = graph.bfs(2);
        assertEquals(expectedPath, actualPath);
    }
}
