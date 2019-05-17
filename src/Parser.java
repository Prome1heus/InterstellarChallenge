import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 * A class used to parse a graph from a json file into usable information
 */

public class Parser {

    /**
     * Function that extracts an adjacency list of a graph of an file in the specified format
     *  @param path the relative location of the file
     *  @return     the adjacency list of the represented graph
     */
    public static List<Node>[] readEdges(String path){
        try{
            //Read complete file decribing the graph
            String content = new String(Files.readAllBytes(Paths.get(path)));

            //Reformat the information about edges in the Graph from
            //the specified format for the challenge into ICPC style
            content = content.substring(content.indexOf("edges")+8);
            content = content.replaceAll("\"", "");
            content = content.replaceAll("source:", "");
            content = content.replaceAll("target:", "");
            content = content.replaceAll("cost:", "");
            content = content.replaceAll("\\{", "");
            content = content.replaceAll("}", "");
            content = content.replaceAll("\\[", "");
            content = content.replaceAll("]", "");
            String[] info = content.split(",");

            //Convert the information to an adjacency list
            int l = info.length / 3;
            List<Node>[] res = new LinkedList[l];
            for (int i=0; i<l; i++) res[i] = new LinkedList<>();
            for (int i=0; i<info.length; i+=3){
                int source = Integer.parseInt(info[i]);
                int dest = Integer.parseInt(info[i+1]);
                double cost = Double.parseDouble(info[i+2]);
                res[source].add(new Node(dest, cost));
                //Add the edge in both directions since it is an undirected graph
                res[dest].add(new Node(source, cost));
            }
            return res;
        }catch (IOException e){
            return null;
        }
    }


    /**
     * Function that extracts the id of a node from a file of the specified format
     *  @param path the relative location of the file
     *  @param name the name of the node
     *  @return     the id of the node
     */
    public static int getIdOfNode(String path, String name){
        try{
            int i = 0, pos;
            String content = new String(Files.readAllBytes(Paths.get(path)));
            while ((pos = content.indexOf("label")) != -1){
                content = content.substring(pos+8);
                if (content.startsWith(name)) return i;
                i++;
            }
            return -1;
        }catch(IOException e){
            return -1;
        }

    }
}
