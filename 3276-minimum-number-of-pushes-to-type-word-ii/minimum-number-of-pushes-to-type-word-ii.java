class Solution {
    public int minimumPushes(String word) {
        int[] arr=new int[26];
        for(int i=0;i<word.length();i++){
            arr[word.charAt(i)-'a']++;
        }

        // int count=0;
        // for(int val:arr){
        //     if(val!=0)count++;
        // }
        int ans=0;
        int c=0;
        int j=1;
        Arrays.sort(arr);
        for(int i=25;i>=0;i--){
            ans+=(j*arr[i]);
            c++;
            if(c%8==0){
                j++;
            }
        }
        return ans;
    }
}