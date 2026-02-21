class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] visited=new boolean[n];
        visited[0]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int idx=q.poll();

            for(int val:rooms.get(idx)){
                if(visited[val]) continue;

                visited[val]=true;
                q.add(val);
            }
        }

        for(int i=0;i<n;i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
}

/* hum isme line se khol rhe h index ke base pe (but hum kisi ko bhi kisi order me khol sakte hai);

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> set=new HashSet<>();
        for(int val:rooms.get(0)){
            set.add(val);
        }

        for(int i=1;i<rooms.size();i++){
            if(rooms.get(i).size()==0) continue;
            if(set.contains(i)){
                for(int val:rooms.get(i)){
                    set.add(val);
                }
            }
            else{
                return false;
            }
        }
        return true;
    }
}

*/