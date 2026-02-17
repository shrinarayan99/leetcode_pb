class Solution {
    public static int[] dir_X={-1,1,0,0};
    public static int[] dir_Y={0,0,-1,1};
    public int minimumEffortPath(int[][] heights) {
        int row=heights.length;
        int col=heights[0].length;

        int[][] distance=new int[row][col];
        for(int i=0;i<row;i++){
            Arrays.fill(distance[i],Integer.MAX_VALUE);
        }
        distance[0][0]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        // (time,x,y)
        pq.add(new int[] {0,0,0});

        while(!pq.isEmpty()){
            int[] arr=pq.poll();
            int time=arr[0];
            int x=arr[1];
            int y=arr[2];
            if(time >distance[x][y]) continue;
            for(int i=0;i<4;i++){
                int nx=x+dir_X[i];
                int ny=y+dir_Y[i];
                if(nx<0 || ny<0 || nx>=row || ny>=col) continue;
                int w=Math.abs(heights[nx][ny]-heights[x][y]);

                int d=Math.max(time,w);

                if(d<distance[nx][ny]){
                    distance[nx][ny]=d;
                    pq.add(new int[] {d,nx,ny});
                }

                
            }

        }
        return distance[row-1][col-1];
    }
}