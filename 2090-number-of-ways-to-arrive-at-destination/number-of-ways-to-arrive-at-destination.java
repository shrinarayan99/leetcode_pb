class Solution {
    public static int MOD=1000000007;
    public int countPaths(int n, int[][] roads) {
        long[] time=new long[n];
        int[] ways=new int[n];
        Arrays.fill(time,Long.MAX_VALUE);
        time[0]=0;
        ways[0]=1;

        ArrayList<ArrayList<int[]>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<int[]>());
        }
        for(int i=0;i<roads.length;i++){
            int u=roads[i][0];
            int v=roads[i][1];
            int t=roads[i][2];
            list.get(u).add(new int[] {v,t});
            list.get(v).add(new int[] {u,t});    
        }

        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
        pq.add(new long[] {0,0});

        while(!pq.isEmpty()){
            long[] arr=pq.poll();
            int u=(int)arr[1];
            long t=arr[0];
            if(t > time[u]) continue;

            for(int i=0;i<list.get(u).size();i++){
                int[] curr=list.get(u).get(i);
                int v=curr[0];
                int w=curr[1];

                long dis=w+t;
                if(time[v]==dis){
                    ways[v]=(ways[v]+ways[u])%MOD;
                }
                else if(time[v]>dis){
                    time[v]=dis;
                    ways[v]=ways[u];
                    pq.add(new long[] {dis,v});
                }

            }
        }
        return ways[n-1];

    }
}