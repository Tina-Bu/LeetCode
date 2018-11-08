import java.util.*;

class PreorderTraversalSolution1 {
	
	// first build a tree from the array
	public TreeNode buildTree(int[] nums, int pos) {
		if (pos >= nums.length || nums[pos] == -1) {
			return null;
		}
		TreeNode root = new TreeNode(nums[pos]);
		root.left = buildTree(nums, pos * 2 + 1);
		root.right = buildTree(nums, pos * 2 + 2);
		return root;
	}
	
	// traverse with recursion
	public void preorderTraverse(TreeNode n, List<Integer> result) {
		if (n == null) {
			return;
		} else {
			result.add(n.val);
			preorderTraverse(n.left, result);
			preorderTraverse(n.right, result);
		}
	}
}

class PreorderTraversalSolution2 {
	// 任务列表，有两种任务，访问和打印。新任务要插入到头部，所以用栈解决。
	public List<Integer> preorderTraverse(TreeNode root) {
		// visit(1) => output(1) -> visit(2) -> visit(3)
		// create a stack that saves the tasks
		Stack<Element> stack = new Stack<>(); 
		List<Integer> result = new ArrayList<>();
		
		stack.push(new Element(0, root));
		
		while (!stack.isEmpty()) {
			Element curr = stack.pop();
			
			if(curr.node == null) {
				continue;
			}
			
			if (curr.type == 1) {
				result.add(curr.node.val);
			} else {
				// add 3 elements to the stack: output self, visit left, visit right
				stack.push(new Element(0, curr.node.right));
				stack.push(new Element(0, curr.node.left));
				stack.push(new Element(1, curr.node));
			}
		}
		return result;
	}
	
	private class Element {
		int type; // 0: visit; 1: output
		TreeNode node;
		Element(int type, TreeNode node) {
			this.type = type;
			this.node = node;
		}
	}
}

/*
 * Modification
 * Inorder：visit left -> print current -> visit right
 * Postorder traversal: visit left -> visit right -> print current
 * 
 */
public class PreorderTraversal {
	// 先根遍历 node -> node.left -> node.right
	
	public static void main(String[] args) {
		int[] nums = new int[] {1, 2, 3, -1, 4, 5, 6};
		
		// recursion solution: function call 
		PreorderTraversalSolution1 s1 = new PreorderTraversalSolution1();
		TreeNode root = s1.buildTree(nums, 0);
		List<Integer> result = new ArrayList<>();
		s1.preorderTraverse(root, result);
		
		// 记录状态栈 event list
		PreorderTraversalSolution2 s2 = new PreorderTraversalSolution2();
		System.out.println(s2.preorderTraverse(root));
	}
}
