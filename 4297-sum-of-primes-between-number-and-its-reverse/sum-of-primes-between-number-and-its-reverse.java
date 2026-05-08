class Solution {
    public int sumOfPrimesInRange(int n) {
        int num=0;
        int a=n;
        while(a>0){
            int rem=a%10;
            num=num*10+rem;
            a=a/10;
        }

        int min=Math.min(n,num);
        int max=Math.max(n,num);
        int sum=0;
        for(int i=min;i<=max;i++){
            if(isPrime(i)){
                sum+=i;
            }
        }
        return sum;
    }
    static boolean isPrime(int num) {

        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}