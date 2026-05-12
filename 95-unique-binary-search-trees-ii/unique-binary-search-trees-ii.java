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
   
    public List<TreeNode> generateTrees(int n) {
        return sol(1,n);
    }
    public List<TreeNode> sol(int start ,int end){
        List<TreeNode> ans=new ArrayList<>();
        if(start>end){
            ans.add(null);
            return ans;
        }
        if(start==end){
            TreeNode root=new TreeNode(start);
            ans.add(root);
            return ans;
        }
         
        for(int i=start;i<=end;i++){
            List<TreeNode> left_BST=sol(start,i-1);
            List<TreeNode> right_BST=sol(i+1,end);

            for(TreeNode L:left_BST){
                for(TreeNode R:right_BST){
                    TreeNode root=new TreeNode(i);
                    root.right=R;
                    root.left=L;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}