class Solution {
    public int maximum69Number (int num) {
        String n=String.valueOf(num);
        char[] c=n.toCharArray();
        for(int i=0;i<c.length;i++){
            if(c[i]=='6'){
                c[i]='9';
                break;
            }
        }
        return Integer.valueOf(new String(c));
    }
}