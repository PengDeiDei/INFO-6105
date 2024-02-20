import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        MyBinarySearch problem1 = new MyBinarySearch();

        int[] arr = {2, 2, 3, 3, 4, 4, 4, 8, 8, 8, 8, 8, 9, 9, 10, 12, 15};
        ArrayList<Integer> sortedList = getList(arr);


        int[] params = {4, 2, 5, 8, 11, 15};

        problem1.countOccur(sortedList,params);


        int[] arr2 = {6, 7, 8, 2, 3, 4, 5};
        problem1.search(arr2,9);
        problem1.search(arr2, 8);
    }

    /*
     * method to transfer all elements in an array to array list
     *
     * @param: int[] arr, integer array
     *
     * @return: ArrayList
     */
    public static ArrayList<Integer> getList(int[] arr){
        ArrayList<Integer> arrList = new ArrayList<>();

        for(int item: arr){
            arrList.add(item);
        }

        return arrList;
    }
}