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
    public static int total_ans;
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        total_ans=0;
        sol(root,new StringBuilder());
        return total_ans;
    }
    public void sol(TreeNode root,StringBuilder sb){
        if(root==null) return;
        sb.append(root.val);
        if(root.left==null && root.right==null){
            total_ans+=Integer.valueOf(sb.toString());
            
        }
        else{
            sol(root.left,sb);
            sol(root.right,sb);
        }
        
        
        /* StringBuilder is just like arrayList(left or right recursion ke liye alg alg nhi honge to backtrack krna pdta hai)

        Because they are MUTABLE (same object is shared across recursion calls)

        // flow(if do not back track)
         
        sb = ""
        → "1"
        → "12"   (left)
        → back to root → still "12"
        → "123"  (right) ❌ WRONG

        */
        sb.deleteCharAt(sb.length()-1);
    }

    /* For without backtraking

    public void sol(TreeNode root,StringBuilder sb){
        if(root==null) return;
        sb.append(root.val);
        StringBuilder sb_left = new StringBuilder(sb);
        StringBuilder sb_right = new StringBuilder(sb);
        if(root.left==null && root.right==null){
            total_ans+=Integer.valueOf(sb.toString());
            
        }
        else{
            sol(root.left,sb_left);
            sol(root.right,sb_right);
        }
                
    }

    */
}