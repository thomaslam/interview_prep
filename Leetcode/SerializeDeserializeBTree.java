/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) { return ""; }
        StringBuilder sb = new StringBuilder();
        
        Queue q = new LinkedList();
        q.add(root);
        
        String prefix = "";
        while(!q.isEmpty()) {
            TreeNode n = (TreeNode) q.poll();
            sb.append(prefix);
            prefix = ",";
            
            if (n.val != Integer.MAX_VALUE) {
                sb.append(n.val);

                if (n.left == null) {
                    TreeNode leftNode = new TreeNode(Integer.MAX_VALUE);
                    q.add(leftNode);
                } else {
                    q.add(n.left);
                }

                if (n.right == null) {
                    TreeNode rightNode = new TreeNode(Integer.MAX_VALUE);
                    q.add(rightNode);
                } else {
                    q.add(n.right);
                }
            } else {
                sb.append("null");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) { return null; }
        String[] vals = data.split(",");
        TreeNode[] arr = new TreeNode[vals.length];
        for (int i = 0; i < vals.length; i++) {
            //System.out.print(vals[i]);
            if (vals[i].equals("null")) {
                arr[i] = new TreeNode(Integer.MAX_VALUE);
            } else {
                arr[i] = new TreeNode(Integer.parseInt(vals[i]));
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            TreeNode curr = arr[i];
            int leftIdx = 2*i + 1;
            int rightIdx = 2*i + 2;
            
            if (leftIdx < arr.length && arr[leftIdx].val != Integer.MAX_VALUE) {
                curr.left = arr[leftIdx];
            }
            if (rightIdx < arr.length && arr[rightIdx].val != Integer.MAX_VALUE) {
                curr.right = arr[rightIdx];
            }
        }
        return arr[0];
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));