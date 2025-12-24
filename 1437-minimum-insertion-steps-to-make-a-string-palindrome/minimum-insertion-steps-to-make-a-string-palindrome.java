class Solution {
    public int minInsertions(String s) {
        int[][]dp= new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            Arrays.fill(dp[i],-1);
        }
        return sol(0,s.length()-1,s,dp);
    }
    public int sol(int i,int j,String s,int[][] dp){
        if(i>=j) return 0;

        if(s.charAt(i)==s.charAt(j)){
            return sol(i+1,j-1,s,dp);
        }
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j]= 1+Math.min(sol(i+1,j,s,dp),sol(i,j-1,s,dp));
    }
}