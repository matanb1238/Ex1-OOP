# Ex1-OOP
This project is an implemention of Undirectional Weighted Graph.  
We have 2 regular classes, and 2 test classes.  
The first class is WGraph_DS. 
This class is an implemention of the graph, and I will explain about its functions. 
getNodes() - Returns hashmap of all the nodes in the graph, getNode(int key) - Returns a node by its key. 
hasEdge(int node1, int node2) - Returns true if there is an ege between two nodes by their keys.  
getEdge(int node1, int node2) - Returns the edge between two nodes by their keys. 
addNode(int key) = Adds a node to the graph.  
connect(int node1, int node2, double w) - Connects an edge between 2 nodes by their keys. 
getV() - Returns collection of all the nodes in the graph.   
getV(int node_id) - Returns a collection of all the neighbours of a node by its key.  
removeNode(int key)- Removes a node (and its edges) from the graph by its key.  
removeEdge(int node1, int node2)- Removes an edge between two nodes by their keys.  
nodeSize() - Returns the amount of nodes in the graph.  
edgeSize() - Returns the amount of edges in the graph.  
getMC() - Returns the amount of changes in the graph. 
There are also 2 inner classes in this class - node_IF which present a node in the graph. and edge which present an edge (with weight) in the graph.    

The other class is WGraph_Algo, here is an explanation of its important functions:  
Init - Init the graph that the algorithms will be on. 
getGraph() - Returns the graph. 
Copy()- Deep copy of the graph. 
isConnected() - Checks if the graph is strongly related.  
shortestPathDist(int src, int dest) -  The algorithm finds the shortest path between two nodes - the shortest way is the way with the least amount of weight. 
List<node_info>shortestPathDist(int src, int dest) - Returns a list of the shortest path. 
save(String file) - Saves a graph to file.   
load(String file) - Loads a graph from a file. 
