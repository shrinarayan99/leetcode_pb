class Solution {
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            if(grid[i][0]==1){
                dfs(grid,visited,i,0,m,n);
            }
            if(grid[i][n-1]==1){
                dfs(grid,visited,i,n-1,m,n);
            }
        }
        for(int j=0;j<n;j++){
            if(grid[0][j]==1){
                dfs(grid,visited,0,j,m,n);
            }
            if(grid[m-1][j]==1){
                dfs(grid,visited,m-1,j,m,n);
            }
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int[][] grid,boolean[][] visited, int i, int j, int m ,int n){
        if(i<0 || i>m-1 || j<0 || j>n-1) return;
        if(visited[i][j] || grid[i][j]!=1) return;
        visited[i][j]=true;
        //upward
        dfs(grid,visited,i-1,j,m,n);
        //downward
        dfs(grid,visited,i+1,j,m,n);
        // left
        dfs(grid,visited,i,j-1,m,n);
        //right
        dfs(grid,visited,i,j+1,m,n);
    }
}