class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return sol(nums,0,target,0);
    }
    public int sol(int[] nums,int sum,int target,int i){
        if(i==nums.length){
            if(sum==target){
                return 1;
            }
            return 0;
        }
        

        int add=sol(nums,sum+nums[i],target,i+1);
        int sub=sol(nums,sum-nums[i],target,i+1);

        return add+sub;
    }
}