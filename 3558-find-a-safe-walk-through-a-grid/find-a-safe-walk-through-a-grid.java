class Solution {
    static int[] X={0,0,-1,1};
    static int[] Y={-1,1,0,0};
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m=grid.size();
        int n=grid.get(0).size();

        int[][] dp=new int[m][n];
        dp[0][0]=health-grid.get(0).get(0);
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->b[0]-a[0]);

        q.add(new int[] {health-grid.get(0).get(0),0,0});

        while(!q.isEmpty()){
            int[] curr=q.poll();
            int hel=curr[0];
            int x=curr[1];
            int y=curr[2];
            if(hel>0 && x==m-1 && y==n-1) return true;
            for(int i=0;i<4;i++){
                int nx=x+X[i];
                int ny=y+Y[i];

                if(nx<0 || ny<0 || nx>m-1 || ny>n-1) continue;

                int currHel=hel-grid.get(nx).get(ny);
                if(dp[nx][ny]<currHel){
                    dp[nx][ny]=currHel;
                    q.add(new int[] {currHel,nx,ny});
                }
            }
        }
        return false;
    }
}