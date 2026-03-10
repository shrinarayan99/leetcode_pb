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

/* pass for 183/269 testcases failed for
{
    "2101"

    output:'3'
    expected='1'
}

class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int[] dp=new int[n];

        if(s.charAt(0)=='0') return 0;
        dp[0]=1;

        for(int i=1;i<n;i++){
            if(s.charAt(i)=='0'){
                if(s.charAt(i-1)=='0'){
                    return 0;
                }
                else{
                    dp[i]=dp[i-1];
                }
            }
            else if(s.charAt(i-1)=='2'){
                if(s.charAt(i)>'6'){
                    dp[i]=dp[i-1];
                }
                else{
                    dp[i]=dp[i-1]+1;
                }
            }
            else if(s.charAt(i-1)>'2'){
                dp[i]=dp[i-1];
            }
            else{
                dp[i]=dp[i-1]+1;
            }
        }
        return dp[n-1];
    }
}

*/