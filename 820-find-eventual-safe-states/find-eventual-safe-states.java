class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int nodes=graph.length;

        boolean[] visited=new boolean[nodes];
        boolean[] oneWay=new boolean[nodes];
        for(int i=0;i<nodes;i++){
            if(!visited[i]){
                sol(graph,visited,oneWay,i);
            }
        }
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nodes;i++){
            if(!oneWay[i]){
                list.add(i);
            }
        }
        return list;
    }
    public boolean sol(int[][] graph, boolean[] visited, boolean[] oneWay ,int i){
        visited[i]=true;
        oneWay[i]=true;

        for(int j=0;j<graph[i].length;j++){
            int next=graph[i][j];
            if(!visited[next]){
                if(sol(graph,visited,oneWay,graph[i][j])){
                    return true;
                }
            }
            else if(oneWay[next]){
                return true;
            }
        }
        oneWay[i]=false;
        return false;
    }
}