public class Main {

    public static void main(String[] args){
        // Problem 1 ex1:
        FindValidPath p1 = new FindValidPath();
        int[][] edges1 = {{0,1},{1,2},{2,0}};
        System.out.println("Input: n = 3, edges = [[0,1], [1,2], [2,0]], source = 0, destination = 2");
        System.out.println("Output = " + p1.validPath(3,edges1,0,2));

        // Problem 1 ex2:
        int[][] edges2 = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        System.out.println("Input: n = 6, edges = [[0,1] , [0,2] , [3,5] , [5,4] , [4,3]], source = 0, destination = 5");
        System.out.println("Output = " + p1.validPath(6,edges2,0,5));

        // Problem 2 ex1:
        ValidateAllPathsToDestination p2 = new ValidateAllPathsToDestination();
        int[][] edges3 = {{0,1},{0,2}};
        System.out.println("Input, n = 3, edges = [[0,1] , [0,2]], source = 0, destination = 2");
        System.out.println("Output = "+p2.validAllPaths(3,edges3,0,2));

        // Problem 2 ex2:
        int[][] edges4 = {{0,1},{0,3},{1,2},{2,1}};
        System.out.println("Input, n = 4, edges = [[0,1] , [0,3] , [1,2] , [2,1]], source = 0, destination = 3");
        System.out.println("Output = "+p2.validAllPaths(4,edges4,0,3));

        // Problem 2 ex3:
        int[][] edges5 = {{0,1},{0,2},{1,3},{2,3}};
        System.out.println("Input, n = 4, edges = [[0,1] , [0,2] , [1,3] , [2,3]], source = 0, destination = 3");
        System.out.println("Output = "+p2.validAllPaths(5,edges5,0,3));

        // Problem 2 ex4:
        int[][] edges6 = {{0,1},{0,2},{1,2},{1,3},{2,3}};
        System.out.println("Input, n = 4, edges = [[0,1] , [0,2] , [1,2], [1,3] , [2,3]], source = 0, destination = 3");
        System.out.println("Output = "+p2.validAllPaths(5,edges6,0,3));
    }
}
