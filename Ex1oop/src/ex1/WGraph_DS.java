package ex1;

import java.util.Collection;
import java.util.HashMap;

//This class represents an implementation of weighted graph by HashMap of all the node of the graph,
//and the amount of the nodes, edges and changes in the graph.
//This class contains 2 inner classes that represents the implementations of edge and node on the graph.
//This class contains methods of getting a collection of all the neighbours of a node, getting all the nodes
//in the graph, getting node' adding and removing node, connecting between two nodes
public class WGraph_DS implements weighted_graph {
    private HashMap<Integer, node_info> nodes; //HashMap of all the nodes in the graph
    private node_IF nd;
    private int edgeCount,mcCount = 0;    //Count of edges and changes in the graph
    private edge edge1;
    public WGraph_DS (){
       nodes =new HashMap<Integer, node_info>();
       nd = new node_IF();
       edgeCount = 0;
       mcCount = 0;
       edge1 = new edge();
    }

    public class node_IF implements node_info{
         private int key;
         private String info;
         private double tag;
         private HashMap<Integer, node_info> neighbours; //HashMap of all the neighbours of the node

        public node_IF() {
             key = 0;
             info = null;
             tag = 0;
             neighbours = new HashMap<Integer, node_info>();
        }

        public Collection<node_info>  getNi(){return neighbours.values();} //Returning a collection of the neighbours of the graph

         public node_IF(node_IF other){ //Copy constructor
             this.key = other.key;
             this.info = other.info;
             this.tag = other.tag;
             this.neighbours= other.neighbours;
         }
         @Override
         public int getKey() {
             return key;
         } //Return the key of the node

         @Override
         public String getInfo() {
             return info;
         } //Return the info of the node

         @Override
         public void setInfo(String s) { info = s; } //Set the info of the node

         @Override
         public double getTag() {
             return tag;
         } //Return the tag of the node

         @Override
         public void setTag(double t) { tag = t; } //Set the tag of the node
    }

    public class edge{ //Class of an edge in the graph
        private double weight;
        private int src, dst;

        public edge() {
            weight = 0;
            src = 0;
            dst = 0;
        }
        public edge(int src, int dst, double weight){ //Constructor
            this.src = src;
            this.dst = dst;
            this.weight = weight;
        }
        public edge(edge other) { //Copy constructor
            this.weight = other.weight;
            this.src = other.dst;
            this.src = other.dst;
        }

        public double getWeight(int src, int dst){return weight;} //Return the weight of the edge
    }



    public WGraph_DS(WGraph_DS other){ //Copy constructor
        this.nodes = other.nodes;
        this.edgeCount = other.edgeCount;
        this.mcCount = other.mcCount;
        this.nd = new node_IF(other.nd);
        this.edge1 = new edge(other.edge1);
    }

    public HashMap<Integer, node_info> getNodes(){return nodes;} //Return an hashmap of all the nodes in the graph

    @Override
    public node_info getNode(int key) {
        return nodes.get(key);
    } //Returns a node by its key

    @Override
    public boolean hasEdge(int node1, int node2) { //Returns true if there is an ege between two nodes by their keys
        if(((node_IF)(nodes.get(node1))).getNi().contains(node2)&&(((node_IF)(nodes.get(node2))).getNi().contains(node1)))
            return true;
        return false;
    }

    @Override
    public double getEdge(int node1, int node2) { //Returns the edge between two nodes by their keys
       if(hasEdge(node1,node2))
           return edge1.getWeight(node1, node2);
       return -1;
    }

    @Override
    public void addNode(int key) { //Adds a node to the graph
       nodes.put(key, nodes.get(key));
       mcCount++;
   }

    @Override
    public void connect(int node1, int node2, double w) {  //Connects an edge between 2 nodes by their keys
        edge1 = new edge(node1, node2, w);
        edgeCount++;
   }

    @Override
    public Collection<node_info> getV() {
        return nodes.values();
    } //Returns collection of all the nodes in the graph

    @Override
    public Collection<node_info> getV(int node_id) { //Returns a collection of all the neighbours of a node by its key
        return ((node_IF)(nodes.get(node_id))).getNi();
    }

    @Override
    public node_info removeNode(int key) { //Removes a node (and its edges) from the graph by its key
        for(node_info n : getV(key)) //For each of all the nodes in the graph
            removeEdge(n.getKey(), key);
            edgeCount--;
            mcCount++;
        nodes.remove(key);
        mcCount++;
        return nodes.get(key);
    }

    @Override
    public void removeEdge(int node1, int node2) {  //Removes an edge between two nodes by their keys
        ((node_IF)(nodes.get(node1))).getNi().remove(node2);
        ((node_IF)(nodes.get(node2))).getNi().remove(node1);
        edgeCount--;
        mcCount++;
    }

    @Override
    public int nodeSize() {
        return nodes.size();
    } //Returns the amount of nodes in the graph

    @Override
    public int edgeSize() {
        return edgeCount;
    } //Return the amount of edges in the graph

    @Override
    public int getMC() {
        return mcCount;
    } //Return the amount of changes in the graph
}
