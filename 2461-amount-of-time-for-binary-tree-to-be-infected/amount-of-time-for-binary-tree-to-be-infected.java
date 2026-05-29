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
    HashMap<Integer,ArrayList<Integer>> map;                       
    public int amountOfTime(TreeNode root, int start) {
        map=new HashMap<>();
        fillMap(root);
        Queue<Integer> q=new LinkedList<>();
        HashSet<Integer> set=new HashSet<>();
        q.add(start);
        set.add(start);
        int time=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int val=q.poll();
                for(int neighbour:map.get(val)){
                    if(set.contains(neighbour)) continue;
                    set.add(neighbour);
                    q.add(neighbour);
                }
            }
            time++;
            
        }
        //kyuki empty hone ke baad bhi incriment ho rha
        return time-1;
    }
    public void fillMap(TreeNode root){
        if(root==null) return;

        if(!map.containsKey(root.val)){
            map.put(root.val, new ArrayList<>());
        }
        TreeNode left=root.left;
        if(left!=null){
            map.get(root.val).add(left.val);
            map.put(left.val,new ArrayList());
            map.get(left.val).add(root.val);
        }
        TreeNode right=root.right;
        if(right!=null){
            map.get(root.val).add(right.val);
            map.put(right.val,new ArrayList());
            map.get(right.val).add(root.val);
        }
        fillMap(root.left);
        fillMap(root.right);
    }
}