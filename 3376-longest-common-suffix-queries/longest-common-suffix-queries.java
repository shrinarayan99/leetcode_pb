// trie (is also known as prefix tree) for optimal sol that can avoid making of substring again and again
class Solution {

    class Trie {

        Trie[] child = new Trie[26];

        int idx = -1;
    }

    Trie root = new Trie();

    public void insert(String s, int index, String[] wordsContainer) {

        Trie pointer = root;

        // root update
        if(pointer.idx == -1
        || wordsContainer[index].length() < wordsContainer[pointer.idx].length()
        || (wordsContainer[index].length() == wordsContainer[pointer.idx].length()
        && index < pointer.idx)) {

            pointer.idx = index;
        }

        for(int i = s.length() - 1; i >= 0; i--) {

            int ch = s.charAt(i) - 'a';

            if(pointer.child[ch] == null) {
                pointer.child[ch] = new Trie();
            }

            pointer = pointer.child[ch];

            // update best index
            if(pointer.idx == -1
            || wordsContainer[index].length() < wordsContainer[pointer.idx].length()
            || (wordsContainer[index].length() == wordsContainer[pointer.idx].length()
            && index < pointer.idx)) {

                pointer.idx = index;
            }
        }
    }

    public int search(String s) {

        Trie pointer = root;

        int ans = root.idx;

        for(int i = s.length() - 1; i >= 0; i--) {

            int ch = s.charAt(i) - 'a';

            if(pointer.child[ch] == null) {
                break;
            }

            pointer = pointer.child[ch];

            ans = pointer.idx;
        }

        return ans;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        for(int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i, wordsContainer);
        }

        int[] ans = new int[wordsQuery.length];

        for(int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
        }

        return ans;
    }
}







/*

// store the smaller length string index that we are finding after sorting in below code for every longest possible suffix;
//MLE(same problem of creating string suffix again and again);
// space is less as compare to below as we are only storing best index for every possible substring
// tc is approx same as below

class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        HashMap<String,Integer> map1=new HashMap<>();
        
        int min_Length_Index=0;

        for(int i=0;i<wordsContainer.length;i++){
            String s=wordsContainer[i];
            if(s.length()<wordsContainer[min_Length_Index].length()) min_Length_Index=i;
            for(int j=s.length()-1;j>=0;j--){
                String suffix=s.substring(j,s.length());
                if(!map1.containsKey(suffix)){
                    map1.put(suffix,i);
                }
                else{
                    int prev = map1.get(suffix);

                    if(wordsContainer[i].length() < wordsContainer[prev].length()
                    || (wordsContainer[i].length() == wordsContainer[prev].length()
                    && i < prev)) {

                        map1.put(suffix, i);
                    }
                }
            }
        }
        int[] ans=new int[wordsQuery.length];

        for(int i=0;i<wordsQuery.length;i++){
            String s=wordsQuery[i];
            boolean found=false;

            for(int j=0;j<s.length();j++){
                String suffix=s.substring(j,s.length());
                if(!map1.containsKey(suffix)) continue;
                found=true;
                ans[i]=map1.get(suffix);
                break;
            }
            if(!found) ans[i]=min_Length_Index;
        }
        return ans;
    }
}

*/


/* store every index for every suffix then sort it on the basis of that index string length
// MLE(because creating substring again and again)
//more tc as compare to avobe code




class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        HashMap<String,ArrayList<Integer>> map1=new HashMap<>();
        int min_Length_Index=0;

        for(int i=0;i<wordsContainer.length;i++){
            String s=wordsContainer[i];
            if(s.length()<wordsContainer[min_Length_Index].length()) min_Length_Index=i;
            for(int j=s.length()-1;j>=0;j--){
                String suffix=s.substring(j,s.length());
                if(!map1.containsKey(suffix)){
                    map1.put(suffix,new ArrayList<>());
                }
                map1.get(suffix).add(i);
            }
        }
        for(ArrayList<Integer> list:map1.values()){
            list.sort((a, b) -> wordsContainer[a].length() - wordsContainer[b].length());
        }
        int[] ans=new int[wordsQuery.length];

        for(int i=0;i<wordsQuery.length;i++){
            String s=wordsQuery[i];
            boolean found=false;

            for(int j=0;j<s.length();j++){
                String suffix=s.substring(j,s.length());
                if(!map1.containsKey(suffix)) continue;
                found=true;
                ArrayList<Integer> list=map1.get(suffix);
                
                ans[i]=list.get(0);
                break;
            }
            if(!found) ans[i]=min_Length_Index;
        }
        return ans;
    }
}


*/