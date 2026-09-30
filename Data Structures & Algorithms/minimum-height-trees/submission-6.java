class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        if(n == 1){
            return List.of(0);
        }

        int[] degree = new int[n];

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] edg : edges){
            int n1 = edg[0];
            int n2 = edg[1];
            degree[n1]++;
            degree[n2]++;
            graph.computeIfAbsent(n1, k -> new ArrayList<>()).add(n2);
            graph.computeIfAbsent(n2, k -> new ArrayList<>()).add(n1);
        }

        Queue<Integer> que = new LinkedList<>();

        for(int i = 0; i < degree.length; i++){
            if(degree[i] == 1){
                que.offer(i);
            }
        }

        Set<Integer> visited = new HashSet<>();
        int remaining = n;

        while(!que.isEmpty()){
            int size = que.size();
            if(remaining <= 2) return new ArrayList<>(que);
            while(size-- > 0){
                int cur = que.poll();
                visited.add(cur);
                remaining--;
                for(int next : graph.getOrDefault(cur, new ArrayList<>())){
                    
                    if(!visited.contains(next)){
                        degree[next]--;
                        if(degree[next] == 1){
                            que.offer(next);
                        }
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!que.isEmpty()){
            res.add(que.poll());
        }


        return res;

    }
}