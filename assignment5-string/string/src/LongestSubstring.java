import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public int findLongestSubstring(String s){
        // constraint
        if(s.length() < 1 || s.length() > 100)
            throw new IllegalArgumentException("1 <= s.length <= 100");

        // convert string to char array
        char[] c = s.toCharArray();
        int len = c.length;

        // return length of string if its length is less than 3
        if(len < 3) return len;

        int maxLen = 0;
        int left = 0;
        int right = 0;

        // hash map to count the occurrences of at most 2 distinct
        // characters in substring
        Map<Character, Integer> hm = new HashMap<>();

        while(right < len){
            hm.put(c[right], hm.getOrDefault(c[right],0) + 1);

            // if the map contains more than 2 distinct characters, move the left
            // pointer to contract the window
            while(hm.size() > 2){
                // subtract 1 to the count of the character located at left pointer
                hm.put(c[left], hm.get(c[left]) - 1);

                // remove the character from map if its count is 0
                if(hm.get(c[left]) == 0){
                    hm.remove(c[left]);
                }

                // move left pointer to right
                left++;
            }

            // update the maximum length, move right pointer to right
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}
