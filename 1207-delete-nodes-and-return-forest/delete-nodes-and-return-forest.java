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
    public static HashSet<Integer> set;
    public static List<TreeNode> ans;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        set=new HashSet<>();
        for(int val:to_delete){
            set.add(val);
        }
        ans=new ArrayList<>();
        root=sol(root);
        if(root!=null) ans.add(root);
        return ans;

    }
    public TreeNode sol(TreeNode root){
        if(root==null) return null;
       
        root.left=sol(root.left);
        root.right=sol(root.right);
        if(set.contains(root.val)){
            if(root.left!=null)ans.add(root.left);
            if(root.right!=null)ans.add(root.right);
            return null;
        }
        return root;
    }
}