class Solution {
    List<String> list=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sb=new StringBuilder();
        sol(n,sb,0,0);
        return list;
    }
    public void sol(int n,StringBuilder sb,int open,int close){
        if(sb.length()==2*n){
            list.add(sb.toString());
            return;
        }
        if(open<n){
            sol(n,sb.append("("),open+1,close);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close<open){
            sol(n,sb.append(")"),open,close+1);
            sb.deleteCharAt(sb.length() - 1);
        }
        
    }
}