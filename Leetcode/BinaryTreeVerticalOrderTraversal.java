/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) { return new ArrayList<>(); }
        List<List<Integer>> lists = new ArrayList<>();
        Map<Integer, List> map = new HashMap<>();
        
        int min = 0;
        int max = 0;
        
        Queue<Integer> cols = new LinkedList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        cols.add(0);
        nodes.add(root);
        
        while(!nodes.isEmpty()) {
            TreeNode n = nodes.poll();
            int col = cols.poll();
            
            List<Integer> list = map.getOrDefault(col, new ArrayList<Integer>());
            list.add(n.val);
            map.put(col, list);
            
            if (n.left != null) {
                nodes.add(n.left);
                cols.add(col - 1);
                if (col - 1 < min) {
                    min = col - 1;
                }
            }
            
            if (n.right != null) {
                nodes.add(n.right);
                cols.add(col + 1);
                if (col + 1 > max) {
                    max = col + 1;
                }
            }
        }
        
        for (int i = min; i <= max; i++) {
            lists.add(map.get(i));
        }
        
        return lists;
    }
}