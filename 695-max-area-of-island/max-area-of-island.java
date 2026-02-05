class Solution {
    public int maxAreaOfIsland(int[][] grid) {
    int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    ans=Math.max(ans,dfs(i,j,grid,visited,n,m));
                }
            }
        }
        return ans;
    }
    public int dfs(int i,int j,int[][] grid, boolean[][] visited,int n,int m){
        if(i<0||i>=n||j<0||j>=m) return 0;
        int up=0;
        int down=0;
        int left=0;
        int right=0;
        if(visited[i][j]==true){
            return 0;
        }
       
        else{
            visited[i][j]=true;
            
            if( i!=0 && grid[i-1][j]==1 ){
                up=dfs(i-1,j,grid,visited,n,m);
            }
           
            if(i!=n-1 && grid[i+1][j]==1 ){
                down=dfs(i+1,j,grid,visited,n,m);
            }
            
            if(j!=0 && grid[i][j-1]==1){
                left=dfs(i,j-1,grid,visited,n,m);
            }
            
            if(j!=m-1 && grid[i][j+1]==1){
                right=dfs(i,j+1,grid,visited,n,m);
            }
        }
        int ans=up+down+left+right;
        if(ans==0){
            return 1;
        }
        return ans+1;
    }
}