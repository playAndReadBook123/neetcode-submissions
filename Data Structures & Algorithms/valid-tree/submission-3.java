class Solution {
    public boolean validTree(int n, int[][] edges) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edg : edges){
            int start = edg[0];
            int end = edg[1];
            map.computeIfAbsent(start, k -> new ArrayList<>()).add(end);
            map.computeIfAbsent(end, k -> new ArrayList<>()).add(start);
        }

        Set<Integer> visited = new HashSet<>();

        if(!dfs(0, -1, visited, map)){
            return false;
        }

        return visited.size() == n;
    }

    boolean dfs(int cur, int par, Set<Integer> visited, Map<Integer, List<Integer>> map){
        if(visited.contains(cur)){
            return false;
        }

        visited.add(cur);

        for(int next : map.getOrDefault(cur, new ArrayList<>())){

            if(next == par) continue;
            
            if(!dfs(next, cur, visited, map)){
                return false;
            }
        }

        return true;
    }
}
