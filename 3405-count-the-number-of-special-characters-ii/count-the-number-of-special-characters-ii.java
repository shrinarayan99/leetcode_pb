class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] small=new boolean[26];
        boolean[] capital=new boolean[26];
        boolean[] afterCapital=new boolean[26];
        
        for(char ch:word.toCharArray()){
            if(ch>='a' && ch<='z'){
                if(capital[ch-'a']){
                    afterCapital[ch-'a']=true;
                }
                else{
                    small[ch-'a']=true;
                }
            }
            else{
                capital[ch-'A']=true;
            }
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(small[i] && capital[i] && !afterCapital[i]){
                count++;
            }
        }
        return count;
    }
}