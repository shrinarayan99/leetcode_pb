class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int col=mat[0].length;
        int row=mat.length;
        if(k%col==0) return true;
        int req=k%col;
        int[][] com=new int[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i%2==0){
                    com[i][j]=mat[i][(j+req)%col];
                }
                else{
                     com[i][j]=mat[i][(col+j-req)%col];
                }
            }
        }
        if(Arrays.deepEquals(mat, com)){
            return true;
        }
        return false;
    }
}