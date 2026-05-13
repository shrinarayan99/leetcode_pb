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
    ArrayList<Integer> list;
    public int getMinimumDifference(TreeNode root) {
        if(root==null) return 0;
        list=new ArrayList<>();
        sol(root);
        Collections.sort(list);
        int size=list.size();
        int dif=Integer.MAX_VALUE;
        for(int i=1;i<size;i++){
            dif=Math.min(dif,list.get(i)-list.get(i-1));
        }
        return dif;
    }
    public void sol(TreeNode root){
        if(root==null) return;
        list.add(root.val);
        sol(root.left);
        sol(root.right);
    }
}