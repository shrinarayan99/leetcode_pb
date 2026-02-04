class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (n==1 || source== destination) return true;
        int m=edges.length;
        ArrayList<Integer>[] arr=new ArrayList[n];
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            arr[u].add(v);
            arr[v].add(u);
        }
        return check(arr,source,destination,visited);
    }
    public boolean check(ArrayList<Integer>[] arr,int source ,int destination,boolean[] visited){
        if(arr[source].contains(destination)) return true;
        visited[source]=true;
        for(int i=0;i<arr[source].size();i++){
            int curr=arr[source].get(i);
            if(!visited[curr]){
                if(check(arr,curr,destination,visited)){
                    return true;
                }
            }
        }
        return false;
    }
}

/*Adjency Matrix( gives MLE)


class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (n==1 || source== destination) return true;
        int m=edges.length;
        int[][] matrix=new int[n][n];

        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];

            matrix[u][v]=1;
            matrix[v][u]=1;
        }
        boolean[] visited=new boolean[n];
        return check(n,matrix,source,destination,visited);
    }
    public boolean check(int n,int[][] matrix,int source,int destiny,boolean[] visited){
        if(matrix[source][destiny]==1) return true;
        visited[source]=true;
        for(int i=0;i<n;i++){
            if(matrix[source][i]==1 && !visited[i]){
                boolean take=check(n,matrix,i,destiny,visited);
                if(take){
                    return true; 
                }
            }
        }
        return false;
    }
}

*/