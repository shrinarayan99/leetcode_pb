class Solution {
    public int[] dir_X={-1,1,0,0};
    public int[] dir_Y={0,0,-1,1};


    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;

        boolean[][] pacific=new boolean[m][n];
        boolean[][] atlantic=new boolean[m][n];

        Queue<int[]> p_q=new LinkedList<>();
        Queue<int[]> a_q=new LinkedList<>();

        for(int i=0;i<m;i++){
            pacific[i][0]=true;
            p_q.add(new int[] {i,0});
            atlantic[i][n-1]=true;
            a_q.add(new int[] {i,n-1});
        }
        for(int i=0;i<n;i++){
            pacific[0][i]=true;
            p_q.add(new int[] {0,i});
            atlantic[m-1][i]=true;
            a_q.add(new int[] {m-1,i});
        }

        bfs(heights,p_q,pacific,m,n);
        bfs(heights,a_q,atlantic,m,n);

       
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               if(pacific[i][j] && atlantic[i][j]){
                List<Integer> ans=new ArrayList<>();
                ans.add(i);
                ans.add(j);
                list.add(ans);
               }
            }
        }
        return list;

    }
    public void bfs(int[][] heights,Queue<int[]> q,boolean[][] visited,int m,int n){
        while(!q.isEmpty()){
            int[] curr=q.poll();

            int x=curr[0];
            int y=curr[1];

            for(int i=0;i<4;i++){
                int nx=x+dir_X[i];
                int ny=y+dir_Y[i];

                if(nx<0 || ny<0 ||nx>=m ||ny>=n || visited[nx][ny] ) continue;

                if(heights[nx][ny]>=heights[x][y]){
                    visited[nx][ny]=true;
                    q.add(new int[] {nx,ny});
                }
            }
        }
    }
}