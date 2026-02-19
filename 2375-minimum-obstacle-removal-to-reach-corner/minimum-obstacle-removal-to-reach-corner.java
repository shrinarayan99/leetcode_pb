class Solution {
    public int[] dir_X={-1,1,0,0};
    public int[] dir_Y={0,0,-1,1};
    public int minimumObstacles(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;

        int[][] min_obstacle_remove=new int[row][col];

        for(int i=0;i<row;i++){
            Arrays.fill(min_obstacle_remove[i],Integer.MAX_VALUE);
        }
        min_obstacle_remove[0][0]=grid[0][0];

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[] {grid[0][0],0,0});

        while(!pq.isEmpty()){
            int[] arr=pq.poll();
            int count=arr[0];
            int x=arr[1];
            int y=arr[2];

            if(min_obstacle_remove[x][y]<count) continue;

            for(int i=0;i<4;i++){
                int nx=x+dir_X[i];
                int ny=y+dir_Y[i];
                
                if(nx<0 || ny<0 || nx>=row ||  ny>=col) continue;

                int num=grid[nx][ny];

                int c=count+num;
                if(min_obstacle_remove[nx][ny]>c){
                    min_obstacle_remove[nx][ny]=c;
                    pq.add(new int[] {c,nx,ny});
                }
            }
            
        }
        return min_obstacle_remove[row-1][col-1];
    }
}