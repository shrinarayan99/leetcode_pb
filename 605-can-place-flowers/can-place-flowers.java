class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0) return true;
        if(flowerbed.length==1){
            if(flowerbed[0]!=0) return false;
            if(n>1) return false;
            return true;
        }
        int canPlant=0;

        for(int i=0;i<flowerbed.length;i++){
            if(i==0 && flowerbed[i]==0 && flowerbed[i+1]!=1 ){
                canPlant++;
                flowerbed[i]=1;
            }
            else if(i==flowerbed.length-1 && flowerbed[i]==0 && flowerbed[i-1]!=1){
                canPlant++;
                flowerbed[i]=1;
            }
            else if(i > 0 && i < flowerbed.length-1 &&flowerbed[i]==0 && flowerbed[i-1]!=1 && flowerbed[i+1]!=1){
                canPlant++;
                flowerbed[i]=1;
            }
        }
        return canPlant>=n;
    }
}