class Solution {

    int[][] dp;

    public int rob(int[] nums) {

        // Case 1: first house NOT robbed
        dp = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int case1 = sol(1, nums, 0, 0);

        // Case 2: first house robbed
        dp = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int case2 = nums[0] + sol(1, nums, 1, 1);

        return Math.max(case1, case2);
    }

    // prevRobbed: 0 = not robbed, 1 = robbed
    // firstRobbed: 0 = not robbed, 1 = robbed

    public int sol(int i, int[] nums, int firstRobbed, int prevRobbed) {

        if (i >= nums.length)
            return 0;

        if (dp[i][prevRobbed] != -1)
            return dp[i][prevRobbed];

        // If first house was robbed, last house cannot be robbed
        if (i == nums.length - 1 && firstRobbed == 1)
            return 0;

        int skip = sol(i + 1, nums, firstRobbed, 0);

        int take = 0;

        if (prevRobbed == 0) {
            take = nums[i] + sol(i + 1, nums, firstRobbed, 1);
        }

        return dp[i][prevRobbed] = Math.max(take, skip);
    }
}
/*

class Solution {
    int[][][] dp;
    public int rob(int[] nums) {
        dp=new int[nums.length][2][2];
        return Math.max(sol(1,nums,0,0),nums[0]+sol(1,nums,1,1));
    }
    //prevrobbed: {0} not robbed {1} robbed
    //firstRobbed: {0} not robbed {1} robbed
    public int sol(int i,int[] nums,int firstRobbed,int prevRobbed){
        if(i>=nums.length) return 0;
        if(dp[i][firstRobbed][prevRobbed]!=0) return dp[i][firstRobbed][prevRobbed];
        if(i==nums.length-1 && firstRobbed==1) return 0;
        int take=0;
        int skip=sol(i+1,nums,firstRobbed,0);
        if(prevRobbed==0){
            take=nums[i]+sol(i+1,nums,firstRobbed,1);
        }
        return dp[i][firstRobbed][prevRobbed]=Math.max(take,skip);
    }
}
*/