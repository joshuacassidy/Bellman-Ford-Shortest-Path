import java.util.List;

public class BellmanFord {

    private List<Edge> edges;
    private List<Vertex> vertices;

    public BellmanFord(List<Edge> edges, List<Vertex> vertices) {
        this.edges = edges;
        this.vertices = vertices;
    }

    public String bellmanFord(Vertex source, Vertex target) {
        source.setDistance(0);
        for (int i = 0; i < vertices.size()-1; i++) {
            for (Edge edge: edges) {
                Vertex u = edge.getStartVertex();
                Vertex v = edge.getTargetVertex();
                if (u.getDistance() != Double.MAX_VALUE) {
                    double newDistance = u.getDistance() + edge.getWeight();
                    if (newDistance < v.getDistance()) {
                        v.setDistance(newDistance);
                        v.setPredecessor(u);
                    }
                }
            }
        }
        for (Edge edge: edges) {
            if (edge.getStartVertex().getDistance() != Double.MAX_VALUE && hasCycle(edge)) {
                    throw new CycleFoundException("Negative cycle found");
            }
        }
        return shortestPathTo(target);
    }

    private boolean hasCycle(Edge edge) {
        return edge.getStartVertex().getDistance() + edge.getWeight() < edge.getTargetVertex().getDistance();
    }

    public String shortestPathTo(Vertex target) {
        String distance = "There is a shortest path from source to target, with cost: " + target.getDistance();
        String s;
        for (s = ""; target != null; target=target.getPredecessor()) {
            s+=target.getName() + " ";
        }

        String output = "";
        for(int i = s.length() - 2; i >= 0; i--) {
            output = output + s.charAt(i);
        }

        return distance + "\nPath: " + output;
    }

}
