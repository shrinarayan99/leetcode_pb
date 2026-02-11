class Solution {
    public static int[] dir_X={-1,1,0,0};
    public static int[] dir_Y={0,0,-1,1};
    public int shortestBridge(int[][] grid) {
        int n=grid.length;

        boolean[][] visited=new boolean[n][n];
        int[][] dp=new int[n][n];
        
        boolean found=false;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    dfs(grid,visited,dp,q,i,j,n);
                    found=true;
                    break;
                }
            }
            if(found) break;
        }
        int ans=0;
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int i=arr[0];
            int j=arr[1];
            ans=fill_dp(grid,dp,visited,q,i,j,n);
            if(ans!=-1) return ans;
        }
        return -1;
    }

    public int fill_dp(int[][]grid, int[][] dp, boolean[][] visited,Queue<int[]> q,int src_x,int src_y,int n){
        

        for(int i=0;i<4;i++){
            int x=src_x+dir_X[i];
            int y=src_y+dir_Y[i];

            if(x<0 || x>n-1||y<0 || y>n-1) continue;
            if(grid[x][y]==1 && !visited[x][y]){
                return dp[src_x][src_y];
            }
            if(!visited[x][y]){
                visited[x][y]=true;
                dp[x][y]=dp[src_x][src_y]+1;
                q.add(new int[] {x,y});
            }
        }
        return -1;
    }
    public void dfs(int[][] grid,boolean[][] visited,int[][] dp,Queue<int[]> q,int src_x,int src_y,int n){
        if(src_x<0 || src_x>n-1||src_y<0 || src_y>n-1|| visited[src_x][src_y] || grid[src_x][src_y]==0) return;

        visited[src_x][src_y]=true;
        q.add(new int[] {src_x,src_y});
        dp[src_x][src_y] = 0;
        dfs(grid,visited,dp,q,src_x+1,src_y,n);
        dfs(grid,visited,dp,q,src_x-1,src_y,n);
        dfs(grid,visited,dp,q,src_x,src_y-1,n);
        dfs(grid,visited,dp,q,src_x,src_y+1,n);
    }
}