import java.util.*;

public class ValidateAllPathsToDestination {
    private int destination;
    private int source;

    public boolean validAllPaths(int n, int[][] edges, int source, int destination){
        if(n < 1 || n > 100){
            throw new IllegalArgumentException("1 <= n <= 100");
        }

        if(edges.length < 0 || edges.length> 100){
            throw new IllegalArgumentException("0 <= edges.length <= 100");
        }

        this.source = source;
        this.destination = destination;

        // return true if the graph only contains 1 vertex
        if(n == 1) return true;

        // map to track the vertexes of each vertex points to in the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // build the directed graph
        for(int edge[] : edges) {

            // return false if the destination vertex has a vertex to point to
            if(edge[0] == destination) return false;

            if(!graph.containsKey(edge[0]))
                graph.put(edge[0], new LinkedList<>());

            graph.get(edge[0]).add(edge[1]);
        }

        /*
         * since we are validating all paths from source to destination,
         * we mark the visited end point as 1, the in-path vertex which can be
         * visited multiple times as 2, the unvisited vertex as 0
         */
        int[] visited = new int[n];

        return dfs(graph, visited, this.source);
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int[] visited, int current){
        // check whether the current vertex is an end point
        // if so, check if it is the destination
        if(!graph.containsKey(current)) {
            return current == this.destination;
        }

        // mark the current vertex as 1
        visited[current] = 1;

        List<Integer> neighbors = graph.get(current);

        for(int next: neighbors){
            // return false if next vertex reaches the end without being as the destination
            if(visited[next] == 1) return false;

            // if the next vertex is unvisited, implement dfs further
            if(visited[next] == 0 && !dfs(graph, visited, next)) return false;
        }

        // identify the current vertex as in-path vertex, mark as 2
        visited[current] = 2;

        return true;
    }
}
