class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String,Integer> map=new HashMap<>();
        int n=accounts.size();

        int[] par=new int[n+1];
        int[] size=new int[n+1];

        for(int i=0;i<=n;i++){
            par[i]=i;
            size[i]=1;
        }

        // split on map on the basis of mail belong to owner(represent by index i);

        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail=accounts.get(i).get(j);
                // if already exists then update their size and ultimate parent
                if(map.containsKey(mail)){
                    dsu(i,map.get(mail),par,size);
                }
                else{
                    map.put(mail,i);
                }
            }
        }
        List<String>[] arr=new ArrayList[n+1];

        for(int i=0;i<=n;i++){
            arr[i]=new ArrayList<>();
        }


        
        for(Map.Entry<String,Integer> ent:map.entrySet()){
            String mail=ent.getKey();
            // for everymail check their ultimate owner
            int node=find(ent.getValue(),par);

            arr[node].add(mail);
        }

        List<List<String>> ans=new ArrayList<>();
        // on the basis of owner now group the mail
        for(int i=0;i<=n;i++){
            if(arr[i].size()==0) continue;

            Collections.sort(arr[i]);
            List<String> temp=new ArrayList<>();
            temp.add(accounts.get(i).get(0));

            for(String s:arr[i]){
                temp.add(s);
            }

            ans.add(temp);
        }

    return ans;

    }
    public void dsu(int u,int v,int[] par,int[] size){
        int ul_u=find(u,par);
        int ul_v=find(v,par);

        if(ul_v==ul_u) return;

        if(size[ul_u]>size[ul_v]){
            size[ul_u]+=size[ul_v];
            par[ul_v]=ul_u;
        }
        else{
            size[ul_v]+=size[ul_u];
            par[ul_u]=ul_v;
        }
    }
    public int find(int x,int[] par){
        if(x==par[x]) return x;

        return par[x]=find(par[x],par);
    }
}