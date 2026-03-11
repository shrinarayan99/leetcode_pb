class Solution {
    public int integerBreak(int n) {
        int[] dp=new int[n+1];
        return sol(n,dp);
    }
    public int sol(int n,int[] dp){
        if(n==1) return 1;
        int ans=0;
        if(dp[n]!=0) return dp[n];
        for(int i=1;i<n;i++){
            ans=Math.max(ans,Math.max(i*(n-i),i*sol(n-i,dp)));
        }
        return dp[n]=ans;
    }
}