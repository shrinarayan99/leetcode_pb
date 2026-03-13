class Solution {
    static int MOD=1000000007;
    public int countGoodStrings(int low, int high, int zero, int one) {

        int[] dp=new int[high+1];
        Arrays.fill(dp,-1);

        int ans=0;

        for(int i=low;i<=high;i++){
            
            ans=(ans+sol(i,zero,one,dp))%MOD;
        }
        return ans;
    }
    public int sol(int n,int zero,int one,int[] dp){
        if(n==0) return 1;
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];
        int z=sol(n-zero,zero,one,dp);
        int x=sol(n-one,zero,one,dp);

        return dp[n]=(z+x)%MOD;
    }
}

/*TLE { because O(high^2)}

class Solution {
    static int MOD=1000000007;
    public int countGoodStrings(int low, int high, int zero, int one) {

        int ans=0;

        for(int i=low;i<=high;i++){
            int[] dp=new int[i+1];
            Arrays.fill(dp,-1);
            ans+=sol(0,i,zero,one,dp);
        }
        return ans;
    }
    public int sol(int i,int n,int zero,int one,int[] dp){
        if(i==n) return 1;
        if(i>n) return 0;
        if(dp[i]!=-1) return dp[i];
        int z=sol(i+zero,n,zero,one,dp);
        int x=sol(i+one,n,zero,one,dp);

        return dp[i]=(z+x)%MOD;
    }
}


*/

/* FACE MLE BECAUSE DP SIZE WHICH IS HIGH<=100000 THEN SIZE=1000000000  WITH 4 BYTE WILL BE NEED 40 GB MEMORY


class Solution {
    static int MOD=1000000007;
    public int countGoodStrings(int low, int high, int zero, int one) {

        
        int[][] dp=new int[high+1][high+1];
        for(int i=0;i<=high;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=0;

        for(int i=low;i<=high;i++){
            ans+=sol(0,i,zero,one,dp);
        }
        return ans;
    }
    public int sol(int i,int n,int zero,int one,int[][] dp){
        if(i==n) return 1;
        if(i>n) return 0;
        if(dp[n][i]!=-1) return dp[n][i];
        int z=sol(i+zero,n,zero,one,dp);
        int x=sol(i+one,n,zero,one,dp);

        return dp[n][i]=(z+x)%MOD;
    }
}

*/