class Solution {
    public int MOD=1000000007;
    public int[][][] dp;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp=new int[m][n][maxMove+1];
        for(int[][] a:dp){
            for(int[] b:a){
                Arrays.fill(b,-1);
            }
        }
        return sol(m,n,maxMove,startRow,startColumn);
    }
    public int  sol(int m, int n,int maxMove,int i,int j){
        if(i<0 || i>=m || j<0 || j>=n) return 1;
        if(maxMove<=0) return 0;
        if(dp[i][j][maxMove]!=-1) return dp[i][j][maxMove];
        long up=sol(m,n,maxMove-1,i-1,j);
        long down=sol(m,n,maxMove-1,i+1,j);
        long left=sol(m,n,maxMove-1,i,j-1);
        long right=sol(m,n,maxMove-1,i,j+1);

        long ans=up+left+down+right;
        return dp[i][j][maxMove]=(int)(ans%MOD);
    }
}