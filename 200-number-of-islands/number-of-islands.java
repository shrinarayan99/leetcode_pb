class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    ans+=dfs(i,j,grid,visited,n,m);
                }
            }
        }
        return ans;
    }
    public int dfs(int i,int j,char[][] grid, boolean[][] visited,int n,int m){
        if(i<0||i>=n||j<0||j>=m) return 0;
        if(visited[i][j]==true){
            return 0;
        }
        else{
            visited[i][j]=true;
            int up=-1;
            if( i!=0 && grid[i-1][j]=='1' ){
                up=dfs(i-1,j,grid,visited,n,m);
            }
            int down=-1;
            if(i!=n-1 && grid[i+1][j]=='1' ){
                down=dfs(i+1,j,grid,visited,n,m);
            }
            int left=-1;
            if(j!=0 && grid[i][j-1]=='1'){
                left=dfs(i,j-1,grid,visited,n,m);
            }
            int right=-1;
            if(j!=m-1 && grid[i][j+1]=='1'){
                right=dfs(i,j+1,grid,visited,n,m);
            }
        }
        return 1;
    }
}