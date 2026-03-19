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
    public static int count;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        return sol(root,targetSum,0L)+pathSum(root.left,targetSum)+pathSum(root.right,targetSum);
       
    }
    public static int sol(TreeNode root, int targetSum,long total){
        if(root==null){
            return 0;
        }
        total+=root.val;
        int count=0;
        if(total==targetSum){
            count+=1;
        }
        count+=sol(root.left,targetSum,total);
        count+=sol(root.right,targetSum,total);
        return count;
        
    }
}