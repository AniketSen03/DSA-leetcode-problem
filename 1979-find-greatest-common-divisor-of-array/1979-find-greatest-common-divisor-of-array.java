class Solution {
    public int findGCD(int[] nums) {
        int max = nums[0];
        int min = nums[0];

        for (int i : nums) {
            if (i > max)
                max = i;
            if (i < min)
                min = i;
        }
        return gcd(max,min);
    }
    private int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}