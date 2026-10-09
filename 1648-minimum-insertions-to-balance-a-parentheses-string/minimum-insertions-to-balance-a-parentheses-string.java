class Solution {
    public int minInsertions(String s) {
        int requirement=0;
        int remainC=0;
        int open=0;

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(') open++;
            else if(ch==')'){
                // agar valid pair banta h to close ko kam kr do
                if(i!=s.length()-1 && s.charAt(i+1)==')'){
                    if(open==0){
                        requirement++;
                    }
                    else open--;
                    i++;
                }
                else if(open>0){
                    open--;
                    // sirf ik ki need h to open balance ho jaega
                    requirement++;
                }
                else{
                    // koi open nhi h iske liye to remain h ye close
                    remainC++;
                    // current me 1 present and ik ki or need h
                    requirement++;
                }
            }
        }
        // har remainig pair c ke liye ik open lagao
        requirement+=remainC;
        //har remain open ke liye pair of close lao
        requirement+=(open*2);
        return requirement;

    }
}