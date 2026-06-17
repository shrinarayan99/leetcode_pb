class Solution {
    public char processStr(String s, long k) {
       long l=0;

        for(char c:s.toCharArray()){
            if(c>='a'&& c<='z'){
                l++;
            }
            else if(c=='#'){
                l*=2;
            }
            else if(c=='*'){
                if(l>0){
                    l--;
                }
                
            }

            
        }

        if(k>=l) return '.';
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='*'){
                l++;
                //no change in k
            }
            else if(s.charAt(i)=='%'){
                //no change in l
                k=l-k-1;
            }
            else if(s.charAt(i)=='#'){
                l=l/2;
                if(k>=l){
                    k=k-l;
                }
            }
            else {
                l--;
            }


            if(k==l) return s.charAt(i);
        }
        return '.';
    }
}