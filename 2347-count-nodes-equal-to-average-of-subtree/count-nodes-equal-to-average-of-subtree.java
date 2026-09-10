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
    int ans;
    public int averageOfSubtree(TreeNode root) {
        ans=0;
        sol(root);
        return ans;

    }
    public int[] sol(TreeNode root){
        if(root==null){
            return new int[]{0,0};//{count,sum}
        }

        int[] left=sol(root.left);
        int[] right=sol(root.right);
        
        int count=left[0]+right[0]+1;
        int sum=left[1]+right[1]+root.val;
        int avg=sum/count;
        if(avg==root.val) ans++;

        return new int[] {count,sum};

    }
}