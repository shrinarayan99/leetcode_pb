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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==1) return new TreeNode(nums[0]);
        int mid=nums.length/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=build(0,mid-1,nums);
        root.right=build(mid+1,nums.length-1,nums);

        return root;
    }
    public TreeNode build(int i,int j,int[] nums){
        if(j<i) return null;
        int mid=i+(j-i)/2;
        TreeNode newNode=new TreeNode(nums[mid]);
        newNode.left=build(i,mid-1,nums);
        newNode.right=build(mid+1,j,nums);
        return newNode;
    }
}