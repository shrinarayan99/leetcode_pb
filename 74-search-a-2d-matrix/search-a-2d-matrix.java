class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0;
        int j=matrix.length-1;

        
        while(i<=j){
            int mid=i+(j-i)/2;

            if(matrix[mid][0]<=target && matrix[mid][matrix[0].length-1]>=target){
                return binarySearch(matrix,target,mid);
            }
            else if(target>matrix[mid][matrix[0].length-1]) i=mid+1;
            else j=mid-1;
        }
        return false;
    }
    public boolean binarySearch(int[][] matrix, int target,int row){
        int i=0;
        int j=matrix[row].length-1;

        while(i<=j){
            int mid=i+(j-i)/2;

            if(matrix[row][mid]==target) return true;
            else if(matrix[row][mid]<target) i=mid+1;
            else j=mid-1;
        }
        return false;
    }
}