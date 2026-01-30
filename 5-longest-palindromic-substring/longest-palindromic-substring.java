class Solution {
    String ans="";
    int[][] dp;
    public String longestPalindrome(String s) {
        if(s.length()==1 || s.length()==0) return s;
        dp=new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            find(s,i,i);// for odd length palindrome ( eg:_  aba)
            find(s,i,i+1);// for even length palindrome ( eg:_  abba)
        }
        return ans;
    }
    public void find(String s,int left,int right){
        if(left<0 || right>=s.length()) return;
        if(isPalindrome(s,left,right)){
            if(right-left+1>ans.length()){
                ans=s.substring(left,right+1);
            }
            find(s,left-1,right+1);
        }
    }
    // aisa hoga ki i and j ke beech ke already check ho chuke honge ki palindrome hai y nhi 
    public boolean isPalindrome(String s, int i, int j) {
        if (i >= j) return true;

        if (dp[i][j] != 0) return dp[i][j] == 1;

        if (s.charAt(i) == s.charAt(j) && isPalindrome(s, i + 1, j - 1)) {
            dp[i][j] = 1;
        } else {
            dp[i][j] = -1;
        }
        return dp[i][j] == 1;
    }

}



/* TLE (because we are checking palindrome for every substring)


class Solution {
    String ans="";
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        String[][] dp=new String[s.length()][s.length()];
        find(s, 0, 0,dp);
        return ans;

    }
    public void find(String s, int start, int end,String[][] dp) {
         if (start >= s.length()) return;
        // If end reached, move start forward
        if (end == s.length()) {
            find(s, start + 1, start + 1,dp);
            return;
        }
        if(dp[start][end]!=null) {
            if(dp[start][end].length()>ans.length()){
                ans=dp[start][end];
            }
            find(s, start, end + 1,dp);
            return;
        }
        String sub = s.substring(start, end + 1);

        if (isPalindromic(sub) && sub.length() > ans.length()) {
            dp[start][end]=sub;
            if(dp[start][end].length()>ans.length()){
                ans=sub;
            }
            else{
                dp[start][end]="";// checked but not palindromic
            }
        }
        dp[start][end]=ans;
        // Expand the substring
        find(s, start, end + 1,dp);
    }
    public boolean isPalindromic(String s){
        if(s.length()==1) return true;
        int left=0;
        int right=s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

*/