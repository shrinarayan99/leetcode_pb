class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set=new HashSet<>(wordDict);
        int[][] dp=new int[s.length()][s.length()];
       
        int ans= sol(0,0,set,s,dp);
        if(ans==1){
            return true;
        }
        else{
            return false;
        }
    }
    public int sol(int i,int j, HashSet<String> set,String s,int[][] dp){
        if( i==s.length()){
            return 1;
        } 

        if(j==s.length()) {
            return -1;
        }
        if(dp[i][j]!=0) return dp[i][j];

        if(set.contains(s.substring(i,j+1))){
            if(sol(j+1,j+1,set,s,dp)==1) {
                return dp[i][j]=1;
                
            }
        }

        return dp[i][j]=sol(i,j+1,set,s,dp);
    }
}