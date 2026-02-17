class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] distance=new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[k]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] {0,k});
        ArrayList<ArrayList<int[]>> list=new ArrayList<>();

        for(int i=0;i<=n;i++){
            list.add(new ArrayList<int[]>());
        }

        for(int i=0;i<times.length;i++){
            int u=times[i][0];
            int v=times[i][1];
            int w=times[i][2];
            list.get(u).add(new int[] {v,w});

        }

        while(!pq.isEmpty()){
            int[] arr=pq.poll();
            int u=arr[1];
            int dis=arr[0];

            if(dis>distance[u]) continue;
            for(int i=0;i<list.get(u).size();i++){
                int[] curr=list.get(u).get(i);
                int v=curr[0];
                int w=curr[1];

                int d=dis+w;
                if(d<distance[v]){
                    distance[v]=d;
                    pq.add(new int[] {d,v});
                } 
            }
        }

        int ans=0;
        for(int i=1;i<=n;i++){
            int val=distance[i];
            if(val==Integer.MAX_VALUE) return -1;

            ans=Math.max(ans,val);
        }
        return ans;
    }
}