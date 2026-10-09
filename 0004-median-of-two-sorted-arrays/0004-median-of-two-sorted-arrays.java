class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] arr = new int[n + m];
        int k = 0;
        for (int i = 0; i < n; i++) {
            arr[k++] = nums1[i];
        }
        for (int i = 0; i < m; i++) {
            arr[k++] = nums2[i];
        }
        Arrays.sort(arr);
        if (arr.length % 2 == 1) {
            return (double) arr[arr.length / 2];
        } else {
            int m1 = arr[arr.length / 2 - 1];
            int m2 = arr[arr.length / 2];
            return ((double) m1 + (double) m2) / 2.0;
        }
    }
}