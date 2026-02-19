class Solution {
    public static int[] dir_X={-1,1,0,0};
    public static int[] dir_Y={0,0,-1,1};
    public int swimInWater(int[][] grid) {
        int n=grid.length;

        int[][] distance=new int[n][n];
        int[][] parent_X=new int[n][n];
        int[][] parent_Y=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(distance[i],Integer.MAX_VALUE);
        }
        distance[0][0]=0;
        parent_X[0][0]=-1;
        parent_Y[0][0]=-1;

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        //(cost,i,j);
        pq.add(new int[] {0,0,0});

        while(!pq.isEmpty()){
            int[] arr=pq.poll();
            int c=arr[0];
            int x=arr[1];
            int y=arr[2];

            if(c>distance[x][y]) continue;

            for(int i=0;i<4;i++){
                int nx=x+dir_X[i];
                int ny=y+dir_Y[i];
                if(nx<0 || ny<0 || nx>=n || ny>=n) continue;

                // int t=Math.abs(grid[x][y]-grid[nx][ny]);
                // int dis=c+t;
                int dis = Math.max(c, grid[nx][ny]);

                if(distance[nx][ny]>dis){
                    distance[nx][ny]=dis;
                    parent_X[nx][ny]=x;
                    parent_Y[nx][ny]=y;
                    pq.add(new int[] {dis,nx,ny});
                }
            }
        }
        
        int i=n-1;
        int j=n-1;
        int max=0;
        while(i!=-1 && j!=-1){
            max=Math.max(max,grid[i][j]);
            int pi=parent_X[i][j];
            int pj=parent_Y[i][j];
            i=pi;
            j=pj;
        }
        return max;
    }
}