class Solution {
    
   
    public String reverseWords(String s) {
        String str=s;
        String[] arr=s.split(" ");
        int first=countVowel(arr[0]);
         for(int i=1;i<arr.length;i++){
             
             if(countVowel(arr[i])==first ){
                 arr[i]=reverse(arr[i]);
             }
         }
        String ans=String.join(" ",arr);
        return ans;
    }
    public int countVowel(String s){
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='e' ||s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u' ){
                count++;
            }
        }
        return count;
    }
    public String reverse(String s){
        char[] ch=s.toCharArray();
        int mid=s.length()/2;

        for(int i=0;i<mid;i++){
            char temp=ch[i];
            ch[i]=ch[ch.length-1-i];
            ch[ch.length-1-i]=temp;
        }

        return new String(ch);
    }
}