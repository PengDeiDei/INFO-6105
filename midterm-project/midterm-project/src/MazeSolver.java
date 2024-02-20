import java.util.PriorityQueue;

public class MazeSolver {
    private int m;
    private int n;
    private int[] start;
    private int[] destination;
    private int[][] maze;

    private class Point implements Comparable<Point>{
        int x;
        int y;
        int dist;

        public Point(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        public int compareTo(Point p){
            return (this.dist - p.dist);
        }
    }

    public MazeSolver(int[][] maze, int[] start, int[] destination){
        if(start.length > 2 || destination.length > 2){
            throw new IllegalArgumentException("start.length == 2\n" +
                    "destination.length == 2");
        }
        this.maze = maze;
        this.start = start;
        this.destination = destination;

        this.m = maze.length;
        this.n = maze[0].length;
        if(m < 1 || m > 100 || n < 1 || n > 100) throw new IllegalArgumentException("1 <= m, n <= 100");

        if(start[0] < 0 || start[0] >= m || start[1] < 0 || start[1] >= n){
            throw new IllegalArgumentException("0 <= start_row < m,\n"
                    + " 0 <= start_column < n");
        }
        if(destination[0] < 0 || destination[0] >= m || destination[1] < 0 || destination[1] >= n){
            throw new IllegalArgumentException("0 <= destination_row < m,\n"
                    + "0 <= destination_column < n");
        }
    }

    public int shortestDistance(){
        // create an array to represent 4 moving directions in the form of [i,i+1] (0 <= i < 4)
        int[] directions = {-1,0,1,0,-1};

        // create a 2D array to track visited points
        boolean visited[][] = new boolean[maze.length][maze[0].length];

        // Create a priority queue to find the shortest path by storing relative points
        PriorityQueue<Point> pq = new PriorityQueue<>();

        // add the start point to the queue
        pq.offer(new Point(start[0], start[1], 0));

        while(!pq.isEmpty()){
            Point p = pq.poll();

            // return the distance if reaches the destination
            if(p.x == destination[0] && p.y == destination[1]){
                return p.dist;
            }

            // mark this point as visited
            visited[p.x][p.y] = true;

            // move the ball along four directions
            for(int i =0; i < 4; i++){
                int dist = 0;
                int x = p.x;
                int y = p.y;

                // since the ball can only move along one direction per time
                // using while loop to get distance until it reaches the wall
                while(isInMaze(x,y)){
                    x += directions[i];
                    y += directions[i+1];
                    dist++;
                }

                // get the new location data where the ball stops at
                x -= directions[i];
                y -= directions[i+1];
                dist = dist + p.dist - 1;

                // if the point is not visited, push it to the queue
                if(visited[x][y] == false){
                    pq.add(new Point(x,y,dist));
                }
            }

        }

        // return -1 if the ball can't move from start to destination
        return -1;
    }

    private boolean isInMaze(int x, int y){

        // return true if x and y are valid and this point is reachable in maze
        if(x>= 0 && x < n && y >= 0 && y < m && maze[x][y] == 0) {
            return true;
        }

        return false;
    }
}
