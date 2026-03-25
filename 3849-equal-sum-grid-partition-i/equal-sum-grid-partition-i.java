class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;

        long[] rowSum=new long[row];
        for(int i=0;i<row;i++){
            for(int val:grid[i]){
                rowSum[i]+=val;
            }
        }
        long[] colSum=new long[col];
        for(int i=0;i<col;i++){
            for(int j=0;j<row;j++){
                colSum[i]+=grid[j][i];
            }
        }
        for(int i=1;i<row;i++){
            rowSum[i]+=rowSum[i-1];
        }
        for(int i=1;i<col;i++){
            colSum[i]+=colSum[i-1];
        }

        for(int i=0;i<row;i++){
            if(rowSum[i]==(rowSum[row-1]-rowSum[i])){
                return true;
            }
        }
        for(int i=0;i<col;i++){
            if(colSum[i]==(colSum[col-1]-colSum[i])){
                return true;
            }
        }
        return false;
    }
}