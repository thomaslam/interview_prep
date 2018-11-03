/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
    1
   / \
  2   2
 / \ / \
3  4 4  3
 *
 */


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class SymmetricTree {
  public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    return isSymmetricHelper(root.left, root.right);
  }
  
  public boolean isSymmetricHelper(TreeNode node1, TreeNode node2) {
    if (node1 == null && node2 == null) return true;
    if (node1 == null || node2 == null) return false;
    
    return node1.val == node2.val
            && isSymmetricHelper(node1.left, node2.right)
            && isSymmetricHelper(node1.right, node2.left);
  }
}