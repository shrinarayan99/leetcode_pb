class Solution {
    public static int MOD=12345;
    public int[][] constructProductMatrix(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        
        int[][] p=new int[row][col];
        p[0][0]=1;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){

                if(i==0 && j==0) continue;

                if(i!=0 && j==0){
                    p[i][j]=(int)((long)grid[i-1][col-1]%MOD*p[i-1][col-1]%MOD)%MOD;
                }
                else {
                    p[i][j]=(int)((long)grid[i][j-1]%MOD*p[i][j-1]%MOD)%MOD;
                }                
            }
        }
        int[][] p1=new int[row][col];
        p1[row-1][col-1]=1;
        for(int i=row-1;i>=0;i--){
            for(int j=col-1;j>=0;j--){
                if(i==row-1 && j==col-1) continue;

                if(i!=row-1 && j==col-1){
                    p1[i][j]=(int)((long)grid[i+1][0]%MOD*p1[i+1][0]%MOD)%MOD;
                }
                else {
                    p1[i][j]=(int)((long)grid[i][j+1]%MOD*p1[i][j+1]%MOD)%MOD;
                }                
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                p[i][j]=(int)((long)p[i][j]%MOD * p1[i][j]%MOD)%MOD;                
            }
        }
        return p;
    }
}

/*

    class Solution {
    public static long MOD=12345;
    public int[][] constructProductMatrix(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        long sol=1;
        for(int i=0;i<row;i++){
            for(int val:grid[i]){
                sol*=val;
            }
        }
        int[][] p=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                p[i][j]=(int)((sol/(long)grid[i][j])%MOD);
            }
        }
        return p;
    }
}

*/