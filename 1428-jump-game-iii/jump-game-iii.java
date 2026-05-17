class Solution {
    public static boolean[] visited;
    public boolean canReach(int[] arr, int start) {
        visited=new boolean[arr.length];
        return check(arr,start);
        
    }
    public boolean check(int[] arr,int i){
        if(i<0 || i>=arr.length) return false;
        if(visited[i]) return false;
        if(arr[i]==0) return true;

        visited[i]=true;

        boolean right=check(arr,i+arr[i]);
        boolean left=check(arr,i-arr[i]);

        return left||right;

    }
}