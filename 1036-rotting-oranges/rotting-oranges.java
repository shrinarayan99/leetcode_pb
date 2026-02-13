class Solution {
    public static int[] dir_X={-1,1,0,0};
    public static int[] dir_Y={0,0,-1,1};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();

        int m=grid.length;
        int n=grid[0].length;

        boolean[][]  visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[] {i,j,0});
                    visited[i][j]=true;
                }
            }
        }
        int time=0;
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int x=arr[0];
            int y=arr[1];
            time=arr[2];
            for(int i=0;i<4;i++){
                int nx=x+dir_X[i];
                int ny=y+dir_Y[i];

                if(nx<0 || nx>=m || ny<0 || ny>=n ||visited[nx][ny] || grid[nx][ny]==0) continue;

                visited[nx][ny]=true;
                q.add(new int[] {nx,ny,time+1});
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    return -1;
                }
            }
        }
        return time;
    }
}