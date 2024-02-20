import java.util.*;

public class FindValidPath {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(n < 1 || n > 100){
            throw new IllegalArgumentException("1 <= n <= 100");
        }

        if(edges.length < 0 || edges.length> 100){
            throw new IllegalArgumentException("0 <= edges.length <= 100");
        }

        // return true if the graph only contains 1 vertex
        if(n == 1) return true;

        // Map to track neighbor vertexes of each vertex in the graph
        Map<Integer, List<Integer>> map = new HashMap<>();

        // loop through all edges to track all neighbors vertexes of each vertex
        for(int edge[] : edges) {
            if(!map.containsKey(edge[0]))
                map.put(edge[0], new LinkedList<>());

            if(!map.containsKey(edge[1]))
                map.put(edge[1], new LinkedList<>());

            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        // use queue to loop through all vertexes to find the valid path
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        // set to track visited vertex
        Set<Integer> visited = new HashSet<>();

        while(!queue.isEmpty()) {
            int current = queue.remove();

            // if the current vertex is not visited, push all its neighbor
            // vertexes to the queue unless the destination vertex is found
            if(!visited.contains(current)) {
                // update the current vertex as visited
                visited.add(current);

                List<Integer> neighbors = map.get(current);

                for (int vertex : neighbors) {
                    if (vertex == destination)
                        return true;
                    queue.add(vertex);
                }
            }
        }

        return false;
    }
}
