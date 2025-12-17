class Solution {
    public int uniquePathsIII(int[][] grid) {
        int count=0;
        int row=-1;
        int col=-1;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    count++;
                }
                if(grid[i][j]==1){
                    row=i;
                    col=j;
                }
            }
        }
        return sol(grid,row,col,count);
    }
    public int sol(int[][] grid,int i,int j,int count){
        if(grid[i][j]==2 && count==-1){
            return 1;
        }
        if(grid[i][j]==2 && count!=-1) {
            return 0;
        }

        int up=0;
        if(i-1>=0 && grid[i-1][j]!=Integer.MAX_VALUE && grid[i-1][j]!=-1 ){
            int x=grid[i][j];
            grid[i][j]=Integer.MAX_VALUE;
            up=sol(grid,i-1,j,count-1);
            grid[i][j]=x;
        }
        int down=0;
        if(i+1<=grid.length-1 && grid[i+1][j]!=Integer.MAX_VALUE && grid[i+1][j]!=-1){
            int x=grid[i][j];
            grid[i][j]=Integer.MAX_VALUE;
            down=sol(grid,i+1,j,count-1);
            grid[i][j]=x;
        
        }
        int left=0;
        if(j-1>=0 && grid[i][j-1]!=Integer.MAX_VALUE && grid[i][j-1]!=-1){
            int x=grid[i][j];
            grid[i][j]=Integer.MAX_VALUE;
            left=sol(grid,i,j-1,count-1);
            grid[i][j]=x;
        }
        int right=0;
        if(j+1<=grid[0].length-1 && grid[i][j+1]!=Integer.MAX_VALUE  && grid[i][j+1]!=-1){
            int x=grid[i][j];
            grid[i][j]=Integer.MAX_VALUE;
            right=sol(grid,i,j+1,count-1);
            grid[i][j]=x;
        }
        return up+down+left+right;
    }

}