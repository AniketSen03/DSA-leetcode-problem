import java.util.Arrays;

class Solution {
    // Helper method to compute Greatest Common Divisor
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
        
        // 1. Construct the prefixGcd array
        int runningMax = nums[0];
        for (int i = 0; i < n; i++) {
            runningMax = Math.max(runningMax, nums[i]);
            prefixGcd[i] = gcd(nums[i], runningMax);
        }
        
        // 2. Sort the prefixGcd array in non-decreasing order
        Arrays.sort(prefixGcd);
        
        // 3. Pair the smallest and largest unpaired elements from the outside-in
        long totalSum = 0;
        int left = 0;
        int right = n - 1;
        
        while (left < right) {
            totalSum += gcd(prefixGcd[left], prefixGcd[right]);
            left++;
            right--;
        }
        
        return totalSum;
    }
}
