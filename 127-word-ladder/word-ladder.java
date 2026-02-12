class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>(wordList);
        if(!set.contains(endWord) ) return 0;
        boolean[] visited=new boolean[wordList.size()];
        Queue<String> q=new LinkedList<>();
        q.add(beginWord);

        int level=1;
        while(!q.isEmpty()){
            int size=q.size();

            //for all string on one level
            for(int s=0;s<size;s++){
                String word=q.poll();

                if(word.equals(endWord))
                    return level;

                char[] arr=word.toCharArray();

                // by changing every letter of that string and find that wheater exists or not if exists then add in queue(means at that level you can go to that word) and remove from existing
                for(int i=0;i<arr.length;i++){
                    char c=arr[i];

                    for(char j='a' ; j<='z'; j++ ){
                        arr[i]=j;
                        String new_String=new String(arr);
                        if(set.contains(new_String)){
                            q.add(new_String);
                            set.remove(new_String);
                        }
                    }
                    arr[i]=c;
                }
            }
            level++;
        }
        return 0;
    }
}

/*

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord) ) return 0;
        if(wordList.size()==1) return 1;
        boolean[] visited=new boolean[wordList.size()];
        return sol(beginWord,0,endWord,visited,wordList,1);
    }
    public int sol(String src,int next,String endWord, boolean[] visited, List<String> wordList,int count){
        
    
        int min=Integer.MAX_VALUE;
        for(int i=0;i<wordList.size();i++){
            if(!visited[i] && check_Diff(src,wordList.get(i))){

                if(wordList.get(i).equals(endWord)) return count+1;

                visited[i] = true;

                int another = sol(wordList.get(i),i+1, endWord,visited, wordList, count+1);

                visited[i] = false;

                if(another != 0){
                    min = Math.min(min, another);
                }
           }
        }
        if(min==Integer.MAX_VALUE) return 0;
        return min;
       
    }
    public boolean check_Diff(String src , String next){
        int count_differ=0;
        for(int  i=0;i<src.length();i++){
            if(src.charAt(i)!=next.charAt(i)){
                count_differ++;
                if(count_differ>1) return false;
            }
        }
        return count_differ==1;
      
    }
}

*/