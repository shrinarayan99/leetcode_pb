class Solution {
    public int residuePrefixes(String s) {
        HashSet<Character> prefix=new HashSet<>();
        int ans=0;
        for(int i=0;i<s.length();i++){
            prefix.add(s.charAt(i));
            if(prefix.size()==(i+1)%3){
                ans++;
            }
        } 
        return ans;
    }
}

/* read prefix defination in queztion carefully

 if(!prefix.contains(s.charAt(i))){
                prefix.add(s.charAt(i));
                if(prefix.size()==prefix.size()%3){
                    ans=prefix.size();
                }
            }
 */           