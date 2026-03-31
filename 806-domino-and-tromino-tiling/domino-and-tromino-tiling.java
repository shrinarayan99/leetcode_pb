class Solution {
    public int numTilings(int n) {
        int MOD=1000000007;
        long[] dp=new long[n+1];
        for(int i=1;i<=n;i++){
            if(i==1) dp[i]=1;
            else if(i==2) dp[i]=2;
            else if(i==3) dp[i]=5;
            else{
                dp[i]=(2*dp[i-1]%MOD+dp[i-3]%MOD)%MOD;
            }
        }
        return (int)dp[n];
    }
}