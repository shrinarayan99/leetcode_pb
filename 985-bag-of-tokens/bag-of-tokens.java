class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score=0,ans=0;
        // can not play because not have enough power and score to play wither of game
        if(tokens.length==0||tokens[0]>power) return 0;

        

        int i=0;// for tracing game_1(incresing score greedly)
        int j=tokens.length-1;// if power is not enough(increase max power with less score loose);

        while(i<=j){
            if(power>=tokens[i]){
                power-=tokens[i];
                score++;
                i++;
                ans=Math.max(ans,score);
                
            }
            else if(score>0){
                power+=tokens[j];
                score--;
                j--;
            }
            else{
                break;
            }
        }
        return ans;

    }
}