class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;

        ArrayList<int[]> list=new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int x1=points[i][0];
                int y1=points[i][1];
                int x2=points[j][0];
                int y2=points[j][1];
                int distance=Math.abs(x1-x2)+ Math.abs(y1-y2);

                list.add(new int[] {distance,i,j});
            }
        }
        int[] parent=new int[n];
        int[] size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
        Collections.sort(list,(a,b)->a[0]-b[0]);

        int calculate=0;

        for(int i=0;i<list.size();i++){
            int[] curr=list.get(i);
            int weight=curr[0];
            int x=curr[1];
            int y=curr[2];

            if(find(x,parent)!=find(y,parent)){
                calculate+=weight;
                dsu(x,y,parent,size);
            }
        }
        return calculate;
    }
    public void dsu(int u,int v,int[] parent,int[] size){
        int ul_u=find(u,parent);
        int ul_v=find(v,parent);

        if(ul_v==ul_u) return;
        if(size[ul_u]>size[ul_v]){
            size[ul_u]+=size[ul_v];
            parent[ul_v]=ul_u;
        }
        else{
            size[ul_v]+=size[ul_u];
            parent[ul_u]=ul_v;
        }
    }
    public int find(int x, int[] parent){
        if(x==parent[x]) return x;

        return parent[x]=find(parent[x],parent);
    }
}