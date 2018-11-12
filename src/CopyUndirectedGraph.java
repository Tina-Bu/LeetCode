import java.util.*;

class nNode {
	// no need to store node value
	List<nNode> neighbors;
	// constructor
	nNode() {
		this.neighbors = new ArrayList<>();
	}
}

class CopyUndirectedGraphSolution {
	
	// First build the original graph from input array
	public nNode buildGraph(int[][] relationship) {
		// create empty array of nNodes
		nNode[] nodes = new nNode[relationship.length];
		// loop through the input array, create all nodes, and save to the node list
		for (int i = 0; i < relationship.length; i++) {
			nodes[i] = new nNode();
		}
		// loop through the input array and create all the edges
		for (int i = 0; i < relationship.length; i++) {
			for (int neighbor: relationship[i]) {
				nodes[i].neighbors.add(nodes[neighbor]);
			}
		}
		return nodes[0];
	}
	
	// Second clone the graph
	public nNode cloneGraph(nNode node) {
		// Essentially, we want a hashmap of old node -> new cloned node
		// map needs to be passed constantly, so create new private function
		HashMap<nNode, nNode> hashmap = new HashMap<>();
		return cloneGraph(node, hashmap);
	}
	
	// 
	public nNode cloneGraph(nNode node, HashMap<nNode, nNode> hashmap) {
		// if already cloned (key exists in hashmap)
		if (hashmap.containsKey(node)) {
			// return the cloned node
			return hashmap.get(node);
		}
		// else, first clone the node, add to hashmap
		nNode clone = new nNode();
		hashmap.put(node, clone);
		// then construct all the neighbors for the cloned node
		// but need to make sure the nodes in those relationships are created
		for (nNode neighbor: node.neighbors) {
			clone.neighbors.add(cloneGraph(neighbor, hashmap));
		}
		return clone;
	}
}
/*
 * Modification
 * 
 * Clone a directed graph
 * 	input: {{1, 2} {}, {2}}
 * 	code doesn't need to change
 * 
 * Clone a tree
 * 	doesn't need to change, solution is general enough
 */


/*
 * Search Model 遍历模型
 * 1. What is the node
 * 2. What is the edge
 * 3. Greedy priority 贪心策略
 * 		DFS (当前节点边的顺利), BFS (访问到节点的顺序), A* (当前最优选择)
 * 
 * 
 */

public class CopyUndirectedGraph {
	public static void main(String[] args) {
		int[][] relationship = {{1, 2}, {0}, {0, 2}};
		// means node 0 is connected with 1, 2, node 1 is connected with 0, node 2 is connected with 0 and 2
		CopyUndirectedGraphSolution s = new CopyUndirectedGraphSolution();
		nNode n = s.buildGraph(relationship);
		nNode n2 = s.cloneGraph(n);
		System.out.println(n2);
	}
}
