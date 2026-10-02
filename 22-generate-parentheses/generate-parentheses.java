
class Solution {
    List<String> list;
    public List<String> generateParenthesis(int n) {
        list=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        generate(n,n,sb);
        return list;

    }
    public void generate(int opened,int closed,StringBuilder sb){
        if(opened>closed){
            return;
        }
        if(opened==0 && closed==0){
            list.add(new String(sb));
            return;
        }
        
       if(opened>0){
            sb.append('(');
            generate(opened-1,closed,sb);
            sb.deleteCharAt(sb.length()-1);
       }
        if(closed>0){
            sb.append(')');
            generate(opened,closed-1,sb);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}