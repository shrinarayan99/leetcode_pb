class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < landStartTime.length; i++) {
            int landFinish = landStartTime[i] + landDuration[i];

            for (int j = 0; j < waterStartTime.length; j++) {

                ans = Math.min(
                    ans,
                    Math.max(landFinish, waterStartTime[j]) + waterDuration[j]
                );

                int waterFinish = waterStartTime[j] + waterDuration[j];

                ans = Math.min(
                    ans,
                    Math.max(waterFinish, landStartTime[i]) + landDuration[i]
                );
            }
        }

        return ans;
    }
}
/*

class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

        int[][] arr1=new int[landStartTime.length][2];
        for(int i=0;i<landStartTime.length;i++){
            arr1[i][0]=landStartTime[i];
            arr1[i][1]=landDuration[i];
        }
        int[][] arr2=new int[waterStartTime.length][2];
        for(int i=0;i<waterStartTime.length;i++){
            arr2[i][0]=waterStartTime[i];
            arr2[i][1]=waterDuration[i];
        }

        Arrays.sort(arr1,(a,b)->Integer.compare(a[0] + a[1], b[0] + b[1]));
        Arrays.sort(arr2,(a,b)->Integer.compare(a[0] + a[1], b[0] + b[1]));
        int time=0;
        boolean landFirst=false;
        if(arr1[0][0]<=arr2[0][0]){
            time+=(arr1[0][0]+arr1[0][1]);
            landFirst=true;
        }
        else{
            time+=(arr2[0][0]+arr2[0][1]);
        }
        if(landFirst){
            int t=Integer.MAX_VALUE;
            for(int i=0;i<waterDuration.length;i++){
                int p=0;
                if(waterStartTime[i]<time){
                    p+=(waterDuration[i]);
                }
                else{
                    p+=((waterStartTime[i]-time)+waterDuration[i]);
                }
                t=Math.min(t,p);
            }
            time+=t;
        }
        else{
            int t=Integer.MAX_VALUE;
            for(int i=0;i<landStartTime.length;i++){
                int p=0;
                if(landStartTime[i]<time){
                    p+=(landDuration[i]);
                }
                else{
                    p+=((landStartTime[i]-time)+landDuration[i]);
                }
                t=Math.min(t,p);
            }
            time+=t;
        }
        return time;
    }
}


*/