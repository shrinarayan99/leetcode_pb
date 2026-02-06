class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        boolean[][] visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            if(board[i][0]=='O' && !visited[i][0]){
                    dfs(board,visited,i,0,m,n);
                
            }
            if(board[i][m-1]=='O' && !visited[i][m-1]){
                    dfs(board,visited,i,m-1,m,n);
                
            }
        }
        for(int i=0;i<m;i++){
            if(board[0][i]=='O'&& !visited[0][i]){
                    dfs(board,visited,0,i,m,n);

            }
            if(board[n-1][i]=='O' && !visited[n-1][i]){

                    dfs(board,visited,n-1,i,m,n);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && visited[i][j]==false){
                    board[i][j]='X';
                }
            }
        }

    }
    public void dfs(char[][] board,boolean[][] visited,int i,int j,int m,int n){
        if(i<0 || i>n-1 || j<0 || j>m-1) return;
        if(visited[i][j]==true || board[i][j]!='O') return;
        visited[i][j]=true;
        dfs(board,visited,i+1,j,m,n);
        dfs(board,visited,i-1,j,m,n);
        dfs(board,visited,i,j-1,m,n);
        dfs(board,visited,i,j+1,m,n);
        
    }
}