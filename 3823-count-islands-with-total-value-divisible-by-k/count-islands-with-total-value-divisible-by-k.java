class Solution {
    int[][] visited;
    public int countIslands(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;

        visited=new int[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0 && visited[i][j]==0){
                    long total=dfs(i,j,m,n,grid);
                    if(total%k==0) count++;
                }
            }
        }
        return count;
    }
    public long dfs(int i,int j,int m,int n,int[][] grid){
        if(i<0 || i>=m ||j<0 ||j>=n) return 0;
        if(grid[i][j]==0 || visited[i][j]==1) return 0;

        visited[i][j]=1;
        long up=dfs(i-1,j,m,n,grid);
        long down=dfs(i+1,j,m,n,grid);
        long left=dfs(i,j-1,m,n,grid);
        long right=dfs(i,j+1,m,n,grid);

        return grid[i][j]+up+down+left+right;
    }
}