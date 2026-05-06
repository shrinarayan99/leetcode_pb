class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int row=boxGrid.length;
        int col=boxGrid[0].length;
        char[][] ans=new char[col][row];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
               ans[j][row-1-i]=boxGrid[i][j];
            }
        }

        for(int i=0;i<row;i++){
            int k=col-1;
            for(int j=col-1;j>=0;j--){
                if(ans[j][i]=='*'){
                    k=j-1;
                    
                }
                else if(ans[j][i]=='#'){
                    char temp=ans[j][i];
                    ans[j][i]='.';
                    ans[k][i]=temp;
                    k--;
                }
                
            }
        }
        return ans;
    }
}