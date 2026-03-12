class Solution {
    public int numTrees(int n) {
        int[] dp=new int[n+1];
       return sol(n,dp);
    }

    public int sol( int n,int[] dp){
        if(n<=1) return 1;
        if(dp[n]!=0) return dp[n];
        int ans=0;

        for(int i=1;i<=n;i++){
            ans+=sol(i-1,dp)*sol(n-i,dp);
        }
        return dp[n]=ans;
    }
}

/*
class Solution {
    public int numTrees(int n) {
        long[] factorial=new long[2*n+1];
        factorial[0]=1;

        for(int i=1;i<=2*n;i++){
            factorial[i]=i*factorial[i-1];
        }

        long ans=factorial[2*n]/(factorial[n+1]*fact/orial[n]);

        return (int)ans;

    }
}

*/