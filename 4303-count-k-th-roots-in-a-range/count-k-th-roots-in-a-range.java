class Solution {
    public int countKthRoots(int l, int r, int k) {
        if(k == 1) {
            return r - l + 1;
        }
        int count = 0;
        if(l == 0) {
            count++;
        }
        for(int x=1;(long)Math.pow(x, k) <= r;x++) {
            long power = (long)Math.round(Math.pow(x, k));
            if(power >= l && power <= r) {
                count++;
            }
        }
        return count;
    }
}



// class Solution {
//     public int countKthRoots(int l, int r, int k) {
//         int count=0;
//         for(int i=0; ;i++){
//             double val=Math.pow(i,k);
//             if(val>r) break;
//             else if(val>=l)count++;
//         }
//         return count;
//     }
// }