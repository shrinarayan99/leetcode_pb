class Solution {
    int[][] pali;
    int[][] dp;

    public int maxPalindromes(String s, int k) {
        
        int n=s.length();
        pali=new int[n][n];
        dp=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
            Arrays.fill(pali[i],-1);
        }

        return sol(0,0,n,s,k);
        
        
    }
    public int sol(int i,int j,int n,String s,int k){
        if(j<i) return 0;
        if(i>=n || i<0 || j>=n || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        
        // skip karo suru k char kyuki(achha mtlb skip kiye bina krte to possibility hai ki pahla hi baha palindromnme mil jata and uskee andar k size ke palindrome ho sakte the)
        int ans=sol(i+1,i+1,n,s,k);


        if(isPalindrome(i,j,s) && (j-i+1)>=k){
            // found one ab uske aage se chalu kro kyuki non overlapping chahiye
            ans=Math.max(ans,1+sol(j+1,j+1,n,s,k));
            
        }
       //last k index increase krdo
        ans=Math.max(ans,sol(i,j+1,n,s,k));

        return dp[i][j]=ans;
    }
     public boolean isPalindrome(int i, int j, String s) {

        if (pali[i][j] != -1)
            return pali[i][j] == 1;

        if (i == j)
            return (pali[i][j] = 1) == 1;

        if (j - i == 1)
            return (pali[i][j] =
                    s.charAt(i) == s.charAt(j) ? 1 : 0) == 1;

        if (s.charAt(i) != s.charAt(j))
            return (pali[i][j] = 0) == 1;

        return (pali[i][j] =
                isPalindrome(i + 1, j - 1, s) ? 1 : 0) == 1;
    }
}