/*
 * @Author: Haonan Peng
 * @Email: peng.haon@northeastern.edu
 *
 * This is the solution for problem 2.
 */
import java.util.Arrays;

public class Problem2 {
    int len;
    int[] prefixSum;
    int[] counts;

    /*
     * @brief: constructor, check for constraints
     */
    public Problem2(int[] nums){
        if(nums == null) throw new IllegalArgumentException("Array can't be null");

        this.len = nums.length;
        if(!(len >= 1 && len <= 50)) throw new IllegalArgumentException("1 <= nums.length <= 50");

        this.prefixSum = new int[len+1];
        this.counts = new int[len];

        getPrefixSum(nums);
    }

    /*
     * @brief: this is an O(N^2) time complexity solution to count the subarrays with more
     * ones than zeros
     *
     * @return: int result, number of matched subarrays
     */
    public int subarrysWithMoreOnesThanZeros(){
        int result = 0;

        for(int j = 1; j < len+1; j++){
            for(int i = 0; i < j; i++){
                if(prefixSum[i] < prefixSum[j]){
                    counts[j-1]++;
                }
            }
            result += counts[j-1];
        }
        return result;
    }

    /*
     * @brief: private method to calculate the prefix sum of the input binary arrays.
     *  To calculate the prefix sum, set zeros in the binary array to -1, and add them up from
     *  the start of the array to current index, store the result in prefixSum array with current index
     */
    private void getPrefixSum(int[] nums){
        int pf = 0; // sum of the difference between 0 and 1

        for(int i = 0; i < len; i++){
            if(!(nums[i]==0 || nums[i]==1)) throw new IllegalArgumentException("0 <= nums[i] <= 1");

            // let zeros be -1, ones still be 1, sum the difference between them
            pf += (nums[i] == 1? 1:-1);

            // store the current sum at prefixSum array
            prefixSum[i+1] = pf;
        }
    }
}
