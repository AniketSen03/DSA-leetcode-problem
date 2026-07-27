class Solution {
    public int maxProduct(int[] nums) {
      Arrays.sort(nums);
        int n = nums.length;
        // The two largest elements are at the last two indices
        return (nums[n - 1] - 1) * (nums[n - 2] - 1);
    }
}