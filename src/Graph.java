import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Class representing a graph that allows to find the shortest path between two nodes
 */

public class Graph {
    private final List<Node>[] edges;
    private final int nVertices;

    public Graph(List<Node>[] edges) {
        this.edges = edges;
        nVertices = edges.length;
    }

    /**
     * Finds the shortest path between two nodes using the Dijkstra algorithm
     * (Terminates only if the graph contains no negative cycles)
     * @param source the starting point of the path
     * @param dest the end point of the path
     * @return the shortest path between the two nodes
     */

    public Path Dijkstra(int source, int dest) {
        double[] dist = new double[nVertices];
        int[] prev = new int[nVertices];
        dist[dest] = 0;

        for (int i = 0; i < nVertices; i++) {
            double maxDist = Double.MAX_VALUE / 2 - 1;
            if (i != dest) dist[i] = maxDist;
            prev[i] = -1;

        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(dest, 0.0));

        while (!pq.isEmpty()) {
            Node top = pq.poll();
            double d = top.dist;
            int id = top.id;
            if (d > dist[id]) continue;
            for (int j = 0; j < edges[id].size(); j++) {
                Node v = edges[id].get(j);
                if (dist[id] + v.dist < dist[v.id]){
                    dist[v.id] = dist[id] + v.dist;
                    pq.add(new Node(v.id, dist[v.id]));
                    prev[v.id] = id;
                }
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        res.add(source);
        while (prev[res.getLast()]!=-1){
            res.add(prev[res.getLast()]);
        }
        return new Path(res, dist[source]);
    }



}