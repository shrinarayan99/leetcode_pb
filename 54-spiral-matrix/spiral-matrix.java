class Solution {
    List<Integer> ans;
    public List<Integer> spiralOrder(int[][] matrix) {
        ans=new ArrayList<>();
        sol(matrix,0,matrix.length-1,0,matrix[0].length-1);
        return ans;
    }
    public void sol(int[][] matrix,int start_row,int end_row,int start_col,int end_col){
        if(start_row>end_row ||start_col> end_col) return;
        for(int i=start_col;i<=end_col;i++){
            ans.add(matrix[start_row][i]);
        }
        for(int i=start_row+1;i<=end_row;i++){
            ans.add(matrix[i][end_col]);
        }
        // if last row remain then it will give duplicacy
        if (start_row != end_row){
            for(int i=end_col-1;i>=start_col;i--){
                ans.add(matrix[end_row][i]);

            }
        }
        // left column
        if (start_col != end_col) {
            for (int i = end_row - 1; i > start_row; i--) {
                ans.add(matrix[i][start_col]);
            }
        }

        sol(matrix,start_row+1,end_row-1,start_col+1,end_col-1);
    }
}
