
import java.util.*;

class BinaryTreeInorderTraversalSolution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode node = root;

        while(node != null || !stack.isEmpty()) {
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;
        }

        return result;

    }
}

class TreeNode {
	int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeInorderTraversal {
	// testing
	public static void main(String[] args) {
	}
}
