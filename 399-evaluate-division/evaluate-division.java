class Solution {
    double[] ans;
    HashMap<String,List<String>> adjList;
    HashMap<List<String>,Double> valueList;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        ans=new double[queries.size()];
        adjList=new HashMap<>();
        valueList=new HashMap<>();
        for(int i=0;i<equations.size();i++){
            List<String> L=equations.get(i);
            String A=L.get(0);
            String B=L.get(1);
            if(!adjList.containsKey(A)){
                adjList.put(A,new ArrayList<>());
            }
            if(!adjList.containsKey(B)){
                adjList.put(B,new ArrayList<>());
            }
            adjList.get(A).add(B);
            adjList.get(B).add(A);
            valueList.put(L,values[i]);
            valueList.put(Arrays.asList(B, A), 1.0 / values[i]);

        }
        for(int i=0;i<queries.size();i++){
            ans[i]=sol(queries.get(i).get(0),queries.get(i).get(1));
        }
        return ans;
    }

    public double sol(String C,String D){
        
        if(!adjList.containsKey(C) || !adjList.containsKey(D) ) return (double)-1.0;
        if(C.equals(D)) return (double)1;
        
        Queue<String[]> q=new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        visited.add(C);
        for(String val:adjList.get(C)){
            q.add(new String[] {C,val,String.valueOf(valueList.get(Arrays.asList(C, val)))});
            visited.add(val);
        }

        while(!q.isEmpty()){
            String[] curr=q.poll();

            String qt=curr[1];
            double calc=Double.parseDouble(curr[2]);
            if(qt.equals(D)) return calc;
            for(String val:adjList.get(qt)){
                if (visited.contains(val))continue;
                visited.add(val);
                q.add(new String[] {C,val,String.valueOf(calc*valueList.get(Arrays.asList(qt, val)))});
                
            }

        }
        return (double)-1.0;
    }
}