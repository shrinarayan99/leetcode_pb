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
    public HashMap<Integer,Integer> map;
    public int idx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
     
        map=new HashMap<>();
        for(int  i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
       return sol(preorder,inorder,0,preorder.length-1);

    }
    public TreeNode sol(int[] preorder, int[] inorder,int l,int r){
        if(r<l || idx>=preorder.length) return null;
        int val=preorder[idx++];
        TreeNode ans=new TreeNode(val);
        ans.left=sol(preorder,inorder,l,map.get(val)-1);
        ans.right=sol(preorder,inorder,map.get(val)+1,r);

        return ans;

    }
}