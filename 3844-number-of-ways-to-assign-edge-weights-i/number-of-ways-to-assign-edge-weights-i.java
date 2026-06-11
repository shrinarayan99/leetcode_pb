class Solution {
    ArrayList<ArrayList<Integer>> list;
    public int assignEdgeWeights(int[][] edges) {
        list=new ArrayList<>();
        int n=edges.length;
        for(int i=0;i<=n+1;i++){
            list.add(new ArrayList<>());
        }

        for(int[] val:edges){
            list.get(val[0]).add(val[1]);
            list.get(val[1]).add(val[0]);
        }

        boolean[] visited=new boolean[n+2];

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[] {1,0});
        visited[1]=true;
        int max=Integer.MIN_VALUE;

        while(!q.isEmpty()){
            int[] curr=q.poll();
            max=Math.max(max,curr[1]);
            for(int val:list.get(curr[0])){
                if(!visited[val]){
                    visited[val]=true;
                    q.add(new int[] {val,curr[1]+1});
                }
            }
        }
        System.out.print(max);
        int ans=power(2,max-1)%1000000007;

        return ans;
    }
    public int power(int a,int b){
        long ans=1;
        for(int i=0;i<b;i++){
            ans=(ans*a)%1000000007;
        }
        return (int)ans;
    }
}