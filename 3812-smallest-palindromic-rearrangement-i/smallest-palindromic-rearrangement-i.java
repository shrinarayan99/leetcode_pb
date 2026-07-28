class Solution {
    public String smallestPalindrome(String s) {
        if(s.length()==1)return s;

        int[] count=new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }

        StringBuilder sb=new StringBuilder();
        int odd=-1;

        for(int i=0;i<26;i++){
            if(count[i]%2!=0) odd=i;

            if(count[i]!=0 ){
                for(int j=0;j<count[i]/2;j++){
                    sb.append((char)('a'+i));
                }
            }
        }
        StringBuilder ans=new StringBuilder();
       
        ans.append(sb);
        if(odd!=-1){
            ans.append((char)('a'+odd));
            
        }

        ans.append(sb.reverse().toString());

        return ans.toString();
    }
}