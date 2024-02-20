/*
 * Author: Haonan Peng
 * Email: peng.haon@northeastern.edu
 *
 * This class is to solve the problem 1 of assignment 3
 *
 * reference:
 * 1. https://www.geeksforgeeks.org/quick-sort/
 * 2. https://www.geeksforgeeks.org/check-if-any-two-intervals-overlap-among-a-given-set-of-intervals/
 */
public class Problem1 {
    int len;
    int[] starts;
    int[] ends;

    /*
     * @brief: constructor, split the input 2D array to two arrays with only start integers and end integers.
     */
    public Problem1(int[][] intervals){
        // setup constraints
        if(intervals == null) throw new IllegalArgumentException("intervals can't be null");
        this.len = intervals.length;

        if(! (len>=0 && len<= 10000)) throw new IllegalArgumentException("0 <= intervals.length <= 10^4");

        this.starts = new int[len];
        this.ends = new int[len];

        int count = 0;
        // split the 2D array into two arrays to record start int and end int for later sorting
        for(int[] interval: intervals){
            if(interval.length!=2)
                throw new IllegalArgumentException("intervals[i].length == 2");

            if(!(interval[0]<interval[1] && interval[0]>=0 && interval[1]<=1000000))
                throw new IllegalArgumentException("0 <= start, < end, <= 10^6");

            starts[count] = interval[0];
            ends[count++] = interval[1];
        }
    }

    /*
     * @brief: method to check if any two intervals overlapping with each others or not
     *
     * @return: true, if no overlap between any two intervals;
     *  otherwise, false
     */
    public boolean canMakeAllMeetings(){
    /* Use Arrays.sort() for testing
        Arrays.sort(starts);
        Arrays.sort(ends);
    */

        // using quick sort to sort starts and ends arrays
        quickSort(starts,0, len-1);
        quickSort(ends,0, len-1);

        // if the current start int is less than the previous end int,
        // these two intervals are overlapped with each others
        for(int i = 1; i < len; i++){
            if(starts[i] <= ends[i-1]) return false;
        }

        return true;
    }

    /*
     * @brief: private method to implement quick sort on the given array
     */
    private void quickSort(int[] arr, int low, int high){
        if(low < high) {
            // get the index of the pivot after finishing partition
            int par = partition(arr, low, high);

            // quick sort the two sub-arrays which are seperated by the partition
            // index
            quickSort(arr, low, par - 1);
            quickSort(arr, par + 1, high);
        }
    }

    /*
     * @brief: private method to find the index of pivot after partition
     *
     * @return: int pos, partition index
     */
    private int partition(int[] arr, int low, int high){
        // choose the last element of the array as the pivot
        int pivot = arr[high];

        // set the partition index as the first element of the array
        int pos = low;

        for(int i = 0; i < high; i++){
            // if the current element is less than the pivot
            // swap it with the element at the partition index
            // and increase the index by 1
            if(arr[i] < pivot){
                swap(arr, pos++, i);
            }
        }

        // after sorting the whole array, swap the pivot with the
        // partition index and return the index
        swap(arr, pos, high);

        return pos;
    }

    /*
     * @brief: private method to swap two elements in an array by their indexes
     */
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
