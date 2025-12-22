class Solution {
    public int change(int amount, int[] coins) {
     int[][] dp=new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans= sol(coins,coins.length-1,amount,dp);
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
    public int sol(int[] coins, int i,int amount,int[][] dp){
        if(amount<0) return 0;

        if(i==0){
            if(amount%coins[0]==0) return 1;
            else return 0;
        }
        if(amount==0) return 1;
        if(dp[i][amount]!=-1) return dp[i][amount];
        int take=sol(coins,i,amount-coins[i],dp);;
        int notTake=sol(coins,i-1,amount,dp);

        return dp[i][amount]=take+notTake;
    }
}