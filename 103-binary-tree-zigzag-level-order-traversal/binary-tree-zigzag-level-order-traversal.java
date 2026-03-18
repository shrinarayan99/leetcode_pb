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
    public static List<List<Integer>> ans;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ans=new ArrayList<>();
         if (root == null) return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean flag=false;
        while(!q.isEmpty()){
            int s=q.size();
            LinkedList<Integer> list=new LinkedList<>();
            for(int i=0;i<s;i++){
                TreeNode node=q.poll();
                int val=node.val;
                if(flag){
                    list.addFirst(val);
                }
                else{
                    list.addLast(val);
                }
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            ans.add(list);
            flag=!flag;
        }
        return ans;
    }
    
}