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
    public static HashMap<Integer,HashMap<Integer,ArrayList<Integer>>> map;
    public static int max;
    public static int min;
    public static int maxrow;
    public static int minrow;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map=new HashMap<>();
        max=Integer.MIN_VALUE;
        min=Integer.MAX_VALUE;
        maxrow = Integer.MIN_VALUE;   
        minrow = Integer.MAX_VALUE;
        sol(root,0,0);
        int s=(max-min)+1;
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<s;i++){
            ans.add(new ArrayList<>());
        }

        for(int i=min;i<=max;i++){
            if(map.containsKey(i)){
                HashMap<Integer,ArrayList<Integer>> l=map.get(i);
                for(int j=minrow;j<=maxrow;j++){
                    if (!l.containsKey(j)) continue;
                    List<Integer> l1=l.get(j);
                    Collections.sort(l1);
                    for(int val:l1){
                        ans.get(i-min).add(val);
                    }

                }
                
            }
        }
        return ans;
        
    }
    public static void sol(TreeNode root,int col,int row){
        if(root==null) return;
        if(!map.containsKey(col)){
            map.put(col,new HashMap<>());
        }
        if(!map.get(col).containsKey(row)){
            map.get(col).put(row,new ArrayList<>());
        }

        map.get(col).get(row).add(root.val);
        max=Math.max(max,col);
        min=Math.min(min,col);
        maxrow=Math.max(maxrow,row);
        minrow=Math.min(minrow,row);
        sol(root.left,col-1,row+1);
        sol(root.right,col+1,row+1);
    }
}