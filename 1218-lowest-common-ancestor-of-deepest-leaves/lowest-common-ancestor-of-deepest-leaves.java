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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root==null) return null;
        List<TreeNode> deepest=new ArrayList<>();

        Queue<TreeNode> qu=new LinkedList<>();
        qu.add(root);
        
        while(!qu.isEmpty()){
            int size=qu.size();
            deepest=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr=qu.poll();
                deepest.add(curr);
                TreeNode left=curr.left;
                if(left!=null){
                    qu.add(left);
                    
                } 
                TreeNode right=curr.right;
                if(right!=null){
                    qu.add(right);
                } 
            }
        }
        TreeNode ans=deepest.get(0);
        for(int i=1;i<deepest.size();i++){
            ans=CommonAncestor(root,ans,deepest.get(i));
        }
        return ans;
    }
     public TreeNode CommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
                if(root==p || root==q) return root;
                if(root==null) return root;
                TreeNode left=CommonAncestor(root.left,p,q);
                TreeNode right=CommonAncestor(root.right,p,q);

                if(left!=null && right==null) return left;
                else if(left==null && right!=null) return right;
                if(left!=null && right!=null) return root;
                return null;
            }
}