class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> set=new HashSet<>();
        for(int val:arr1){
            String A=String.valueOf(val);
            for(int i=0;i<=A.length();i++){
                set.add(A.substring(0,i));
            }
        }
        int ans=0;
        for(int val:arr2){
            String B=String.valueOf(val);
            for(int i=B.length();i>=0;i--){
                if(set.contains(B.substring(0,i))){
                    ans=Math.max(ans,i);
                }
            }     
        }
        return ans;
    }
}

/*

            class Solution {
                public int longestCommonPrefix(int[] arr1, int[] arr2) {
                    int ans=0;
                    for(int i=0;i<arr1.length;i++){
                        for(int j=0;j<arr2.length;j++){
                            ans=Math.max(ans,sol(arr1[i],arr2[j]));
                        }
                    }
                    return ans;
                }
                public int sol(int x,int y){
                    String A=String.valueOf(x);
                    String B=String.valueOf(y);
                    if(A.charAt(0)!=B.charAt(0)) return 0;
                    int count=0;
                    for(int i=0;i<Math.min(A.length(),B.length());i++){
                        if(A.charAt(i)!=B.charAt(i)) break;
                        count++;
                    }
                    return count;
                }
            }
*/
