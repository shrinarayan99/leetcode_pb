class Solution {
    static int MOD=1000000007;
    public int countPaths(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int[][] dp=new int[row][col];
        for(int i=0;i<row;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i< row;i++){
            for(int j=0;j<col;j++){
                sol(grid,i,j,row,col,dp);
            }
        }
        int ans=0;
        for(int i=0;i< row;i++){
            for(int j=0;j<col;j++){
                ans=(ans+dp[i][j])%MOD;
            }
        }
        return ans;
    }
    public int sol(int[][] grid, int i,int j,int row, int col,int[][] dp){
        if(i<0 || j<0 || i>=row || j>=col) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int up=0;
        if(i!=0 && grid[i-1][j]>grid[i][j]){
            up=sol(grid,i-1,j,row,col,dp);
        }
        int down=0;
        if(i!=row-1 && grid[i+1][j]>grid[i][j]){
            down=sol(grid,i+1,j,row,col,dp);
        }
        int left=0;
        if(j!=0 && grid[i][j-1]>grid[i][j]){
            left=sol(grid,i,j-1,row,col,dp);
        }
        int right=0;
        if(j!=col-1 && grid[i][j+1]>grid[i][j]){
            right=sol(grid,i,j+1,row,col,dp);
        }
        long path=1+up+down+left+right;
        return dp[i][j]=(int)(path%MOD);
    }
}