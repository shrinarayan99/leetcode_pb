class Solution {
    public int[] dir_X={-1,1,0,0};
    public int[] dir_Y={0,0,-1,1};
    public int shortestPath(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;

        boolean[][][] visited=new boolean[m][n][k+1];
    
        
        Queue<int[]> q=new LinkedList<>();
        //(i,j,count_k,len);
        q.add(new int[] {0,0,k} );
        int ans=0;
        while(!q.isEmpty()){
            int size=q.size();
            
            for(int j=0;j<size;j++){
                int[] arr=q.poll();
                int x=arr[0];
                int y=arr[1];
                int k_count=arr[2];
                if(x==m-1 && y== n-1) return ans;
                for(int i=0;i<4;i++){
                    int nx=x+dir_X[i];
                    int ny=y+dir_Y[i];

                    if(nx<0 || ny<0 || nx>=m || ny>=n || visited[nx][ny][k_count]) continue;
                    visited[nx][ny][k_count]=true;
                    if(grid[nx][ny]==0){
                        q.add(new int[] {nx,ny,k_count});
                    }
                    else if(grid[nx][ny]==1 && k_count>0){
                        // remove
                     
                        q.add(new int[] {nx,ny,k_count-1});
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}