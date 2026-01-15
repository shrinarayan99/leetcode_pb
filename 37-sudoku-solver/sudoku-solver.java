//https://www.youtube.com/watch?v=5g6fheUtjRs

class Solution {
    public void solveSudoku(char[][] board) {
      solve(board);  
    }
    public boolean solve(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(int d=1;d<=9;d++){
                        char ch = (char)(d + '0');
                        if(isValid(board,i,j,ch)){
                            board[i][j]=ch;
                            if(solve(board)) return true;
                            board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValid(char[][] board,int row,int col,char d){
        for(int i=0;i<9;i++){
            if(board[row][i]==d) return false;
            if(board[i][col]==d) return false;
        }
        int Start_i=row/3*3;
        int Start_j=col/3*3;
        for(int k=0;k<3;k++){
            for(int l=0;l<3;l++){
                if(board[Start_i+k][Start_j+l]==d) return false;
            }
        }
        return true;
    }
}