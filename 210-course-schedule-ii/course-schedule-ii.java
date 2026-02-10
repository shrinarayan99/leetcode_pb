class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n=numCourses;

        ArrayList<Integer>[] list=new ArrayList[n];
        for(int i=0;i<n;i++){
            list[i]=new ArrayList<>();
        }
        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];
            list[v].add(u);
        }

        boolean[] visited=new boolean[n];
        boolean[] oneWay=new boolean[n];
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++){
            if(!visited[i]){
                if(bfs(list,visited,oneWay,st,i)){
                    return new int[]{};
                }
            }
        }
        int[] result=new int[n];
        int j=0;
        while(!st.isEmpty()){
            result[j]=st.pop();
            j++;
        }

        return result;

    }
    public boolean bfs(ArrayList<Integer>[] list,boolean[] visited,boolean[] oneWay,Stack<Integer> st,int src){
        visited[src]=true;
        oneWay[src]=true;

        for(int i=0;i<list[src].size();i++){
            int val=list[src].get(i);
            if(!visited[val]){
                if(bfs(list,visited,oneWay,st,val)){
                    return true;
                }
            }
            else if(oneWay[val]) return true;
        }
        oneWay[src]=false;
        st.push(src);
        return false;
    }
}