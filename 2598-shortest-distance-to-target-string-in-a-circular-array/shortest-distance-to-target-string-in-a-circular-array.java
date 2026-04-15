class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        ArrayList<Integer> indeces=new ArrayList<>();

        for(int i=0;i<2*words.length;i++){
            if(words[i%words.length].equals(target)){
                indeces.add(i);
            }
        }
        if(indeces.size()==0) return -1;
        
        int ans=Integer.MAX_VALUE;

        for(int i=0;i<indeces.size();i++){
            ans=Math.min(ans,Math.abs(indeces.get(i)-startIndex));
            ans=Math.min(ans,Math.abs(indeces.get(i)-(startIndex + words.length)));

        }
        return ans;
    }
}