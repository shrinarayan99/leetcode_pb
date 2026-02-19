class Solution {
    public static int[] dir_X={-1,1,0,0};
    public static int[] dir_Y={0,0,-1,1};
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int row=grid.size();
        int col=grid.get(0).size();

        int[][] health_require=new int[row][col];

        for(int i=0;i<row;i++){
            Arrays.fill(health_require[i],Integer.MAX_VALUE);
        }
        health_require[0][0]=grid.get(0).get(0);

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        //(healthRequired,i,j)
        pq.add(new int[] {grid.get(0).get(0),0,0});

        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int heal=curr[0];
            int x=curr[1];
            int y=curr[2];

            if(health_require[x][y]<heal) continue;

            for(int i=0;i<4;i++){
                int nx=x+dir_X[i];
                int ny=y+dir_Y[i];

                if(nx<0 || ny<0 || nx>=row || ny>=col) continue;

                int heal_red=heal+grid.get(nx).get(ny);

                if(health_require[nx][ny]>heal_red){
                    health_require[nx][ny]=heal_red;
                    pq.add(new int[] {heal_red,nx,ny});
                }
            }
        }
        int dif=health-health_require[row-1][col-1];

        if(dif>0) return true;
        return false;
    }
}