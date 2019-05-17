import java.util.LinkedList;

/**
 * Class used to represent a path through a graph
 */

public class Path {
    public final LinkedList<Integer> path;
    public final double dist;

    public Path(LinkedList<Integer> path, double dist){
        this.path = path;
        this.dist = dist;
    }

    @Override
    public String toString(){
        String res = "The total distance travelled is: " + dist + "\n";
        for (int i=0; i<path.size(); i++){
            res += path.get(i) + " ";
        }
        return res + "\n";
    }
}
