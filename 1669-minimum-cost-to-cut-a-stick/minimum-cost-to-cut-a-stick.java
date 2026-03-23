class Solution {
    public static int[] sorted;
    public int minCost(int n, int[] cuts) {
        int m=cuts.length;
        sorted=new int[m+2];
        Arrays.sort(cuts);
        sorted[0]=0;
        sorted[m+1]=n;
        for(int i=0;i<m;i++){
            sorted[i+1]=cuts[i];
        }
        int[][] dp=new int[m+2][m+2];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return sol(0,m+1,dp);
    }
    public static int sol(int i ,int j,int[][] dp){
        if(j-i<2) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            //i and j are boundries will help for length stick 
            int cost=sorted[j]-sorted[i]+sol(i,k,dp)+sol(k,j,dp);

            min=Math.min(min,cost);
        }
        return dp[i][j]= min;
    }
}

/*

        class Solution {
    public static int[] sorted_cuts;
   
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        sorted_cuts=cuts.clone();
        int cuts_length=cuts.length;
       
        return sol(0,cuts_length-1,0,n);
        
    }
    public static int sol(int Arr_left,int Arr_right,int line_left,int line_right){
        if (Arr_left > Arr_right) return 0;
       
        
        int min=Integer.MAX_VALUE;

        for(int k=Arr_left;k<=Arr_right;k++){
            int cut=sorted_cuts[k];

            int cost=(line_right-line_left) +sol(Arr_left,k-1,line_left,cut)+sol(k+1,Arr_right,cut,line_right);

            min=Math.min(cost,min);
        }
        return min;
    }

}

*/