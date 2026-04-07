class Solution {
    public static int[][][] dp;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        dp=new int[group.length][n+1][minProfit+1];
        for(int[][] a:dp){
            for(int[] b:a){
                Arrays.fill(b,-1);
            }
        }
        return sol(n,minProfit,group,profit,0,0);
        
    }
    public static int sol(int n,int minProfit, int[] group, int[] profit,int p,int i){
       
        if(i==group.length){
            if(p>=minProfit) return 1;
            return 0;
        }
         
         if(dp[i][n][p]!=-1) return dp[i][n][p];
        

        int take=0;
        if(n>=group[i]){
            int min=Math.min(minProfit,p+profit[i]);
            take=sol(n-group[i],minProfit,group,profit,min,i+1);
        }
        int skip=sol(n,minProfit,group,profit,p,i+1);

        return dp[i][n][p]=(take+skip)%1000000007;
       
    }
}