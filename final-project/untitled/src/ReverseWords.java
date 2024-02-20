/*
 * Author: Haonan Peng
 * Email: peng.haon@northeastern.edu
 *
 * Description:
 * Solution of Problem 3
 * Given a character array s, reverse the order of the words. A word is defined
 * as a sequence of non-space characters. The words in s will be separated by a
 * single space. Your code must solve the problem in-place, i.e. without
 * allocating extra space.
 */

public class ReverseWords {
    public void reverseWords(char[] s) {
        int n = s.length;

        // using two pointer to reverse words
        for (int i = 0, j = 0; j < n; ++j) {
            // reverse when meets white space
            if (s[j] == ' ') {
                reverse(s, i, j - 1);
                i = j + 1;
            } else if (j == n - 1) {
                // reverse when meets the end of array
                reverse(s, i, j);
            }
        }
        reverse(s, 0, n - 1);
    }

    // method to reverse subarray of chars
    private void reverse(char[] s, int i, int j) {
        while(i < j){
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
            i++;
            j--;
        }
    }
}
