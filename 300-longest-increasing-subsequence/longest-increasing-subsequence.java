class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp=new int[nums.length][nums.length+1];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i],Integer.MIN_VALUE);
        }
        return sol(nums,0,-1,dp);
    }
    public int sol(int[] nums,int idx,int prevIndex, int[][] dp){
        if(idx==nums.length) return 0 ;
        if(dp[idx][prevIndex+1]!=Integer.MIN_VALUE) return dp[idx][prevIndex+1];
        int take=0;
        if(prevIndex==-1||nums[idx]>nums[prevIndex]){
            take=1+sol(nums,idx+1,idx,dp);
        }
        int skip=sol(nums,idx+1,prevIndex,dp);
        return dp[idx][prevIndex+1]=Math.max(take,skip);
    }
}

/*RECURSIVE approch


class Solution {
    public int lengthOfLIS(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,sol(nums,i,nums[i])+1);
        }
        return max;
    }
    public int sol(int[] nums,int idx,int prevMax){
        if(idx==nums.length) return 0 ;
        int take=0;
        if(nums[idx]>prevMax){
            take=1+sol(nums,idx+1,nums[idx]);
        }
        int skip=sol(nums,idx+1,prevMax);
        return Math.max(take,skip);
    }
}


*/