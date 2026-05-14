class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            if(!row_check(board,i)) return false;
            if(!col_check(board,i)) return false;

        }
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                if(!box_check(board,i,j)) return false;
            }
            
        }
        return true;
    }
    public boolean row_check(char[][] board,int row){
        boolean[] exists= new boolean[10];
        for(int i=0;i<9;i++){
            if (board[row][i] == '.') continue;
            if(exists[board[row][i]-'0']) return false;
            exists[board[row][i]-'0']=true;
        }
        return true;
    }
    public boolean col_check(char[][] board,int col){
        boolean[] exists= new boolean[10];
        for(int i=0;i<9;i++){
            if (board[i][col] == '.') continue;
            if(exists[board[i][col]-'0']) return false;
            exists[board[i][col]-'0']=true;
        }
        return true;
    }
    public boolean box_check(char[][] board,int row,int col){
        boolean[] exists= new boolean[10];
        row=(row/3)*3;
        col=(col/3)*3;
        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                if (board[i][j] == '.') continue;
                if(exists[board[i][j]-'0']) return false;
                exists[board[i][j]-'0']=true;
            }
        }
        return true;
    }

}