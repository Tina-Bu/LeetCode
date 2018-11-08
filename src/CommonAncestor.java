/*
 * First construct a node class
 */
class Node {
	public int value;
	public Node left;
	public Node right;
	
	public Node(int value) {
		this.value = value;
	}
}

class CommonAncestorSolution {
	// Find common ancestor for 2 nodes in a binary tree
	
	public Node buildTree(int[] nums, int pos) {
		// first from given array, construct binary tree and return root node
		// Binary tree -> leftIndex = selfIndex * 2 + 1
		
		// corner case
		if (pos >= nums.length || nums[pos] == -1) {
			return null;
		}
		
		Node node = new Node(nums[pos]);
		// recursion building tree
		node.left = buildTree(nums, pos * 2 + 1);
		node.right = buildTree(nums, pos * 2 + 2);
		return node;
	}
	
	public int findAncestor(Node root, int value1, int value2) {
		// Use DFS
		// (self, left, right) if 1 matches 2 target values, return the matched value
		// if 2 match both of the target values, return self
		
		// corner case: no match
		if (root == null) {
			return -1;
		}

		// if current root matches 1 target value, return its value
		if (root.value == value1 || root.value == value2) {
			return root.value;
		}
		
		// if current root didn't match any target value, go check its children
		// using DFS 
		int leftValue = findAncestor(root.left, value1, value2);
		int rightValue = findAncestor(root.right, value1, value2);
		
		// if leftValue and rightValue are both -1, return -1
		// if one of them is -1, return the positive one (same as left + right + 1) 
		// if both of them are not -1, then a common ancestor is found and the current root value is returned
		if (leftValue == -1 && rightValue == -1) {
			return -1;
		} else if (leftValue == -1 || rightValue == -1) {
			return leftValue + rightValue + 1;
		} else {
			return root.value;
		}
	}
}

/*
 * Modification
 * 
 * find common ancestor for k nodes
 * user pair (count, value) everytime a value if found, +1, the node with count k is the common ancestor
 */

public class CommonAncestor {
	public static void main (String[] args) {
		CommonAncestorSolution s = new CommonAncestorSolution();
		Node root = s.buildTree(new int[] {1, 2, 3, -1, 4, 5, 6}, 0);
		System.out.println(root.value);
		System.out.println(s.findAncestor(root, 5, 6));
		
	}
}
