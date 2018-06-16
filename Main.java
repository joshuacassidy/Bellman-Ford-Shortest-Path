import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vertex> vertices = new ArrayList<>();
        vertices.add(new Vertex("A"));
        vertices.add(new Vertex("B"));
        vertices.add(new Vertex("C"));

        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(1, vertices.get(0), vertices.get(1)));
        edges.add(new Edge(-1, vertices.get(1), vertices.get(2)));
        edges.add(new Edge(-11, vertices.get(0), vertices.get(2)));

        BellmanFord bellmanFord = new BellmanFord(edges, vertices);
        System.out.println(bellmanFord.bellmanFord(vertices.get(0), vertices.get(2)));

    }
}
