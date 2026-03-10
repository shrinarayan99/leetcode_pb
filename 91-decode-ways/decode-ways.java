class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(0,s,n,dp);
    }
    public int solve(int i,String s,int n,int[] dp){
        if(i==n) return 1;  // one valid sol found
        if(dp[i]!=-1) return dp[i];
        if(s.charAt(i)=='0') return 0;

        int single_digit=solve(i+1,s,n,dp);
        int double_dig=0;
        if(i+1<n && (s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<='6'))){
            double_dig=solve(i+2,s,n,dp);
        }

        return dp[i]=single_digit+double_dig;
    }
}

/*

    class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int[] dp=new int[n];

        if(s.charAt(0)=='0') return 0;
        dp[0]=1;

        for(int i=1;i<n;i++){
            if(s.charAt(i)!='0'){
                dp[i]=dp[i-1];
            }
            int num=(s.charAt(i-1)-'0')*10+(s.charAt(i)-'0');
            if(num>=10 && num<=26){
                if(i>=2) dp[i]+=dp[i-2];
                else{
                    dp[i]+=1;
                }
            }
            
        }
        return dp[n-1];
    }
}




*/