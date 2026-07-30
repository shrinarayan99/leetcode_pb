class Solution {
    public int minimumPushes(String word) {
        int[] arr=new int[26];
        for(int i=0;i<word.length();i++){
            arr[word.charAt(i)-'a']++;
        }

        int count=0;
        for(int val:arr){
            if(val!=0)count++;
        }

        if(count<=8) return count;
        int ans=0;
        int pair=count/8;
        int extra=count%8;
        int i=1;
        while(pair>0){
            ans+=(8*i);
            pair--;
            i++;
        }

        ans+=(extra*i);

        return ans;
    }
}