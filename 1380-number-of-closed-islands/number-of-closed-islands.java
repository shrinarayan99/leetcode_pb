class Solution {
    public int closedIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0 && !visited[i][j] && dfs(grid,visited,i,j,m,n)){
                    count++;
                }
            }
        }
        return count;
    }
    public boolean dfs(int[][] grid , boolean[][] visited,int i,int j,int m ,int n){
        if(i<0 || i>m-1 || j<0 || j>n-1) return false;
        if(visited[i][j] ) return true;
        if( grid[i][j]==1) return true;
        visited[i][j]=true;

        boolean up=dfs(grid,visited,i-1,j,m,n);
        boolean down=dfs(grid,visited,i+1,j,m,n);
        boolean left=dfs(grid,visited,i,j-1,m,n);
        boolean right=dfs(grid,visited,i,j+1,m,n);
        if(up && down && right && left) return true;
        return false;
    }
}