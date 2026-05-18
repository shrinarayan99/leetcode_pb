class Solution {
    HashMap<Integer, List<Integer>> map;
    boolean[] visited;
    public int minJumps(int[] arr) {
        map=new HashMap<>();
        visited=new boolean[arr.length];
        for(int i=0;i<arr.length;i++){
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[] {0,0});
        visited[0]=true;
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int idx=curr[0];
            int count=curr[1];
            if(idx==arr.length-1) return count;
            if(idx!=0 && !visited[idx-1]) {
                q.add(new int[] {idx-1,count+1});
                visited[idx-1]=true;
            }
            if(!visited[idx+1]) {
                visited[idx+1]=true;
                q.add(new int[] {idx+1,count+1});
            }
            if (!map.containsKey(arr[idx])) continue;
            for(int val:map.get(arr[idx])){
                if(visited[val]) continue;
                visited[val]=true;
                q.add(new int[] {val,count+1});
            }
            map.remove(arr[idx]);
        }
        return -1;
    }
}
/*TLE



                    class Solution {
                        HashMap<Integer, List<Integer>> map;
                        boolean[] visited;
                        public int minJumps(int[] arr) {
                            map=new HashMap<>();
                            visited=new boolean[arr.length];
                            for(int i=0;i<arr.length;i++){
                                map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
                            }
                            int ans = sol(arr, 0);

                            return ans == Integer.MAX_VALUE ? -1 : ans;
                        }
                        public int sol(int[] arr,int i){
                            if(i<0 || i>=arr.length) return Integer.MAX_VALUE;
                            if(i==arr.length-1) return 0;
                            visited[i]=true;
                            int same=Integer.MAX_VALUE;
                            List<Integer> list=map.get(arr[i]);
                            for(int idx:list){
                                if(idx!=i && !visited[idx]){
                                    int temp = sol(arr, idx);

                                    if (temp != Integer.MAX_VALUE) {
                                        same = Math.min(same, temp + 1);
                                    }

                                }
                            }
                            int prev=Integer.MAX_VALUE;
                            if(i!=0 && !visited[i-1]){
                                prev=sol(arr,i-1);
                                if(prev!=Integer.MAX_VALUE){
                                    prev+=1;
                                }
                            }
                            
                            int next=Integer.MAX_VALUE;
                            if(!visited[i+1]){
                                next=sol(arr,i+1);
                                if(next!=Integer.MAX_VALUE){ 
                                    next+=1;
                                }
                            }
                            visited[i]=false;
                        
                            return Math.min(prev,Math.min(next,same));
                        }
                    }

*/
        