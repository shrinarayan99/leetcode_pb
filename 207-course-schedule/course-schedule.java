class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<prerequisites.length;i++){
            int u= prerequisites[i][0];
            int v= prerequisites[i][1];
            // first visit b1 then a1 thats why
            graph[v].add(u);
        }
        boolean[] visited=new boolean[numCourses];
        boolean[] oneWay=new boolean[numCourses];

        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(check(graph,visited,oneWay,i)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean check(List<Integer>[] graph,boolean[] visited,boolean[] oneWay,int src){
        visited[src]=true;
        oneWay[src]=true;

        for(int i=0;i<graph[src].size();i++){
            int val=graph[src].get(i);
            if(!visited[val]){
                if(check(graph,visited,oneWay,val)){
                    return true;
                }
            }
            else if(oneWay[val]){
                return true;
            }
        }
        oneWay[src]=false;
        return false;
    }
}