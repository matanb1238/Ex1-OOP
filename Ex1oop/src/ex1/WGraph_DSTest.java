package ex1;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class WGraph_DSTest {

    @Test
    void getNodes(){

    }
    @Test
    void getNode() {
        weighted_graph gr = new WGraph_DS();
        gr.addNode(1);
        gr.addNode(2);
        node_info nd = gr.getNode(3);
        assertEquals(null,nd);
    }

    @Test
    void hasEdge() {
        weighted_graph gr = new WGraph_DS();
        gr.addNode(1);
        gr.addNode(2);
        gr.addNode(3);
        gr.connect(1,2, 3);
        boolean bool1 = gr.hasEdge(1,2);
        boolean bool2 = gr.hasEdge(1,3);
        assertEquals(true, bool1);
        assertEquals(false, bool1);
    }

    @Test
    void getEdge() {
        weighted_graph gr = new WGraph_DS();
        gr.addNode(1);
        gr.addNode(2);
        gr.connect(1,2,3);
        double weight = gr.getEdge(1,2);
        assertEquals(weight,3);
    }

    @Test
    void addNode() {
        weighted_graph gr = new WGraph_DS();
        gr.addNode(1);
        int nodeSize = gr.nodeSize();
        assertEquals(nodeSize, 1);
    }

    @Test
    void connect() {
        weighted_graph gr = new WGraph_DS();
        gr.addNode(1);
        gr.addNode(5);
        gr.addNode(10);
        gr.connect(1, 5, 10);
        assertTrue(gr.hasEdge(1, 5));
        assertFalse(gr.hasEdge(5, 10));
    }

    @Test
    void getV() {
        weighted_graph gr = new WGraph_DS();
        gr.addNode(1);
        gr.addNode(2);
        gr.addNode(3);
        gr.addNode(4);
        gr.connect(1, 2, 3);
        gr.connect(2, 3, 5);
        gr.connect(3, 4, 9);
        gr.connect(4, 1, 8);
        Collection<node_info> nodes = gr.getV();
        assertEquals(nodes.size(), 4);
    }
    @Test
    void testGetV() {
        weighted_graph gr = new WGraph_DS();
        gr.addNode(1);
        gr.addNode(2);
        gr.addNode(3);
        gr.addNode(4);
        gr.connect(1, 2, 3);
        gr.connect(1, 3, 5);
        gr.connect(1, 4, 9);
        Collection<node_info> nei = gr.getV(1);
        assertEquals(nei.size(), 3);
    }

    @Test
    void removeNode() {
        weighted_graph gr = new WGraph_DS();
        gr.addNode(1);
        gr.removeNode(1);
        assertEquals(gr.nodeSize(), 0);
    }

    @Test
    void removeEdge() {
        weighted_graph gr = new WGraph_DS();
        gr.addNode(1);
        gr.addNode(2);
        gr.connect(1,2,3);
        gr.removeEdge(1,2);
        assertEquals(gr.edgeSize(), 0);
    }

    @Test
    void nodeSize() {
        weighted_graph gr = new WGraph_DS();
        gr.addNode(1);
        gr.addNode(2);
        assertEquals(gr.nodeSize(), 2);
    }

    @Test
    void edgeSize() {
        weighted_graph gr = new WGraph_DS();
        gr.addNode(1);
        gr.addNode(2);
        gr.connect(1,2,1);
        assertEquals(gr.edgeSize(), 1);
    }

    @Test
    void getMC() {
        weighted_graph gr = new WGraph_DS();
        gr.addNode(2);
        gr.addNode(3);
        gr.removeNode(2);
        gr.connect(1,3,4);
        int mc = gr.getMC();
        assertEquals(gr.getMC(),4);
    }
}