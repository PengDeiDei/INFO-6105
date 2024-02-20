import java.util.ArrayList;

public class MyBinarySearch {
    /*
     * recursive method to implement binary search algorithm
     *
     * @param:
     *  ArrayList<Integer> list, integer array list
     *  int low, index of the left side of list for binary searching
     *  int high, index of the right side of list for binary searching
     *  int target, target integer for searching
     *
     * @return:
     *  -1, if no target is found
     *  mid, the index of the first found target
     */
    private int binarySearch(ArrayList<Integer> list,int low, int high, int target){
        if(high >= low){
            int mid = low + (high - low)/2;

            // if target element is in the middle of the array
            if(list.get(mid) == target) {
                return mid;
            }

            // if the middle element is larger than the target element,
            // search the right part of the array
            if(list.get(mid) > target){
                return binarySearch(list, low, mid - 1, target);
            }

            // if the middle element is less than the target element,
            // search the left part of the array
            return binarySearch(list, mid + 1, high, target);
        }

        // return -1, if no target element in the array
        return -1;
    }

    /*
     * count the occurrences of target in the given list of integers
     *
     * @param:
     *  ArrayList<Integer> list, integer array list
     *  int target, target integer
     *
     * @return:
     *  0, if no such target element in the list
     *  count, the occurrence of target element in the list
     */
    private int countOccurs(ArrayList<Integer> list, int target){
        int index = binarySearch(list, 0, list.size()-1, target);

        // return 0 if no target element in the array
        if(index == -1){
            return 0;
        }

        int count = 1;

        // count the occurrences of target in the right half of the array
        int right = index +1;
        while(right < list.size() && target == list.get(right)){
            count++;
            right++;
        }

        // count the occurrences of target in the left half of the array
        int left = index - 1;
        while(left > 0 && target == list.get(left)){
            count++;
            left--;
        }

        return count;
    }

    /*
     * solution of the first assignment problem
     * method to count the occurrences of each given parameter
     * in the given sorted list from the parameter array
     *
     * @param:
     *  ArrayList<Integer> sorted, sorted integer array list in ascending order
     *  int[] params, parameter array for counting the occurrences of all elements
     *  of it in the given list
     */
    public void countOccur(ArrayList<Integer> sorted, int[] params){
        for(int param: params){
            int occur = countOccurs(sorted,param);
            System.out.println("The target " + param + " = "
                    + occur +"(Parameter array, "+ param +")");
        }
    }

    /*
     * solution of second assignment problem
     * recursive method to implement binary search in a rotated sorted array
     */
    private int searchRotdArr(int[] arr,int low, int high, int target){
        if(high >= low){
            int mid = low + (high-low)/2;

            // return mid if the target element is at the middle of the list
            if(arr[mid] == target){
                return mid;
            }

            // if the partial list from index low to index mid is sorted
            if(arr[low] < arr[mid]){
                // if the target element is in this part of list
                if(target >= arr[low] && target < arr[mid]){
                    return searchRotdArr(arr, low, mid-1, target);
                }

                // if the target is in another part of list
                return searchRotdArr(arr, mid+1, high, target);
            }

            // if the partial list from low to mid is not sorted, then
            // the part of list from mid to high must be sorted
            // search for target if it might be in this part
            if(target <= arr[high] && target > arr[mid]){
                return searchRotdArr(arr, mid+1, high, target);
            }

            // otherwise, resize the sublist and search the left part
            return searchRotdArr(arr, low, mid-1, target);
        }

        // return -1 if no such target in the array
        return -1;
    }

   // public method to search element in a rotated sorted array
    public void search(int[] sorted, int target){
        int index = searchRotdArr(sorted, 0, sorted.length-1, target);

        if(index  == -1){
            System.out.println("Target " + target + " = "
                    + index +" (" + index + " does not exist)");
        }else{
            System.out.println("Target " + target + " = "
                    + index +" (" + index + " is the index of " + target + ")");
        }
    }
}
