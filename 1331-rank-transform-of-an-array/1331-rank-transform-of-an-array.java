import java.util.*;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // Handle empty array case
        if (arr.length == 0) return new int[0];
        
        // 1. Create a sorted copy of unique elements
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        
        // 2. Map each number to its rank
        HashMap<Integer, Integer> numToRank = new HashMap<>();
        int rank = 1;
        for (int num : sortedArr) {
            // Only add if not already present to handle duplicates
            if (!numToRank.containsKey(num)) {
                numToRank.put(num, rank++);
            }
        }
        
        // 3. Transform the original array
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = numToRank.get(arr[i]);
        }
        
        return result;
    }
}
