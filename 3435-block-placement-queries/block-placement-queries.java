class Solution {

    // segTree_left[pos] = pos se just previous obstacle tak ka gap
    // aur segment tree me range ka maximum gap store hoga
    public int[] segTree_left;

    public TreeSet<Integer> set;

    public List<Boolean> getResults(int[][] queries) {

        int max = Integer.MIN_VALUE;
        List<Boolean> ans = new ArrayList<>();

        // maximum coordinate nikal rhe h taki segment tree ka size decide kr ske
        for(int[] q : queries){
            max = Math.max(max, q[1]);
        }

        // maan liya ki 0 par hamesha ek obstacle h
        // isse first gap handle krna easy ho jata h
        set = new TreeSet<>();
        set.add(0);

        segTree_left = new int[4 * (max + 1)];

        for(int[] q : queries){

            // obstacle insert
            if(q[0] == 1){

                set.add(q[1]);

                // naye obstacle ka gap update kro
                // gap = currentObstacle - previousObstacle
                update_left(0, 0, max, q[1]);

                // next obstacle ka gap bhi change ho skta h
                // kyuki ab uska previous obstacle change ho gya
                Integer next = set.higher(q[1]);

                if(next != null){
                    update_left(0, 0, max, next);
                }
            }
            else{

                // [0,x] ke andar kisi obstacle par end hone wala
                // maximum complete gap nikal rhe h
                int canPlace = find(0, 0, max, 0, q[1]);

                // x se just previous obstacle
                Integer prev = set.floor(q[1]);

                // last partial segment bhi consider krna padega
                // example:
                // obstacles = {0,3}
                // x = 10
                // to last gap = 10-3 = 7
                canPlace = Math.max(canPlace, q[1] - prev);

                ans.add(canPlace >= q[2]);
            }
        }

        return ans;
    }

    public void update_left(int idx,int left,int right,int i){

        // leaf node => exact obstacle position mil gyi
        if(left == right){

            // current obstacle se previous obstacle tak ka gap
            segTree_left[idx] = i - set.lower(i);
            return;
        }

        int mid = left + (right - left) / 2;

        // normal point update
        if(i <= mid){
            update_left(2 * idx + 1, left, mid, i);
        }
        else{
            update_left(2 * idx + 2, mid + 1, right, i);
        }

        // parent me dono children ka maximum gap store kro
        segTree_left[idx] =
            Math.max(segTree_left[2 * idx + 1],
                     segTree_left[2 * idx + 2]);
    }

    public int find(int idx,int left,int right,int ql,int qr){

        // no overlap
        if(ql > right || qr < left){
            return 0;
        }

        // complete overlap
        if(ql <= left && right <= qr){
            return segTree_left[idx];
        }

        int mid = left + (right - left) / 2;

        int l = find(2 * idx + 1, left, mid, ql, qr);
        int r = find(2 * idx + 2, mid + 1, right, ql, qr);

        // range me maximum gap return kro
        return Math.max(l, r);
    }
}


//Brte force

// class Solution {
//     public List<Boolean> getResults(int[][] queries) {
//         int max = Integer.MIN_VALUE;
//         List<Boolean> ans = new ArrayList<>();

//         for (int[] q : queries) {
//             max = Math.max(max, q[1]);
//         }

//         boolean[] mark = new boolean[max + 1];
//         Arrays.fill(mark, true);

//         for (int[] q : queries) {
//             if (q[0] == 1) {
//                 mark[q[1]] = false;
//             } else {
//                 int lastObstacle = 0;
//                 boolean placed = false;

//                 for (int i = 1; i <= q[1]; i++) {
//                     if (!mark[i]) {
//                         if (i - lastObstacle >= q[2]) {
//                             placed = true;
//                             break;
//                         }
//                         lastObstacle = i;
//                     }
//                 }

//                 if (!placed && q[1] - lastObstacle >= q[2]) {
//                     placed = true;
//                 }

//                 ans.add(placed);
//             }
//         }

//         return ans;
//     }
// }