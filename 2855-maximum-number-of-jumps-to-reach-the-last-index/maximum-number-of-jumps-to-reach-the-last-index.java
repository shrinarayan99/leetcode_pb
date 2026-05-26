class Solution {
    public int[] dp;
    public int maximumJumps(int[] nums, int target) {
        dp=new int[nums.length];
        Arrays.fill(dp,-1);
        int ans=sol(0,nums,target);
        if(ans==Integer.MIN_VALUE) return -1;
        return ans;
    }
    public int sol(int i,int[] nums,int target){
        if(i == nums.length - 1) return 0;
        if(dp[i]!=-1) return dp[i];
        int take=Integer.MIN_VALUE;
        for(int k=i+1;k<nums.length;k++){
            if(Math.abs(nums[k]-nums[i])<=target){
                int next=sol(k,nums,target);
                if(next!=Integer.MIN_VALUE) take=Math.max(take,1+next);
            }
        }
        return dp[i]=take;
    }
}