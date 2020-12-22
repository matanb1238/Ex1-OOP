package ex1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WGraph_AlgoTest {
    WGraph_Algo gr = new WGraph_Algo();
    @Test
    void init() {
        WGraph_Algo g = new WGraph_Algo();
        gr.init(g.getGraph());
        assertEquals(g.getGraph(), gr.getGraph());

    }

    @Test
    void getGraph() {
        WGraph_Algo g = new WGraph_Algo();
        WGraph_DS graph = new WGraph_DS();
        g.init(graph);
        assertEquals(g.getGraph(), graph);
    }

    @Test
    void copy() {
        WGraph_Algo g = new WGraph_Algo();
        g.getGraph().addNode(1);
        weighted_graph graph = g.copy();
        assertEquals(graph, g.getGraph());
    }

    @Test
    void save() {
        String file = "test";
        gr.save(file);
        WGraph_Algo g = new WGraph_Algo();
        g.load(file);
        Assertions.assertEquals(g, gr);
    }

    @Test
    void load() {
        String file = "test";
        gr.save(file);
        WGraph_Algo g = new WGraph_Algo();
        g.load(file);
        Assertions.assertEquals(g, gr);
    }

    @Test
    void countDFS() {
        WGraph_Algo g = new WGraph_Algo();
        g.getGraph().addNode(1);
        g.getGraph().addNode(2);
        g.getGraph().connect(1,2,3);
        assertEquals(g.countDFS(1), 1);
    }

    //@Test
    //void dijkstra() {
    //    WGraph_Algo g = new WGraph_Algo();
    //g.getGraph().addNode(1);
    //    g.getGraph().addNode(2);
    //    g.getGraph().addNode(3);
    //    g.getGraph().addNode(4);
    //    g.getGraph().connect(1,4,3);
    //    g.getGraph().connect(1,2,1);
    //    g.getGraph().connect(2,3,2);
    //    g.getGraph().connect(3,4,1);
    //    List<node_info> path1 = new LinkedList<> ();
    //    path1.add((WGraph_DS) (g.getGraph()).getNodes().getKey(1));
    //    assertEquals(path1, dijkstra((g.getGraph()).getNodes().getKey(1)) , (g.getGraph()).getNodes().getKey(4));
    //}

    @Test
    void path() {

    }
}