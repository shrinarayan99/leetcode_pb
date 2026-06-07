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
    // parent ,nodes
    HashMap<Integer,Integer> mapLeft;//left node val
    HashMap<Integer,Integer> mapRight;// right node val
    //node which do not have any parent
    HashSet<Integer> setChild;
    HashSet<Integer> setParent;
    public TreeNode createBinaryTree(int[][] descriptions) {
        mapLeft=new HashMap<>();
        mapRight=new HashMap<>();

        setChild=new HashSet<>();
        setParent=new HashSet<>();

        for(int[] curr:descriptions){
            if(curr[2]==1){
                mapLeft.put(curr[0],curr[1]);
            }
            else{
                mapRight.put(curr[0],curr[1]);
            }
            setChild.add(curr[1]);
            setParent.add(curr[0]);
        }
        for(int val:setChild){
            if(setParent.contains(val)){
                setParent.remove(val);
            }
        }
         int root = setParent.iterator().next();

        return create(root);
    }
    public TreeNode create(int rootVal){

        TreeNode root=new TreeNode(rootVal);

        if(mapLeft.containsKey(rootVal)){
            root.left=create(mapLeft.get(rootVal));
        }
        if(mapRight.containsKey(rootVal)){
            root.right=create(mapRight.get(rootVal));
        }
        return root;
    }
}