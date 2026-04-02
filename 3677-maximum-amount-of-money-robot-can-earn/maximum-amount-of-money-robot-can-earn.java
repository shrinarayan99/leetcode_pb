class Solution {
    public static int[][][] dp;
    public int n;
    public int m;
  
    public int maximumAmount(int[][] coins) {
        n=coins.length;
        m=coins[0].length;
        dp=new int[n][3][m];

        for(int[][]rows:dp){
           for(int i=0;i<3;i++){
             Arrays.fill(rows[i],Integer.MIN_VALUE);
           }
        }
        int neutralize=2;
        return sol(coins,0,0,neutralize);
    }
    public int sol(int[][] coins,int i,int j,int neutralize){
        if (i == n - 1 && j == m - 1) {
            if (coins[i][j] < 0 && neutralize > 0) return 0;
                 return coins[i][j];
        }
        if(i>=n || j>=m) return Integer.MIN_VALUE;
        if(dp[i][neutralize][j]!=Integer.MIN_VALUE) return dp[i][neutralize][j];
        
        int a=coins[i][j];
        if(coins[i][j]<0 && neutralize>0){
            a=0;
    
        }
        int ans=Integer.MIN_VALUE;
        // if neutralize
        int down=Integer.MAX_VALUE;
        if(coins[i][j] < 0 && neutralize>0){
            down=sol(coins,i+1,j,neutralize-1);
            if(down!=Integer.MIN_VALUE) ans=Math.max(ans,down+a);     
        }
        
        // if not neutralize
        down=sol(coins,i+1,j,neutralize);
        if(down!=Integer.MIN_VALUE) ans=Math.max(ans,down+coins[i][j]);

        // if neutralize
        int right=Integer.MAX_VALUE;
        if(coins[i][j] < 0 && neutralize>0){
            right=sol(coins,i,j+1,neutralize-1);
            if(right!=Integer.MIN_VALUE) ans=Math.max(ans,right+a);
        }
        

        // if not neutralize
        right=sol(coins,i,j+1,neutralize);
        if(right!=Integer.MIN_VALUE) ans=Math.max(ans,right+coins[i][j]);


        return dp[i][neutralize][j]=ans;


    }
}