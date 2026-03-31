class Solution {
    public long mostPoints(int[][] questions) {
        int n=questions.length;
        long[] dp=new long[n];
        return sol(questions,0,dp);
    }
    public long sol(int[][] questions,int i,long[] dp){
        if(i>=questions.length) return 0;

        if(dp[i]!=0) return dp[i];

        long take=questions[i][0]+sol(questions,i+questions[i][1]+1,dp);
        long skip=sol(questions,i+1,dp);

        return dp[i]=Math.max(take,skip);
    }
}