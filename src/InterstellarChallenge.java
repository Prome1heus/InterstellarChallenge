
public class InterstellarChallenge {
    public static void main(String[] args){
        String path = "generatedGraph.json";
        //Create graph from file
        Graph g = new Graph(Parser.readEdges(path));
        //Print result
        System.out.print(g.Dijkstra(Parser.getIdOfNode(path, "Erde"), Parser.getIdOfNode(path, "b3-r7-r4nd7")));
    }
}
