class Solution {
    public static int[] dir_X={0,0,-1,1};
    public static int[] dir_Y={-1,1,0,0};

    public int[][] colorGrid(int n, int m, int[][] sources) {
        int[][] color_grid=new int[n][m];

        int[][] dist=new int[n][m];

        for(int[] d:dist){
            Arrays.fill(d,Integer.MAX_VALUE);
        }
        Queue<int[]> q=new LinkedList<>();
        for(int[] val:sources){
            int i=val[0];
            int j=val[1];
            dist[i][j]=0;
            color_grid[i][j]=val[2];

            q.add(val);
        }

        while(!q.isEmpty()){
            int[] arr=q.poll();
            int x=arr[0];
            int y=arr[1];
            

            for(int i=0;i<4;i++){
                int nx=x+dir_X[i];
                int ny=y+dir_Y[i];
                if(nx<0 || ny<0 || nx>=n || ny>= m) continue;
                if(dist[nx][ny]> dist[x][y]+1){
                    dist[nx][ny]=dist[x][y]+1;
                    color_grid[nx][ny]=color_grid[x][y];
                    q.add(new int[] {nx,ny,color_grid[x][y]});
                }
                else if(dist[nx][ny]==dist[x][y]+1){
                    color_grid[nx][ny]=Math.max(color_grid[x][y],color_grid[nx][ny]);
                }
            }
        }
        return color_grid;
    }
}