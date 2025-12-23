class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return sol(n-1,m-1,text1,text2,dp);
    }

    public int sol(int n,int m,String text1,String text2,int[][] dp){
        if(n<0 || m<0) return 0;

        if(text1.charAt(m)==text2.charAt(n)){
            return 1+sol(n-1,m-1,text1,text2,dp);
        }
        if(dp[m][n]!=-1) return dp[m][n];
        return dp[m][n]= Math.max(sol(n-1,m,text1,text2,dp),sol(n,m-1,text1,text2,dp));
    }
}