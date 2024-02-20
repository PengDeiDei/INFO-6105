/*
 * @Author: Haonan Peng
 * @Email: peng.haon@northeastern.edu
 *
 * Test class for assignment 3
 */
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        // problem 1:
        int[][] intvl1 = {{0,30},{5,10},{15,20}};
        attendAll(intvl1);

        int[][] intvl2 = {{7,10}, {2,4}};
        attendAll(intvl2);

        System.out.println();

        int[] nums1 = {0,1,1,0,1};
        countSubarrys(nums1);

        int[] nums2 = {0};
        countSubarrys(nums2);

        int[] num3 = {1};
        countSubarrys(num3);
    }

    // solve problem 1 as a method
    public static void attendAll(int[][] intervals){
        Problem1 soln = new Problem1(intervals);
        System.out.println("Input: "+Arrays.deepToString(intervals));
        System.out.println("Output: "+soln.canMakeAllMeetings());
    }

    public static void countSubarrys(int[] nums){
        Problem2 soln = new Problem2(nums);
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + soln.subarrysWithMoreOnesThanZeros());
    }
}