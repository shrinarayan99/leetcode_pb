import java.math.BigInteger;
class Solution {
    public int numSteps(String s) {
        int count=0;
        BigInteger num=new BigInteger(s,2);

         BigInteger one = BigInteger.ONE;//1
        BigInteger two = BigInteger.TWO;//2
        while(!num.equals(one)){
            if(num.mod(two).equals(BigInteger.ZERO)){
                num=num.divide(two);
            }
            else{
                num=num.add(one);
            }
            count++;
        }
        return count;
    }
}