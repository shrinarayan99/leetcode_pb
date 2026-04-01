class Solution {
    public static int[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp=new int[arr.length];
        return sol(arr,k,0);
    }
    public int sol(int[] arr, int k,int i){
        if(i>=arr.length) return 0;
        if(dp[i]!=0) return dp[i];
        int ans=0;
        int max=0;
        for(int j=i;j<i+k;j++){
            if(j>=arr.length) break;
            max=Math.max(max,arr[j]);
            ans=Math.max(ans,(j-i+1)*max+sol(arr,k,j+1));
        }
        return dp[i]=ans;
    }


}