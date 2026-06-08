// tc=O(nlogk)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[0] - b[0]); // min heap

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {

            int num = e.getKey();
            int freq = e.getValue();

            pq.offer(new int[]{freq, num});
            //jaise hi k size se bada hoga to choote bale ko hta denge
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] ans = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            ans[i] = pq.poll()[1];
        }

        return ans;
    }
}




/*
// tc=O(nlogn)
// use max heap 


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int val:nums){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(b[0],a[0]));

        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            int key=e.getKey();
            int val=e.getValue();

            pq.add(new int[] {val,key});
        }

        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            int[] curr=pq.poll();
            ans[i]=curr[1];
        }
        return ans;
    }
}

*/