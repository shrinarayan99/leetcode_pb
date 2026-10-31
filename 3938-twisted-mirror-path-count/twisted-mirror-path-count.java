class Solution {
    int MOD=1000000007;
    int m;
    int n;
    int[][][] dp;
    public int uniquePaths(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        dp=new int[m][n][2];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return sol(0,0,grid,0);
    }
    public int sol(int i,int j, int[][] grid ,int signal){
        if(i<0 || i>=m ||j <0 || j>=n) return 0;
        if(i==m-1 && j==n-1) return 1;
        if(dp[i][j][signal]!=-1) return dp[i][j][signal];
        //0 -> coming from left
        //1 -> coming from up.
        int gridWillGo=0;
        int down=0;
        int right=0;
        if(grid[i][j]==1 && signal==1) gridWillGo=sol(i,j+1,grid,0);
        else if(grid[i][j]==1 && signal==0) gridWillGo=sol(i+1,j,grid,1);
        else{
            down=sol(i+1,j,grid,1);
            right=sol(i,j+1,grid,0);
        }
        return dp[i][j][signal]=(right+down+gridWillGo)%MOD;


        
    }
}