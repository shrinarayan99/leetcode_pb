/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode,TreeNode> map;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        map=new HashMap<>();
        map.put(root,root);
        HashSet<TreeNode> set=new HashSet<>();
        Queue<TreeNode> qu=new LinkedList<>();
        qu.add(root);
        while(!qu.isEmpty()){
            int size=qu.size();
            
            for(int i=0;i<size;i++){
                TreeNode parent=qu.poll();
                TreeNode leftChild=parent.left;
                TreeNode rightChild=parent.right;

                if(leftChild!=null){
                    map.put(leftChild,parent);
                    qu.add(leftChild);
                }   
                if(rightChild!=null){
                    map.put(rightChild,parent);
                    qu.add(rightChild);
                }
                
                
            }
        }
        while(p!=root){
            set.add(p);
            p=map.get(p);
            
        }
        while(q!=root){
            if(set.contains(q)) return q;
            q=map.get(q);
        }
        return root;
    }
    
}
/*
        class Solution {
            public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
                
                if(root==null) return null;

                return CommonAncestor(root,p,q);
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
*/