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
    public static HashMap<TreeNode,TreeNode> map;
    public static List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        map=new HashMap<>();
        ans=new ArrayList<>();
        if(root == null) return ans;
        map.put(root,null);
       
        sol(root,targetSum,0);

        return ans;
    }
    public static void sol(TreeNode root, int targetSum,int total){
          if(root == null) return;
        if(root.left==null && root.right==null){
            total+=root.val;
            if(total==targetSum){
                build(root);
            }
            return;
        }
        
        

        if(root.left!=null){
            // child idx,{par idx,par val}
            map.put(root.left,root);
            sol(root.left,targetSum,total+root.val);
        }
        if(root.right!=null){
            map.put(root.right,root);
            sol(root.right,targetSum,total+root.val);
        }

    }
    public static void build(TreeNode root){
        boolean flag=true;
        List<Integer> list=new ArrayList<>();
        while(flag){
            list.add(root.val);
            root=map.get(root);
            if(root==null){
                flag=false;
            }
        }
        Collections.reverse(list);
        ans.add(list);
    } 
}

/*


class Solution {
    public static HashMap<Long,long[]> map;
    public static List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        map=new HashMap<>();
        ans=new ArrayList<>();
        if(root == null) return ans;
        map.put(0L,new long[] {-1L,(long)root.val});
       
        sol(root,targetSum,0,0L);

        return ans;
    }
    public static void sol(TreeNode root, int targetSum,int total,long idx){
          if(root == null) return;
        if(root.left==null && root.right==null){
            total+=root.val;
            if(total==targetSum){
                build(root.val,idx);
            }
            return;
        }
        
        

        if(root.left!=null){
            // child idx,{par idx,par val}
            map.put(2*idx+1,new long[] {idx,root.val});
            sol(root.left,targetSum,total+root.val,2*idx+1);
        }
        if(root.right!=null){
            map.put(2*idx+2,new long[] {idx,root.val});
            sol(root.right,targetSum,total+root.val,2*idx+2);
        }

    }
    public static void build(int root,long idx){
        boolean flag=true;
        List<Integer> list=new ArrayList<>();
        while(flag){
            list.add(root);
            long[] arr=map.get(idx);
            idx=arr[0];
            root=(int)arr[1];
            if(idx==-1){
                flag=false;
            }

        }
        Collections.reverse(list);
        ans.add(list);
    } 
}

*/