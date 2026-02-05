class Solution {
    public int islandPerimeter(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    ans+=4;
                    if(i!=0 && grid[i-1][j]==1)ans--;
                    if(j!=0 && grid[i][j-1]==1)ans--;
                    if(i!=n-1 && grid[i+1][j]==1)ans--;
                    if(j!=m-1 && grid[i][j+1]==1)ans--;
                }
            }
        }
        return ans;
    }
}

/*

class Solution {
    public int islandPerimeter(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    ans=sol(i,j,grid,visited,m,n);
                }
            }
        }
        return ans;
    }
    public int sol(int i,int j,int[][] grid, boolean[][] visited,int m , int n){
        if(i>=n || i<0 || j>=m || j<0) return 1;
        if(grid[i][j] == 0) return 1;
        if(visited[i][j]==true) return 0;
        visited[i][j]=true;
        int up=sol(i-1,j,grid,visited,m,n);;
        int down=sol(i+1,j,grid,visited,m,n);;
        int left=sol(i,j-1,grid,visited,m,n);;
        int right=sol(i,j+1,grid,visited,m,n);;
        
        
        
        return up+down+right+left;
        
        
    }
}

*/