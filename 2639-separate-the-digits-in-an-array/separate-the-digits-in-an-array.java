class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int val:nums){
            if(val>=0 && val<=9){
                list.add(val);
            }
            else{
                char[] ch=String.valueOf(val).toCharArray();
                for(char c:ch){
                    list.add(c-'0');
                }
            }
        }
        int[] ans=new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}