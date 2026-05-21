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
    //public static int ans;
    public HashMap<TreeNode,Integer> map; 
    public HashMap<TreeNode,Boolean> is_Bst;


    public int maxSumBST(TreeNode root) {
        if(root==null) return 0;
        map = new HashMap<>();
        is_Bst=new HashMap<>();
        sol(root);
        isBst(root);
        int ans=0;

        for(TreeNode node : is_Bst.keySet()){

            if(is_Bst.get(node)){
                ans = Math.max(ans, map.get(node));
            }
        }
        return ans;
        
    }
    public int find_Max(TreeNode root){
        if(root == null) return Integer.MIN_VALUE;
        while(root.right!=null){
            root=root.right;
        }
        return root.val;
    }
    public int find_Min(TreeNode root){
        if(root == null) return Integer.MAX_VALUE;
        while(root.left!=null){
            root=root.left;
        }
        return root.val;
    }
    public boolean isBst(TreeNode root) {

        if (root == null) return true;
        boolean left=isBst(root.left) ;
        boolean right=isBst(root.right);

        // if (root.val <=root.left.val|| root.val >= root.right.val ) {
        //     return false;
        // }
        int leftMax = find_Max(root.left);
        int rightMin = find_Min(root.right);
        boolean curr=left && right && root.val > leftMax && root.val < rightMin ;
        is_Bst.put(root, curr);

        return curr;
    }
    public int sol(TreeNode root){
        if(root==null) return 0;
        int left=sol(root.left);
        int right=sol(root.right);
        int val=left+right+root.val;
        map.put(root,val);
        return val;
    }
}


/*

                class Solution {
                    public static int ans;
                    public int maxSumBST(TreeNode root) {
                        if(root==null) return 0;
                        ans=0;
                        findBst(root);
                        return ans;
                        
                    }
                    public void findBst(TreeNode root){
                        if(root==null) return;
                        if(isBst(root,Long.MIN_VALUE,Long.MAX_VALUE)){
                            ans=Math.max(ans,sol(root));
                        }
                        findBst(root.left);
                        findBst(root.right);
                    }
                    public boolean isBst(TreeNode root, long min, long max) {

                        if (root == null) return true;

                        if (root.val <= min || root.val >= max) {
                            return false;
                        }

                        return isBst(root.left, min, root.val) &&
                            isBst(root.right, root.val, max);
                    }
                    public int sol(TreeNode root){
                        if(root==null) return 0;
                        int left=sol(root.left);
                        int right=sol(root.right);

                        return left+right+root.val;
                    }
                }


*/



