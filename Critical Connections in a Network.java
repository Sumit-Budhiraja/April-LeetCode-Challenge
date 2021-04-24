class Solution {
        int time = 0;
    List<List<Integer>> result;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        result = new ArrayList<>();
        int[] parents = new int[n];
        int[] times = new int[n];
        ArrayList<Integer>[] adj = new ArrayList[n];
        Set<Integer> visited = new HashSet<>();

        for(List<Integer> connection : connections) {
            if(adj[connection.get(0)] == null) {
                adj[connection.get(0)] = new ArrayList<>();
            }
            adj[connection.get(0)].add(connection.get(1));

            if(adj[connection.get(1)] == null) {
                adj[connection.get(1)] = new ArrayList<>();
            }
            adj[connection.get(1)].add(connection.get(0));
        }

        for(int i = 0; i < n; i++) {
            if(!visited.contains(i)) {
                dfs(i, -1, adj, parents, times, visited);
            }
        }
        return result;
    }

    private void dfs(int node, int parent, ArrayList<Integer>[] adj, int[] parents, int[] times, Set<Integer> visited) {
        visited.add(node);
        times[node] = time;
        time++;
        if(adj[node] != null) {
            for(int i : adj[node]) {
                if(!visited.contains(i)) {
                    dfs(i, node, adj, parents, times, visited);
                }
            }

            if(parent > - 1) {
                int min = times[node];
                for(int i : adj[node]) {
                    if(i != parent && times[i] <= times[parent]) {
                        min = Math.min(min, times[i]);
                    }
                }
                times[node] = min;
                if(min <= times[parent]) {
                    return;
                } else {
                    List<Integer> bridge = new ArrayList<>();
                    bridge.add(parent);
                    bridge.add(node);
                    result.add(bridge);
                }
            }
        }
    }
}