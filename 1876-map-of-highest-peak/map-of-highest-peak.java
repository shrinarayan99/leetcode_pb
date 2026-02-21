class Solution {
    public static int[] dir_X={-1,1,0,0};
    public static int[] dir_Y={0,0,-1,1};
    public int[][] highestPeak(int[][] isWater) {
        int m=isWater.length;
        int n=isWater[0].length;
        boolean[][] visited=new boolean[m][n];
        int[][] result=new int[m][n];

        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isWater[i][j]==1){
                    //make water land(height ==0 )  
                   visited[i][j]=true;
                    q.add(new int[] {i,j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] arr=q.poll();
            int x=arr[0];
            int y=arr[1];
            for(int i=0;i<4;i++){
                int nx=x+dir_X[i];
                int ny=y+dir_Y[i];

                if(nx<0 || ny<0 | nx>=m || ny>=n) continue;

            
                if(!visited[nx][ny]){
                    visited[nx][ny]=true;
                   result[nx][ny]=result[x][y]+1;
                   q.add(new int[] {nx,ny});
                }
                
            }
        }
        return result;
    }
}