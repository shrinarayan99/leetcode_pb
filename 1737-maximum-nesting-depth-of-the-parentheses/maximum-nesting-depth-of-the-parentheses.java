class Solution {
    public int maxDepth(String s) {
        Stack<Character> st=new Stack<>();
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(s.charAt(i));
                ans=Math.max(ans,st.size());
            }
            else if(s.charAt(i)==')'){
                st.pop();
            }
        }
        return ans;
    }
}