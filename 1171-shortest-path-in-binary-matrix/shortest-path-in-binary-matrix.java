class Solution {
    public static int[] dir_X={-1,1,0,0,-1,-1,1,1};
    public static int[] dir_Y={0,0,-1,1,-1,1,-1,1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;

        if(grid[0][0]==1) return -1;

        boolean[][] visited=new boolean[n][n];

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[] {0,0});
        visited[0][0]=true;
        int level=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int j=0;j<size;j++){
                int[] arr=q.poll();
                
                int x=arr[0];
                int y=arr[1];
                if(x==n-1 && y==n-1) return level;
                for(int i=0;i<8;i++){
                    int nx=x+dir_X[i];
                    int ny=y+dir_Y[i];
                    
                    if(nx<0 || ny<0 || nx>=n || ny>=n || grid[nx][ny]==1 || visited[nx][ny]) continue;

                    visited[nx][ny]=true;
                    
                    q.add(new int[] {nx,ny});
                }
            }

            level++;
        }
        if(!visited[n-1][n-1]) return -1;
        return level;
    }
}