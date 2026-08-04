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
    
    int postIdx = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        postIdx = postorder.length - 1;

        return helper(postorder, 0, inorder.length-1);
    }

    public TreeNode helper(int[] postorder,int left, int right){

        if(left > right) return null;

        int val = postorder[postIdx--];
        TreeNode root = new TreeNode(val);

        int inIdx = map.get(val);

        root.right = helper(postorder, inIdx+1, right);
        root.left = helper(postorder, left, inIdx-1);

        return root;
        
    }
}