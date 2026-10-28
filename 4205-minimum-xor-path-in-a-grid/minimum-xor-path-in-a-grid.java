class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][][] dp = new boolean[m][n][1024];

        dp[0][0][grid[0][0]] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                int val = grid[i][j];

                // From left
                if (j > 0) {
                    for (int x = 0; x < 1024; x++) {
                        if (dp[i][j - 1][x]) {
                            dp[i][j][x ^ val] = true;
                        }
                    }
                }

                // From above
                if (i > 0) {
                    for (int x = 0; x < 1024; x++) {
                        if (dp[i - 1][j][x]) {
                            dp[i][j][x ^ val] = true;
                        }
                    }
                }
            }
        }

        for (int x = 0; x < 1024; x++) {
            if (dp[m - 1][n - 1][x]) {
                return x;
            }
        }

        return -1;
    }
}

// TLE



/*
class Solution {
    public int minCost(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

      List<Integer>[][] dp=new ArrayList[m][n];

        
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            dp[i][j]=new ArrayList<>();
        }
       }
        dp[0][0].add(grid[0][0]);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //right
                if(j>0){
                    
                    for(int val:dp[i][j-1]){
                        dp[i][j].add(val^grid[i][j]);
                    }
                    
                }
                //down
                if(i>0){
                    for(int val:dp[i-1][j]){
                        dp[i][j].add(val^grid[i][j]);
                    }
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for(int val:dp[m-1][n-1]){
            min=Math.min(min,val);
        }
        return min;
    }
}
*/