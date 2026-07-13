class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String s = "123456789";
        List <Integer> ans = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                int val = Integer.parseInt(s.substring(i, j));
                if (val >= low && val <= high) {
                    ans.add(val);
                }
            }
        }
         Collections.sort(ans);
        return ans;
    }
}