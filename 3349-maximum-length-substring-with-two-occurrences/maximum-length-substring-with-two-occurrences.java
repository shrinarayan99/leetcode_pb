class Solution {
    public int maximumLengthSubstring(String s) {
        int[] arr=new int[26];
        int ans=0;
        int max=0;
        int j=0;
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;

            max=Math.max(max,arr[s.charAt(i)-'a']);

            if(max>2){
                ans=Math.max(i-j,ans);
                while(max>2){
                    if(arr[s.charAt(j)-'a']==max){
                        arr[s.charAt(j)-'a']--;
                        max=arr[s.charAt(j)-'a'];
                    }
                    else{
                        arr[s.charAt(j)-'a']--;
                    }
                    j++;
                }
            }
            else{
                ans=Math.max(i-j+1,ans);
            }
            
        }
        return ans;
    }
}