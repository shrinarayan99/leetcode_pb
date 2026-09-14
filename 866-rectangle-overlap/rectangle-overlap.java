class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if(!check(rec1,rec2) ) return false;
        return true;
    }
    public boolean check(int[] r1,int[] r2){
        // right || bottom || left || top     (if completely outside or on boundary)
        if(r2[0]>=r1[2] ||  r2[3]<=r1[1] || r2[2]<=r1[0] || r2[1]>=r1[3]) return false;
        return true;
    }
}