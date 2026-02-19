class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;

        int[] parent=new int[n];
        int[] rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    Union(i,j,parent,rank);
                }
            }
        }
        int  count=0;
        for(int i=0;i<n;i++){
                if(find(i,parent)==i){
                    count++;
            }
        }
        return count;
    }
    public void Union(int u,int v,int[] parent,int[] rank ){
        int ul_pr_u=find(u,parent);//ultimate parent of u
        int ul_pr_v=find(v,parent);// ultimate parent of v

        if(rank[ul_pr_v]>rank[ul_pr_u]){
            parent[ul_pr_u]=ul_pr_v;
        }
        else if(rank[ul_pr_u]>rank[ul_pr_v]){
            parent[ul_pr_v]=ul_pr_u;
        }
        else{
            parent[ul_pr_v]=ul_pr_u;
            rank[ul_pr_u]++;
        }
    }
    public int find(int x,int[] parent){
        if(parent[x]==x) return x;

        return parent[x]=find(parent[x],parent);
    }
}