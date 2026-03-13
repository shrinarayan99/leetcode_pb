class Solution {
    public static ArrayList<Long>[] dp=new ArrayList[10];
    public static int MOD=1000000007;
    public int countTexts(String pressedKeys) {
        for(int i=0;i<10;i++){
            dp[i]=new ArrayList<>();
        }

        for(int i=2;i<=9;i++){
            //i occurs 0 times
            dp[i].add(0L);
            //i occurs 1 times
            dp[i].add(1L);
            //i occurs 2 times
            dp[i].add(2L);
            //i occurs 3 times
            dp[i].add(4L);

            if(i==7 || i==9){
                //i occurs 4 times
                dp[i].add(8L);
            }
            
        }
        char prev=pressedKeys.charAt(0);
        int count=1;

        long ans=1;

        for(int i=1;i<pressedKeys.length();i++){
            if(pressedKeys.charAt(i)!=prev){
                int num=prev-'0';
                if(num==7 || num==9){
                    ans=(ans*sol(num,count))%MOD;
                }
                else{
                    ans=(ans*sol(num,count))%MOD;
                }
                prev=pressedKeys.charAt(i);
                count=1;
            }
            else{
                count++;
            }

        }
        int num=prev-'0';
        if(num==7 || num==9){
            ans=(ans*sol(num,count))%MOD;
        }
        else{
            ans=(ans*sol(num,count))%MOD;
        }
        return (int)ans;

    }
    public long sol(int n,int count){
        if(dp[n].size()>count) return dp[n].get(count);
        for(int i=dp[n].size();i<=count;i++){
            if(n==7 || n==9){
                dp[n].add(((dp[n].get(i-1)%MOD)+(dp[n].get(i-2)%MOD)+(dp[n].get(i-3)%MOD)+(dp[n].get(i-4)%MOD))%MOD);
            }
            else{
                dp[n].add(((dp[n].get(i-1)%MOD)+(dp[n].get(i-2)%MOD)+(dp[n].get(i-3)%MOD))%MOD);
            }
        }
        return dp[n].get(count);
    }
}