class Solution {
    public int largestAltitude(int[] gain) {
        int n=gain.length;
        int current_height=0;
        int max_Height=0;
        for(int i=0;i<n;i++){
            current_height+=gain[i];
            max_Height=Math.max(current_height,max_Height);
        }
        return max_Height;
    }
}