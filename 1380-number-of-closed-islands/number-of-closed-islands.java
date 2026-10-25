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
          // Water cell → safe side
        if(visited[i][j] ) return true;
        
        // Already visited land → safe
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

/*

class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            if(grid[i][0] == 0)
                solve(grid,i,0,m,n);
            if(grid[i][n-1] == 0)
                solve(grid,i,n-1,m,n);
        }
        for(int i=0;i<n;i++){
            if(grid[0][i] == 0)
                solve(grid,0,i,m,n);
            if(grid[m-1][i] == 0)
                solve(grid,m-1,i,m,n);
        }
        int count=0;
        for(int i=0;i<m-1;i++){
            for(int j=0;j<n-1;j++){
                if(grid[i][j] == 0){
                    count++;
                    solve(grid,i,j,m,n);
                }
            }
        }
        return count;
    }
    void solve(int[][] grid , int i , int j , int m , int n){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 1)
            return;
        grid[i][j] = 1;

        solve(grid , i+1 , j , m , n);
        solve(grid , i-1 , j , m , n);
        solve(grid , i , j+1 , m , n);
        solve(grid , i , j-1 , m , n);
    }
}

*/