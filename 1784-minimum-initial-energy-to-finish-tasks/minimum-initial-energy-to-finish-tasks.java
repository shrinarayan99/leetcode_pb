class Solution {
    public int minimumEffort(int[][] tasks) {
        // greater value has priority96
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int[] currentTask:tasks){
            int dif=Math.abs(currentTask[1]-currentTask[0]);
            pq.add(new int[] {dif,currentTask[0],currentTask[1]});
        }
        int minRequired=0;
        int current=0;
        while(!pq.isEmpty()){
            int[] currentTask=pq.poll();
            if(current<currentTask[2]){
                minRequired+=(currentTask[2]-current);
                current=currentTask[0];
            }
            else current=current-currentTask[1];
        }
        return minRequired;
    }
}