class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> extraOpenBracket=new Stack<>();
        Stack<Integer> aestric=new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                extraOpenBracket.push(i);
            }
            else if(ch=='*'){
                aestric.push(i);
            }
            else{
                if(!extraOpenBracket.isEmpty()){
                    extraOpenBracket.pop();
                }
                else if(!aestric.isEmpty()){
                    aestric.pop();
                }
                else return false;
            }
            

        }
        while(!extraOpenBracket.isEmpty()){
                if(aestric.isEmpty()) return false;

                if(extraOpenBracket.pop()>aestric.pop()) return false;
        }
        return extraOpenBracket.isEmpty();
    }
}