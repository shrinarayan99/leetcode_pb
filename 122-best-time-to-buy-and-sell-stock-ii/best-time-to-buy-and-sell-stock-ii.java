class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][2];
        for(int i=0;i<prices.length;i++){
            dp[i][0]=Integer.MIN_VALUE;
            dp[i][1]=Integer.MIN_VALUE;
        }
        return sol(prices,1,0,dp);
    }
    public int sol(int[] arr,int flag,int i,int[][] dp){
        int profit=0;
        
        if(i<arr.length){
            if(dp[i][flag]!=Integer.MIN_VALUE) return dp[i][flag];
            if(flag==1){
                profit=Math.max(-arr[i]+sol(arr,0,i+1,dp),sol(arr,1,i+1,dp));
            }
       
            else{
                profit=Math.max(arr[i]+sol(arr,1,i+1,dp),sol(arr,0,i+1,dp));
            }
            return dp[i][flag]=profit;
        }
        return 0;
       
    }
}
/*
 
 class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int min=prices[0];
        int max=0;
        for(int i=1;i<prices.length;i++){
            
            if(prices[i]<prices[i-1]){
                profit+=(prices[i-1]-min);
                min=prices[i];
                max=0;
            }
            else if(prices[i]>prices[i-1]){
                max=prices[i];
            }
            else if(prices[i]<min){
                min=prices[i];
            }
            if(max!=0 && i==prices.length-1){
                profit+=(max-min);
            }
        }
        return profit;
    }
}

*/

/* SAME COMPLEXITY BUT SIMPLE AND EASY ONE

class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}

*/