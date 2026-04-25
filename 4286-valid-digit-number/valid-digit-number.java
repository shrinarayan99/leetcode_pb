class Solution {
    public boolean validDigit(int n, int x) {
       HashSet<Integer> map=new HashSet<>();
       int start=-1;
       while(n>0){
        if(n<=9){
            start=n;
        }
        int rem=n%10;
        map.add(rem);
        n=n/10;
       
       }
       if(start!=x && map.contains(x)) return true;
       return false;
    }
}