class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> s1=new Stack<>();

        if(s.length()==0){
            return 0;
        }
        else{
            s1.push(s.charAt(0));

            for(int i=1;i<s.length();i++){
                if(s1.size()!=0&&s1.peek()=='(' && s.charAt(i)==')'){
                    s1.pop();
                }
                else{
                    s1.push(s.charAt(i));
                }
            }
        }
        return s1.size();
    }
}