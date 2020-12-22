package ex1;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//This class represents an implementation of algorithms on a weighted graph
//This class contains methods of checking if there is a path from every node to an other node,
//funding the shortest path and  its length from a node to an other node, saving the graph on a file,
//and load a file
public class WGraph_Algo implements weighted_graph_algorithms {
    private weighted_graph gr;

    @Override
    public void init(weighted_graph g) {
        gr = g;
    } //Init the graph that the algorithms will be on

    @Override
    public weighted_graph getGraph() {
        return gr;
    }  //Returns the graph

    @Override
    public weighted_graph copy() { //Deep copy of the graph
        WGraph_DS gr1 = new WGraph_DS((WGraph_DS) gr); // A use of the copy constructors
        return gr1;
    }

    @Override
    public boolean isConnected() { //A function that checks if the graph is connected (if there is a path between every node to an other node)
        if (countDFS(0) == gr.edgeSize())
            return true;
        return false;
    }

    @Override
    public double shortestPathDist(int src, int dest) { //A function that return the shortest path's length between two nodes by their keys
        return (dijkstra(gr.getNode(src), gr.getNode(dest)).size());
    }

    @Override
    public List<node_info> shortestPath(int src, int dest) { //A function that return the shortest path between two nodes by their keys
        return dijkstra(gr.getNode(src), gr.getNode(dest));
    }

    @Override
    public boolean save(String file) {
        boolean answer = false;
        ObjectOutputStream os;
        try{
            FileOutputStream fs = new FileOutputStream(file, true);
            os = new ObjectOutputStream(fs);
            os.writeObject(this);
            answer = true;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }

    @Override
    public boolean load(String file) {
        FileInputStream fs = null;
        try {
            fs = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectInputStream os = null;
        try {
            os = new ObjectInputStream(fs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            WGraph_Algo readCase = (WGraph_Algo) os.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }

    public int countDFS(int src) { //DFS algorithms - going over all the nodes in the graph (return the amount of connected nodes)
        int count = 0;
        boolean[] visited = new boolean[gr.nodeSize()]; //Visited array in order to know if a node was already "visited"
        for (int i = 0; i < visited.length; i++) //Reset all to false
            visited[i] = false;
        visited[src] = true; //Mark the node as visited
        count++; //Increase the count if the node is visited
        for (node_info nei : gr.getV(src)) { //Go over all the neighbours of this node
            if (!visited[nei.getKey()]) //If a node is unvisited, do this function on it
                return (countDFS(nei.getKey()));
            count++; //Increase the count if the node is visited
        }
        return count;
    }

    public List<node_info> dijkstra(node_info s, node_info d) { //Dijkstra algorithm
        double tag = Double.MAX_VALUE;
        List<node_info> path= new LinkedList<>(); //A list which present every node "parent" in the shortest path
        Queue<node_info> queue= new LinkedList<>(); //A queue of the nodes
        for (node_info node : gr.getV()) {
            node.setTag(tag); //Set every node's tag to the max in the beginning
            queue.add(node); //Add the node to the queue
        }
        gr.getNode(s.getKey()).setTag(0);
        while (!queue.isEmpty()) {
            node_info firstNode = queue.poll();  //The first node equals now to head of the queue (and removes it from the queue)
            for (node_info node : gr.getV(firstNode.getKey())) {
                double weight = firstNode.getTag() + gr.getEdge(firstNode.getKey(), node.getKey());
                if (weight < node.getTag()) {  //Checks if this weight is smaller
                    node.setTag(weight); //Set this weight as the node's tag
                    node.setInfo(firstNode.toString()); //Set this "parent node" as the node's info
                }
            }
        }
        return path(s,d,path); //Returns the path
    }
    public List<node_info> path(node_info node1, node_info node2, List<node_info> path){
        path.add(gr.getNode(Integer.parseInt(node2.getInfo()))); //Add this node info to the path
        while(gr.getNode(Integer.parseInt(node2.getInfo())) != node1) //While the path isn't at the end (actually at the first node wich is the beginning)
            path(node1, gr.getNode(Integer.parseInt(node2.getInfo())), path); //Do the same function on its parent
        path.add(node1); //In the end, add the first node to the path
        Collections.reverse(path); //Reverse the path
        return path;
    }
}
