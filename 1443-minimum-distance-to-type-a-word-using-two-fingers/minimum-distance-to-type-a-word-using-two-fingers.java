class Solution {
    public static int[][][] dp;
    public int minimumDistance(String word) {
        dp=new int[word.length()][27][27];
        for(int[][] a:dp){
            for(int[] b:a){
                Arrays.fill(b,-1);
            }
        }

        return sol(word,0,26,26);//26----> no char used
    }
    public int sol(String word,int i,int finger1,int finger2 ){
        if(i>=word.length()) return 0;
        
        if(dp[i][finger1][finger2]!=-1) return dp[i][finger1][finger2];
        // coordinted of current character;
        int x=(word.charAt(i)-'A')/6;
        int y=(word.charAt(i)-'A')%6;

        // coordinted of finger1 character;
        int x1=finger1/6;
        int y1=finger1%6;

        // coordinted of finger2 character;
        int x2=finger2/6;
        int y2=finger2%6;
        
        // if no finger use
        if(finger1==26 && finger2==26){
            return sol(word,i+1,word.charAt(i)-'A',finger2);
        }

        int result=Integer.MAX_VALUE;

        // if finger 1 is used
        if(finger2==26){
            int use_f1=distance(x1,y1,x,y)+sol(word,i+1,word.charAt(i)-'A',finger2);

            int use_f2=sol(word,i+1,finger1,word.charAt(i)-'A');

            result=Math.min(use_f1,use_f2);
        }
        //if both finger used
        else{
            int use_f1=distance(x1,y1,x,y)+sol(word,i+1,word.charAt(i)-'A',finger2);

            int use_f2=distance(x2,y2,x,y)+sol(word,i+1,finger1,word.charAt(i)-'A');

            result=Math.min(use_f1,use_f2);
        }
        return dp[i][finger1][finger2]=result;
    }
    public int distance(int a,int b,int x,int y){
        int ans=Math.abs(a-x)+Math.abs(b-y);
        return ans;
    }
}