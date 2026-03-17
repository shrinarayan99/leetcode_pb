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
    public static HashMap<Integer,ArrayList<int[]>> list;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        list=new HashMap<>();
       
        build(root);
        HashSet<Integer> visited=new HashSet<>();
        visited.add(startValue);
        HashMap<Integer, Integer> parent = new HashMap<>();
        HashMap<Integer, Character> dirMap = new HashMap<>();
        Queue<Integer> q=new LinkedList<>();
        q.add(startValue);
        parent.put(startValue,-1);
        while(!q.isEmpty()){
            int num=q.poll();
            if(num==destValue){
                 break; //found
            }
            for(int[] arr:list.getOrDefault(num, new ArrayList<>())){
                int[] curr=arr;
                int val=curr[0];
                int dir=curr[1];
                if(visited.contains(val)) continue;
                visited.add(val);
                char ch;
                if(dir==0) ch='U';
                else if(dir==1) ch='L';
                else ch='R';
                parent.put(val,num);
                dirMap.put(val,ch);
                q.add(val);
            }
        }
        StringBuilder sb = new StringBuilder();
        int curr = destValue;

        while (curr != startValue) {
            sb.append(dirMap.get(curr));
            curr = parent.get(curr);
        }

        return sb.reverse().toString();

    }


    /*
        0:-parent(U)
        1:-left child(L)
        2:-right child(R)
    */

    public static void build(TreeNode root){
        if(root==null) return;

        list.putIfAbsent(root.val, new ArrayList<>());
        if(root.left!=null){
            int left=root.left.val;
            list.putIfAbsent(left, new ArrayList<>());
            list.get(root.val).add(new int[] {left,1});
            list.get(left).add(new int[] {root.val,0});
        }
        if(root.right!=null){
            int right=root.right.val;
            list.putIfAbsent(right, new ArrayList<>());
            list.get(root.val).add(new int[] {right,2});
            list.get(right).add(new int[] {root.val,0});
        }
        build(root.left);
        build(root.right);
    }
}


/*
class Solution {
    public static ArrayList<ArrayList<int[]>> list;
    public static int max;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        list=new ArrayList<>();
        max=0;
        maximum(root);
        for(int i=0;i<=max;i++){
            list.add(new ArrayList<>());
        }
        build(root);
        HashSet<Integer> visited=new HashSet<>();
        visited.add(startValue);
        HashMap<Integer, Integer> parent = new HashMap<>();
        HashMap<Integer, Character> dirMap = new HashMap<>();
        Queue<Integer> q=new LinkedList<>();
        q.add(startValue);
        parent.put(startValue,-1);
        while(!q.isEmpty()){
            int num=q.poll();
            if(num==destValue){
                 break; //found
            }
            for(int[] arr:list.get(num)){
                int[] curr=arr;
                int val=curr[0];
                int dir=curr[1];
                if(visited.contains(val)) continue;
                visited.add(val);
                char ch;
                if(dir==0) ch='U';
                else if(dir==1) ch='L';
                else ch='R';
                parent.put(val,num);
                dirMap.put(val,ch);
                q.add(val);
            }
        }
        StringBuilder sb = new StringBuilder();
        int curr = destValue;

        while (curr != startValue) {
            sb.append(dirMap.get(curr));
            curr = parent.get(curr);
        }

        return sb.reverse().toString();
    }


    
        // 0:-parent(U)
        // 1:-left child(L)
        // 2:-right child(R)
    

    public static void build(TreeNode root){
        if(root==null) return;
        if(root.left!=null){
            int left=root.left.val;
            list.get(root.val).add(new int[] {left,1});
            list.get(left).add(new int[] {root.val,0});
        }
        if(root.right!=null){
            int right=root.right.val;
            list.get(root.val).add(new int[] {right,2});
            list.get(right).add(new int[] {root.val,0});
        }
        build(root.left);
        build(root.right);
    }


    // for finding the max val for the length of arraylist
    public static void maximum(TreeNode root){
        if(root==null){
            return ;
        }
        max=Math.max(max,root.val);
        maximum(root.left);
        maximum(root.right);
    }
}

*/
