class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[] row=new boolean[matrix.length];
        boolean[] col=new boolean[matrix[0].length];
        Queue<int[]> q=new LinkedList<>();
        for(int  i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    
                    q.add(new int[] {i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int i=curr[0];
            int j=curr[1];

            if(!row[i]){
                for(int k=0;k<matrix[0].length;k++){
                    matrix[i][k]=0;
                }
                row[i]=true;
            }
            if(!col[j]){
                for(int k=0;k<matrix.length;k++){
                    matrix[k][j]=0;
                }
                col[j]=true;
            }
        }
    }
}