class Solution {
    List<String> list;
    public List<String> removeInvalidParentheses(String s) {
        list=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        build(s,0,sb,0,0);
        int maxSize=0;
        for(String st:list){
            maxSize=Math.max(maxSize,st.length());
        }
        Set<String> ans=new HashSet<>();
        for(String st:list){
            if(st.length()==maxSize){
                ans.add(st);
            }
        }
        return new ArrayList<>(ans);
    }
    public void build(String s,int i,StringBuilder sb,int open,int close){
        if(i==s.length()){
            if(open==close){
                list.add(new String(sb));
            }
            return;
        }
        char ch=s.charAt(i);
        if(ch>='a' && ch<='z'){
            sb.append(ch);
            build(s,i+1,sb,open,close);
            sb.deleteCharAt(sb.length() - 1);
        }
        else if(ch=='('){
            open++;
            sb.append('(');
            build(s,i+1,sb,open,close);
            sb.deleteCharAt(sb.length()-1);
            open--;
            // removing
            build(s, i + 1, sb, open, close);
        }
        else{
            close++;
            if(close<=open){
                sb.append(')');
                build(s,i+1,sb,open,close);
                sb.deleteCharAt(sb.length()-1);
            }
            close--;
            //removing
             build(s,i+1,sb,open,close);
        }
    }
}