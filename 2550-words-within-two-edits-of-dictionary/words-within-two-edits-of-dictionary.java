class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans=new ArrayList<>();
        
        for(String q:queries){
            for(String s:dictionary){
                int dif=0;
                for(int i=0;i<q.length();i++){
                    if(q.charAt(i)!=s.charAt(i)){
                        dif++;
                    }
                    if(dif>2) break;
                }
                if(dif<=2){
                    ans.add(q);
                    break;// will prevent duplicaccy
                }
            }
        }
        return ans;
    }
}