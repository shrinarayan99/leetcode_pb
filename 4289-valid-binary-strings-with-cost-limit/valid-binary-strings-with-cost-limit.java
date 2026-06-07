class Solution {
    public List<String> generateValidStrings(int n, int k) {
        List<String> ans=new ArrayList<>();
        for(int i=0;i<(int)Math.pow(2,n);i++){
            String s = String.format("%" + n + "s",
              Integer.toBinaryString(i))
              .replace(' ','0');
            if(isValid(s,k)){
                ans.add(s);
            }
        }
        return ans;
    }
    public boolean isValid(String s,int k){
        int cost=0;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='1'&& s.charAt(i+1)=='1' || cost>k) return false;

            if(s.charAt(i)=='1') cost+=i;
        }
        if(s.charAt(s.length()-1)=='1') cost+=s.length()-1;

        if(cost>k) return false;
        return true;
    }
}