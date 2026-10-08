class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb=new StringBuilder();
        int j=0;
        int open=0;
        for(int i=0;i<s.length();i++){
           
            char ch=s.charAt(i);
            if(ch=='(') open++;
            else open--;

             if(open==0 && i!=0){
                sb.append(s.substring(j+1,i));
                j=i+1;
            }
        }
        return new String(sb);
    }
}