public class Celebrity {
    int[][] m;

    public Celebrity(int[][] matrix){
        this.m = matrix;
    }

    public int findCelebrity(int n){
        int celebrity = 0;

        // using for loop to compare and eliminate unqualified
        // person until reaches the final person
        for(int i = 1; i < n; i++){
            if(knows(celebrity, i)){
                celebrity = i;
            }
        }

        // for loop to check if the final celebrity is real
        for(int j = 0; j < n; j++){
            if(j == celebrity) continue;

            // if the final celebrity knows any person or any other person
            // knows nothing about this celebrity, there is no celebrity,
            // return -1
            if(knows(celebrity,j) || !knows(j,celebrity))
                return -1;
        }

        return celebrity;
    }

    // method to check if a knows b
    private boolean knows(int a, int b){
        return (m[a][b] == 1) ? true:false;
    }
}
