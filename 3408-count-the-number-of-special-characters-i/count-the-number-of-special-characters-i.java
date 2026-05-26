class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] small=new boolean[26];
        boolean[] big=new boolean[26];
        int count=0;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(ch>='a' && ch<='z'){
                small[ch-'a']=true;
            }
            else if(ch>='A' && ch<='Z'){
                big[ch-'A']=true;
            }

        }
        for(int i=0;i<26;i++){
            if(big[i] && small[i]) count++;
        }
        return count;
    }
}