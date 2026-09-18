class Solution {
    public int addDigits(int num) {
        if(num<=9) return num;
        int n=0;
        while(num>0){
            int rem=num%10;
            n+=rem;
            num=num/10;
        }
        return addDigits(n);
    }
}