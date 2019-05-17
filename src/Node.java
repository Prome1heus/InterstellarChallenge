/**
 * A class used to implement the graph class
 */
public class Node implements Comparable<Node> {
    public final int id;
    public final double dist;

    public Node(int id, double dist) {
        this.id = id;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node o1) {
        return (this.dist < o1.dist ? 1 : -1);
    }

}

