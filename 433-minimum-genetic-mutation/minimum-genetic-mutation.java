class Solution {
    public static char[] arr={'A','C','G','T'};
    public static HashSet<String> set;
    public int minMutation(String startGene, String endGene, String[] bank) {
        set=new HashSet<>();
        for(String gene:bank){
            set.add(gene);
        }
        if(!set.contains(endGene)) return -1;
        Queue<String> q=new LinkedList<>();
        q.add(startGene);
        int count=-1;
        while(!q.isEmpty()){
            int size=q.size();
            count++;
            for(int i=0;i<size;i++){
                String s=q.poll();
                if(s.equals(endGene)) return count;
                for(int j=0;j<8;j++){
                    char[] ch=s.toCharArray();

                    char original=ch[j];

                    for(int k=0;k<4;k++){
                        ch[j]=arr[k];

                        String exist=new String(ch);
                        if(set.contains(exist)) {
                            q.add(exist);
                            //same gene added repeatedly
                            set.remove(exist);
                        }
                    }
                    ch[j]=original;
                }
            }
        }
        return -1;
    }
   
}