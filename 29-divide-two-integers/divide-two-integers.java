class Solution {
    public int divide(int dividend, int divisor) {
        int count=0;
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        if(dividend==Integer.MAX_VALUE && divisor==-1){
            return Integer.MIN_VALUE+1;
        }    
        long a=Math.abs((long)dividend);
        long b=Math.abs((long)divisor);
        while(a>=b){
            
           a-=b;
            count++;
        }

        if(dividend<0 && divisor>0 || dividend>0 && divisor<0 ){
            count=0-count;
            
        }
        return count;
    }
}