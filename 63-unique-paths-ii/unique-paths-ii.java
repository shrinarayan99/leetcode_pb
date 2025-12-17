class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
       if(obstacleGrid[0][0]==1) return 0;
        if(obstacleGrid[m-1][n-1]==1) return 0;
        int[][] dp=new int[m][n];

        dp[m-1][n-1]=1;

      // last column
        for (int i = m - 2; i >= 0; i--) {
            if (obstacleGrid[i][n - 1] == 1) {
                dp[i][n - 1] = 0;
            } else {
                dp[i][n - 1] = dp[i + 1][n - 1];
            }
        }
        for (int j = n - 2; j >= 0; j--) {
            if (obstacleGrid[m - 1][j] == 1) {
                dp[m - 1][j] = 0;
            } else {
                dp[m - 1][j] = dp[m - 1][j + 1];
            }
        }

        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                if(obstacleGrid[i][j]!=1){
                    dp[i][j]=dp[i+1][j]+dp[i][j+1];
                }
                else{
                    dp[i][j]=0;
                }
            }
        }
        return dp[0][0];
    }
}


/* TOP BOTTOM APPROCH



class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;

        if(obstacleGrid[m-1][n-1]==1) return 0;
        int[][] dp=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
         return sol(obstacleGrid,m,n,0,0,dp);
         
        
    }
    public int sol(int[][] obstacleGrid,int m,int n,int i,int j,int[][] dp){
        if(i>=m || j>=n) return 0;

        if(i==m-1 && j==n-1){
            dp[i][j]=1;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int down=0;
        if(i<m && obstacleGrid[i][j]!=1){
            down=sol(obstacleGrid,m,n,i+1,j,dp);
        }
        int right=0;
        if(j<n && obstacleGrid[i][j]!=1){
            right=sol(obstacleGrid,m,n,i,j+1,dp);
        }
        dp[i][j]=down+right;
        return dp[i][j];
    }
}

*/