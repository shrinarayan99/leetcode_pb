class Solution {
    public int longestStrChain(String[] words) {
        // comparator funtion sorting
         Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));

        int[][] dp=new int[words.length][words.length+1];
        for(int i=0;i<words.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=sol(words,0,-1,dp);
        
        return ans;
    }
    public int sol(String[] words,int i,int prev,int[][] dp){
        if(i==words.length)  return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int take=0;
        if(prev == -1 || isPredecessor(words[prev],words[i])){
            take=1+sol(words,i+1,i,dp);
        }
        int skip=sol(words,i+1,prev,dp);

        return dp[i][prev+1]=Math.max(take,skip);

    }
    public boolean isPredecessor(String s1,String s2){
        if(s1.length()+1!=s2.length()) return false;

        int i=0;
        int j=0;
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
            }
            j++;
        }
        if(i==s1.length()){
            return true;
        }
        return false;
    }
}