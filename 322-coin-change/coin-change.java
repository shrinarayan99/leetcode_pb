class Solution {
    public int coinChange(int[] coins, int amount) {
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
        //if(amount<0) return Integer.MAX_VALUE;

        if(i==0){
            if(amount%coins[0]==0) return amount/coins[0];
            else return Integer.MAX_VALUE;
        }
        if(amount==0) return 0;
        if(dp[i][amount]!=-1) return dp[i][amount];
        int take=Integer.MAX_VALUE;
        if(amount>=coins[i]){
            take=sol(coins,i,amount-coins[i],dp);
            if(take!=Integer.MAX_VALUE) {
                take+=1;
            }
        }
        int notTake=sol(coins,i-1,amount,dp);

        return dp[i][amount]=Math.min(take,notTake);
    }
}

/* GREEDY BUT SOMEWHERE WRONG

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        if(coins.length==1 && amount%coins[0]!=0) {
            return -1;
        }
        else if(coins.length==1 && amount%coins[0]==0){
            return amount/coins[0];
        }

        Arrays.sort(coins);
        int index=coins.length-1;
        if(coins[coins.length-1]>amount){
            int left=0;
            int right=coins.length-1;
            while(left<right){
                int mid=left+(right-left)/2;
                index=mid;
                if(coins[mid]>amount){
                    right=mid;
                }
                else{
                    left=mid+1;
                }
            }
        }
        return sol(index,coins,amount);

    }
    public int sol(int i,int[] arr,int amount){
        int count=0;
        count=amount/arr[i];
        int rem=amount%arr[i];

        for(int j=i-1;j>=0;j--){
            if(arr[j]>rem) continue;

            count+=rem/arr[j];
            rem%=arr[j];
        }

        if(rem==0){
            return count;
        }
        return -1;
    }
}

*/


