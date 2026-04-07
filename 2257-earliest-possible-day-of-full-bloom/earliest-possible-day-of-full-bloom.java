class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);

        for(int i=0;i<plantTime.length;i++){
            pq.add(new int[] {growTime[i],plantTime[i]});
        }
        int days=0;
        int ans=0;
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            days+=curr[1];
            ans=Math.max(ans,days+curr[0]);
        }
        return ans;
    }
}