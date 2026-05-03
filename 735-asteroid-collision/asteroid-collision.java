class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<asteroids.length;i++){
            if(ans.size()==0){
                ans.add(asteroids[i]);
                continue;
            } 
            if(asteroids[i]>0) ans.add(asteroids[i]);
            else if(asteroids[i]<0){
                boolean checked=false;
                while(ans.size()>0 && ans.get(ans.size()-1)>0){
                    int last=ans.get(ans.size()-1);
                    // if last in same direction
                    if(last<0){
                        ans.add(asteroids[i]);
                        checked=true;
                        break;
                    }
                    // in opposite direction but having same value
                    else if(last==Math.abs(asteroids[i])){
                        ans.remove(ans.size()-1);
                        checked=true;
                        break;
                    }
                    // in opposite direction with different value
                    ///if +ve value is greter then -ve will be destroyed
                    else if(last>Math.abs(asteroids[i])){
                            checked=true;
                            break;
                        }
                    //is last value is smaller than current
                    else if(last<Math.abs(asteroids[i])){
                        ans.remove(ans.size()-1);
                    }
                
                }
                // if asteroid not added or destroid
                if(!checked){
                    ans.add(asteroids[i]);
                }
            }
        }
        int n=ans.size();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=ans.get(i);
        }
        return arr;
    }
}

