class Solution {
    public int snakesAndLadders(int[][] board) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=board.length;
        // indexing ki jagah har index ko num bna ke uski value le li hai(sirf ladder and snake ki)
        int num=1;
        // flag to mark ki row me kis side se mive krna h
        boolean left_to_right=true;
        for(int i=n-1;i>=0;i--){
            if(left_to_right){
                for(int j=0;j<n;j++){
                    if(board[i][j]!=-1){
                        map.put(num,board[i][j]);
                    }
                    num++;
                }
            }
            else{
                for(int j=n-1;j>=0;j--){
                    if(board[i][j]!=-1){
                        map.put(num,board[i][j]);
                    }
                    num++;
                }
            }
            left_to_right=!left_to_right;
        }
        int step=0;

        boolean[] visited=new boolean[n*n+1];
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        visited[1]=true;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int position=q.poll();
                if(position==n*n) return step;
                for(int i=1;i<=6;i++){
                    int canReach=position+i;
                    if(canReach>n*n) break;
                    
                    if(map.containsKey(canReach)){
                        //agar ladder y snake hai to curr position se baha tk pahuch sakte hai
                        canReach=map.get(canReach);
                    }
                    if(visited[canReach]) continue;
                    visited[canReach]=true;
                    q.add(canReach);
                }
            }
            step++;
        }
        return -1;
    }
}