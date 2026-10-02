class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left=0;
        int right = 0;
        while (right < s.length()) {
            char ch =s.charAt(right);
            if(map.containsKey(ch)) {
               left=Math.max(left,map.get(ch)+1);
            }
            map.put(ch,right);
            max=Math.max(right-left+1,max);
            right++;
        }
        return max;
    }
}