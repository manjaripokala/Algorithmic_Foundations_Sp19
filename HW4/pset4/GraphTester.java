package pset4;
import static org.junit.Assert.*;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

/**
 * @author manjaripokala
 *
 */

public class GraphTester {
    // tests for method "addEdge" in class "Graph"
    @Test public void tae0() {
        Graph g = new Graph();
        g.addNode(0); 
        g.addNode(1);
        g.addEdge(0, 1);
        assertEquals(g.toString(), "nodes: [0, 1]\nedges: {0=[1]}");
    }
    // your tests for method "addEdge" in class "Graph" go here
    // you must provide at least 4 test methods;
    // each test method must have at least 1 invocation of addEdge;
    // each test method must have at least 1 test assertion;
    // your test methods must provide full statement coverage of your
    //   implementation of addEdge and any helper methods
    // no test method directly invokes any method that is not
    //   declared in the Graph class as given in this homework
    
    @Test(expected = IllegalArgumentException.class) 
    // when both "from" & "to" nodes are not present in nodes
    public void tae1() {
        Graph g = new Graph();
        g.addEdge(0, 1);
        assertEquals(g.toString(), "nodes: [0, 1]\nedges: {0=[1]}");
    }
    
    @Test public void tae2() {
    	// test for edges a -> b & b -> a
        Graph g = new Graph();
        g.addNode(19); g.addNode(20);
        g.addEdge(19, 20);
        g.addEdge(20, 19);
        assertEquals(g.toString(), "nodes: [19, 20]\nedges: {19=[20], 20=[19]}");
    }
    
    @Test public void tae3() {
    	// test for a node having more than 1 edge
        Graph g = new Graph();
        g.addNode(9); g.addNode(4); g.addNode(5);
        g.addEdge(9, 4);
        g.addEdge(9,5);
        assertEquals(g.toString(), "nodes: [4, 5, 9]\nedges: {9=[4, 5]}");
    }
    
    @Test public void tae4() {
    	// test for a self loop and nodes with multiple edges
        Graph g = new Graph();
        for(int i = 0; i<5; i++){
        	g.addNode(i);
        }
        g.addEdge(4,3);
        g.addEdge(4, 1);
        g.addEdge(2, 4);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(4, 4);
        assertEquals(g.toString(), "nodes: [0, 1, 2, 3, 4]\nedges: {1=[2], 2=[4, 3], 4=[3, 1, 4]}");
    }
    
    
    
    // tests for method "unreachable" in class "Graph"
    @Test public void tr0() {
        Graph g = new Graph();
        g.addNode(0);
        Set<Integer> nodes = new HashSet<Integer>();
        nodes.add(0);
        assertTrue(g.unreachable(new HashSet<Integer>(), nodes));
    }
    // your tests for method "unreachable" in class "Graph" go here
    // you must provide at least 6 test methods;
    // each test method must have at least 1 invocation of unreachable;
    // each test method must have at least 1 test assertion;
    // at least 2 test methods must have at least 1 invocation of addEdge;
    // your test methods must provide full statement coverage of your
    //   implementation of unreachable and any helper methods
    // no test method directly invokes any method that is not
    //   declared in the Graph class as given in this homework
    
    @Test (expected = IllegalArgumentException.class)  
    public void tr1() {
    	// test if either source or target is not subset of "nodes"
        Graph g = new Graph();
        Set<Integer> targets = new HashSet<Integer>();
        targets.add(0);
        assertTrue(g.unreachable(g.nodes(), targets));
    }
    
    @Test public void tr2() {
    	// test for if a node reachable from itself or not - so unreachable returns false
        Graph g = new Graph();
        g.addNode(0); g.addNode(1);
        Set<Integer> targets = new HashSet<Integer>();
        targets.add(0);
        // Since every vertex is reachable from itself, as there is always a ‘0’ length path from a vertex to
        //itself.
        assertFalse(g.unreachable(g.nodes(), targets));
    }
   
    @Test public void tr3() {
    	// test for if a node 'n' from sources that has an edge to node 'm' in targets
    	// there is an edge from 0 to 4 so unreachable returns false
        Graph g = new Graph();
        g.addNode(0); g.addNode(4);
        g.addEdge(0, 4); 
        Set<Integer> sources = new HashSet<Integer>();
        sources.add(0);
        Set<Integer> targets = new HashSet<Integer>();
        targets.add(4);
        assertFalse(g.unreachable(g.nodes(), targets));
    }
    
    @Test public void tr4() {
    	// test for if there exists a directed path that starts at node 'n' from sources
    	//and ends at node 'm' in targets
    	// there is a path from 0 to 9 so unreachable returns false
        Graph g = new Graph();
        g.addNode(0); g.addNode(1); g.addNode(3); g.addNode(4); g.addNode(9);
        g.addNode(10);
        g.addEdge(0, 1); g.addEdge(1, 3); g.addEdge(3, 4); g.addEdge(1, 0); 
        g.addEdge(4, 9); 
        Set<Integer> sources = new HashSet<Integer>();
        sources.add(0); sources.add(10);
        Set<Integer> targets = new HashSet<Integer>();
        targets.add(9);
        assertFalse(g.unreachable(sources, targets));
    }
    
    @Test public void tr5() {
    	//Input Graph: Every node connected to next node(value in sorted order) except last node
    	//             Last node doesn't have any edges coming to it
    	// First node = 0 and last node = 99 
    	// Test for if 99 is reachable from 0 - unreachable returns true
        Graph g = new Graph();
        for (int i = 0; i<100; i++){
        	g.addNode(i);
        	if(i > 0 && i < 98){
        		g.addEdge(i-1, i);
        	}
        }
       
        Set<Integer> sources = new HashSet<Integer>();
        sources.add(0); 
        Set<Integer> targets = new HashSet<Integer>();
        targets.add(99);
        assertTrue(g.unreachable(sources, targets));
    }
    
    @Test public void tr6() {
    	//Input Graph: Every Even node is connected to next even node(value in sorted order) 0 -> 2 -> 4 -> ......
    	//             Every Odd node is connected to next odd node(value in sorted order) 1 -> 3 -> 5 -> ......
    	//Test for if odd node is reachable from even - unreachable returns true
        Graph g = new Graph();
        for (int i = 0; i<100; i++){
        	g.addNode(i);
        	if (i > 1 && i < 100) {
        		g.addEdge(i-2, i);
        	}
        }
        // if 'i' is even add to sources else add to targets
        Set<Integer> sources = new HashSet<Integer>();
        Set<Integer> targets = new HashSet<Integer>();
        for(int i =0; i<100; i++) {
        	if (i%2 == 0)
        		sources.add(i);
        	else
        		targets.add(i);
        }
        assertTrue(g.unreachable(sources, targets));
    }
    
    
}