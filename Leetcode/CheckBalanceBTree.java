public class CheckBalanceBTree {
	public boolean isBalanced(TreeNode root) {
		if (root == null) {return true;}
		return Math.abs(height(root.left) - height(root.right) <= 1) && isBalanced(root.left) && isBalanced(root.right);
	}

	public int height(TreeNode n) {
		if (n == null) {return 0;}
		return 1 + Math.max(height(n.left), height(n.right));
	}
}