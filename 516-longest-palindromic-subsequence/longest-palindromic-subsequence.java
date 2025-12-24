class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s.length()==1) return 1;
        int[][]dp= new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            Arrays.fill(dp[i],-1);
        }
        return sol(0,s.length()-1,s,dp);
    }
    public int sol(int i,int j,String s,int[][] dp ){
        if(i>j) return 0;
        if(i==j) return 1;

        if(s.charAt(i)==s.charAt(j)){
            return 2+sol(i+1,j-1,s,dp);
        }
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j]=Math.max(sol(i+1,j,s,dp),sol(i,j-1,s,dp));
    }
}