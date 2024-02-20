import java.util.ArrayList;
import java.util.HashMap;

public class WordDistance {
    HashMap<String, ArrayList<Integer>> hs;
    public WordDistance(String[] arr){
        this.hs = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(!hs.containsKey(arr[i]))
                hs.put(arr[i],new ArrayList<Integer>());
            hs.get(arr[i]).add(i);
        }
    }

    public int shortest(String word1, String word2){
        ArrayList<Integer> list1 = hs.get(word1), list2 = hs.get(word2);
        int distance = Integer.MAX_VALUE;
        int i = 0, j = 0;

        while(i < list1.size() && j < list2.size()){
            distance = Math.min(distance, Math.abs(list1.get(i) - list2.get(j)));
            if(list1.get(i) < list2.get(j)){
                i++;
            }else {
                j++;
            }
        }

        return distance;
    }
}
