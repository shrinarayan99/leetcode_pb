class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int ans=1;
        int[][] dp=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                ans=Math.max(ans,sol(matrix,i,j,dp));
            }
        }
        return ans;
    }
    public int sol(int[][] matrix,int i, int j,int[][] dp){
        if(i==matrix.length || j==matrix[0].length ||i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int up=0;
        if(i!=0 && matrix[i-1][j]>matrix[i][j]  ){
             up=sol(matrix,i-1,j,dp);
        }
        int down=0;
        if(i!=matrix.length-1 && matrix[i+1][j]>matrix[i][j]){
            down=sol(matrix,i+1,j,dp);
        }
        int right=0;
        if(j!=matrix[0].length-1 &&matrix[i][j+1]>matrix[i][j]){
            right=sol(matrix,i,j+1,dp);
        }
        int left=0;
        if(j!=0 && matrix[i][j-1]>matrix[i][j]){
            left=sol(matrix,i,j-1,dp);
        }

        return dp[i][j]= 1+Math.max(up,Math.max(down,Math.max(right,left)));
    }
}