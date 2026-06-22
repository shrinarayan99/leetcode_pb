class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] arr=new int[26];
        for(char c:text.toCharArray()){
            arr[c-'a']++;
        }
        
        int b=arr['b'-'a']/1;
        int a=arr['a'-'a']/1;
        int l=arr['l'-'a']/2;
        int o=arr['o'-'a']/2;
        int n=arr['n'-'a']/1;

        return Math.min(b,Math.min(a,Math.min(l,Math.min(o,n))));
    }
}