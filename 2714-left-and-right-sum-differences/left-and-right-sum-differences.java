class Solution {
    public int[] leftRightDifference(int[] nums) {
        int sum=0;
        for(int val:nums){
            sum+=val;
        }
        int left=0;
        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i]=Math.abs(sum-nums[i]-left);
            sum-=nums[i];
            left+=nums[i];
        }
        return ans;
    }
}