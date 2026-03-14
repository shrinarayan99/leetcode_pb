class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[][] dp=new int[days.length][366];
        return sol(0,0,days,costs,dp);
    }
    public int sol(int i,int valid_date,int[]days,int[] costs,int[][] dp){
        if(i>=days.length || valid_date>365) return 0;
        // if ticket valis till date then skip
        if(dp[i][valid_date]!=0) return dp[i][valid_date];
        if(days[i]<=valid_date){
            return dp[i][valid_date]=sol(i + 1, valid_date, days, costs,dp);
        }  
       // but from all 3 possible tickets
        int oneDay=costs[0]+sol(i+1,days[i],days,costs,dp);
        int sevenDay=costs[1]+sol(i+1,days[i]+6,days,costs,dp);
        int thirtyDay=costs[2]+sol(i+1,days[i]+29,days,costs,dp);
        return dp[i][valid_date]=Math.min(oneDay,Math.min(sevenDay,thirtyDay));
        
    }
}