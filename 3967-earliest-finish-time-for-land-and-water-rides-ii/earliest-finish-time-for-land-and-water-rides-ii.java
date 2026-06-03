class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<landStartTime.length;i++){
            min=Math.min(min,landStartTime[i]+landDuration[i]);
        }

        int ans=Integer.MAX_VALUE;
        for(int i=0;i<waterStartTime.length;i++){
            if(waterStartTime[i]<=min){
                ans=Math.min(ans,min+waterDuration[i]);
            }
            else{
                ans=Math.min(ans,waterDuration[i]+waterStartTime[i]);
            }
        }
        int min1=Integer.MAX_VALUE;
        for(int i=0;i<waterStartTime.length;i++){
            min1=Math.min(min1,waterStartTime[i]+waterDuration[i]);
        }

        int ans1=Integer.MAX_VALUE;
        for(int i=0;i<landStartTime.length;i++){
            if(landStartTime[i]<=min1){
                ans1=Math.min(ans1,min1+landDuration[i]);
            }
            else{
                ans1=Math.min(ans1,landDuration[i]+landStartTime[i]);
            }
        }
        return Math.min(ans,ans1);
    }
}