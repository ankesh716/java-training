class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dfs(graph, state, i))
                ans.add(i);
        }

        return ans;
    }

    boolean dfs(int[][] graph, int[] state, int node) {
        if (state[node] == 1) return false;
        if (state[node] == 2) return true;

        state[node] = 1;

        for (int next : graph[node]) {
            if (!dfs(graph, state, next))
                return false;
        }

        state[node] = 2;
        return true;
    }
}