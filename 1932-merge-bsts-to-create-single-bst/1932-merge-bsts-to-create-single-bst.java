/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private boolean dfs(TreeNode node, long min, long max, Map<Integer, TreeNode> map) {

        if (node == null)
            return true;

        // BST validation
        if (node.val <= min || node.val >= max)
            return false;

        // Merge if current node is a leaf and another tree starts here
        if (node.left == null && node.right == null &&
            map.containsKey(node.val)) {

            TreeNode merge = map.remove(node.val);

            node.left = merge.left;
            node.right = merge.right;
        }

        return dfs(node.left, min, node.val, map) &&
               dfs(node.right, node.val, max, map);
    }

    public TreeNode canMerge(List<TreeNode> trees) {
        // root value -> tree
        Map<Integer, TreeNode> map = new HashMap<>();

        // store all leaf values
        Set<Integer> leaves = new HashSet<>();

        for (TreeNode root : trees) {
            map.put(root.val, root);

            if (root.left != null)
                leaves.add(root.left.val);

            if (root.right != null)
                leaves.add(root.right.val);
        }

        // Find the root which is not present as a leaf
        TreeNode root = null;

        for (TreeNode node : trees) {
            if (!leaves.contains(node.val)) {
                if (root != null)
                    return null;      // More than one possible root

                root = node;
            }
        }

        if (root == null)
            return null;

        // Remove starting root
        map.remove(root.val);

        // Merge and validate BST
        if (!dfs(root, Long.MIN_VALUE, Long.MAX_VALUE, map))
            return null;

        // Every tree must be merged
        if (!map.isEmpty())
            return null;

        return root;
    }
}