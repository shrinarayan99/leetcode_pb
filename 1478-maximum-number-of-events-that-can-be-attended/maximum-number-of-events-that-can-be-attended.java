class Solution {
    public int maxEvents(int[][] events) {
        //sort on the basis of start day (min to max)
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[0]-b[0]));
       //Arrays.sort(events,(a,b)->Integer.compare(a[0],b[0]));

        //min ending day will pop first
        PriorityQueue<Integer> inner_pq=new PriorityQueue<>();

        for(int[] event:events){
            pq.add(event);
        }
        int day=0;
        int ans=0;
        while(!pq.isEmpty() || !inner_pq.isEmpty()){
            if(inner_pq.isEmpty()){
                day=pq.peek()[0];
            }
           
           while (!pq.isEmpty() && pq.peek()[0] <= day) {
                inner_pq.add(pq.poll()[1]);
            }
            while (!inner_pq.isEmpty() && inner_pq.peek() < day) {
                inner_pq.poll();
            }
            if (!inner_pq.isEmpty()) {
                inner_pq.poll();
                ans++;
                day++;
            }
            
        }
        return ans;
    }
}