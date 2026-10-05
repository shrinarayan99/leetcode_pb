class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                st.push(0);
            } else {
                int inner = st.pop();
                int outer = st.pop();

                st.push(outer + Math.max(2 * inner, 1));
            }
        }

        return st.pop();
    }
}