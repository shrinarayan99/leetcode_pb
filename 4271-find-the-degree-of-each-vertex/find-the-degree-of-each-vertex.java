class Solution {
    public int[] findDegrees(int[][] matrix) {
        int n=matrix.length;
        int[] inDegree=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==1){
                    inDegree[j]+=1;
                }
            }
        }
        return inDegree;
    }
}