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
    List<List<Integer>>list;
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        list=new ArrayList<>();
        if(root==null)return list;

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        //ArrayList has a constructor that accepts a Collection to copy its elements, but it does not have a constructor that accepts a single integer or primitive value (like root.val) to initialize it with that value.
        list.add(new ArrayList<>(List.of(root.val)));
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> l1=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                TreeNode left=curr.left;
                TreeNode right=curr.right;

                if(left!=null){
                    l1.add(left.val);
                    q.add(left);
                }
                if(right!=null){
                    l1.add(right.val);
                    q.add(right);
                }
            }
            if(l1.size()!=0){
                list.add(l1);
            }
        }
        Collections.reverse(list);
        return list;
    }
}