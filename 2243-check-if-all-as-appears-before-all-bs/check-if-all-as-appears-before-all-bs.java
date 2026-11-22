class Solution {
    public boolean checkString(String s) {
        boolean appear=false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a' && appear) return false;
            else if(s.charAt(i)=='b') appear=true;
        }
        return true;
    }
}