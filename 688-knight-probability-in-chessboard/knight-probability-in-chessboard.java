class Solution {
    public double out;
    public double[][][] dp;
    public double knightProbability(int n, int k, int row, int column) {
        out=0;
 
       dp = new double[n][n][k + 1];
        
        for (double[][] a : dp) {
            for (double[] b : a) {
                Arrays.fill(b, -1);
            }
        }
       double total_moves=Math.pow(8,k);

        return sol(n,k,row,column)/total_moves;
        
    }
    public double sol(int n, int k,int i,int j){
         if(i<0 || j<0 ||i>=n ||j>=n) {
            return 0;
         }   
        if(k==0){
            
            return 1;
            
        }
        if(dp[i][j][k]!=-1) return dp[i][j][k];
        double ans=0;
        ans+=sol(n,k-1,i-2,j+1);
        ans+=sol(n,k-1,i-2,j-1);

        ans+=sol(n,k-1,i+2,j+1);
        ans+=sol(n,k-1,i+2,j-1);

        ans+=sol(n,k-1,i+1,j+2);
        ans+=sol(n,k-1,i-1,j+2);

        ans+=sol(n,k-1,i+1,j-2);
        ans+=sol(n,k-1,i-1,j-2);

        return dp[i][j][k]=ans;
    }
}

//