/**
 * 
 */
package pset4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author manjaripokala
 *
 */

enum Color {
    WHITE, GRAY, BLACK
}

public class Graph {
	
	public static final int INFINITY = Integer.MAX_VALUE;
    
    private Set<Integer> nodes; // set of nodes in the graph
    private Map<Integer, List<Integer>> edges;
    // map between a node and a list of nodes that are connected to it by outgoing edges
    // class invariant: fields "nodes" and "edges" are non-null;
    //                  "this" graph has no node that is not in "nodes"
    public Graph() {
        nodes = new HashSet<Integer>();
        edges = new HashMap<Integer, List<Integer>>();
    }
    public String toString() {
        //return "nodes=" + nodes + "; " + "edges=" + edges;
    	return "nodes: " + nodes + "\nedges: " + edges;
    }
    public void addNode(int n) {
        // postcondition: adds the node "n" to this graph
        nodes.add(n);
    }
    
    public void addEdge(int from, int to) {
        // postcondition: adds a directed edge "from" -> "to" to this graph
        // your code goes here
        // ...
    	// if nodes are not present in graph structure then throws an exception
    	if (!this.nodes.contains(from) || !this.nodes.contains(to)) {
    		throw new IllegalArgumentException("node is not part of graph");
    	}
    	
    	// if key comes for the first time then it first creates key pointing to empty list
    	if (!this.edges.containsKey(from))
    	{
    		this.edges.put(from, new ArrayList<Integer>());
    	}
    	this.edges.get(from).add(to);
    }
    
    public Set<Integer> nodes() {
        return nodes;
    }
    
    public boolean unreachable(Set<Integer> sources, Set<Integer> targets) {
    	if (sources == null || targets == null) throw new IllegalArgumentException();
    	// postcondition: returns true if (1) "sources" is a subset of "nodes", (2) "targets" is
//    	                           a subset of "nodes", and (3) for each node "m" in set "targets",
//    	                           there is no node "n" in set "sources" such that there is a
//    	                           directed path that starts at "n" and ends at "m" in "this"; and
//    	                           false otherwise
    	// your code goes here
    	// ...
    	
    	// if sources or targets are not subset of nodes, then throws an exception
    	if (!nodes.containsAll(sources) || !nodes.containsAll(targets)) {
    		throw new IllegalArgumentException("not a subset of nodes");
    	}
    		
    	// for each node in source call BFS and check for distance of each node from source
    	// if node's distance = INFINITY then it is not reachable from source
    	for(int n:sources) {
    		Map<Integer, Integer> distance = breadthFirstSearch(n);
    		for(int m:targets) {
    			if (distance.get(m) != INFINITY)
    				return false;
    		}
    	}
   
    	return true;
    }
    
    //helper method for unreachable
    //Program referenced from lecture notes
    public Map<Integer, Integer> breadthFirstSearch(Integer source) {
    	// variables for BFS
    	Map<Integer, Color> color = new HashMap<>();
        Map<Integer, Integer> d = new HashMap<>();
        Map<Integer, Integer> p = new HashMap<>();
        Queue<Integer> Q = new LinkedList<>();
        
    	for (int u: nodes) {
    		color.put(u, Color.WHITE);
    		d.put(u, INFINITY);
    		p.put(u, null);
        }
    	
    	color.put(source, Color.GRAY);
    	d.put(source, 0);
    	p.put(source, null);
    	
    	Q.add(source);
    	while (!Q.isEmpty()) {
    		int u = Q.remove();
    		if (edges.containsKey(u)) {
    			for(Integer v:edges.get(u)){
    				if (color.get(v) == Color.WHITE) {
    					color.put(v, Color.GRAY);
    					d.put(v, (d.get(u) + 1));
    					p.put(v, u);
    					Q.add(v);
    				}
    			}
    		}
    		color.put(u, Color.BLACK);
    		
    	}
    	
    	return d;
    	
    }


}
