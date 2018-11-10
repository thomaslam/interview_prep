public class Successor {
	public TreeNode successor(TreeNode n) {
		if (n.right != null) {
			return leftMostChild(n.right);
		} else {
			TreeNode curr = n;
			TreeNode parent = curr.parent;
			if (parent != null && parent.left != curr) {
				curr = parent;
				parent = curr.parent;
			}
			return parent;
		}
	}

	public TreeNode leftMostChild(TreeNode n) {
		if (n == null) { return null; }
		while (n.left != null) {
			n = n.left;
		}
		return n;
	}
}