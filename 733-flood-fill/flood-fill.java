class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        int num=image[sr][sc];
        dfs(image,sr,sc,num,color,m,n);
        return image;
    }
    public void dfs(int[][] image,int sr,int sc,int num,int color,int m,int n){
        if(sc<0 || sc>=n || sr<0 || sr>=m || image[sr][sc]!=num || image[sr][sc]==color) return;

        
        image[sr][sc]=color;
        dfs(image,sr+1,sc,num,color,m,n);
        dfs(image,sr-1,sc,num,color,m,n);
        dfs(image,sr,sc+1,num,color,m,n);
        dfs(image,sr,sc-1,num,color,m,n);
    }
}