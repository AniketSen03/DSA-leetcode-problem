class Solution {
    public String smallestPalindrome(String s) {
        int[] hash = new int[26];
        int n = s.length();

        for (int i = 0; i < n; i++) {
            hash[s.charAt(i) - 'a']++;
        }

        String middle = "";
        StringBuilder left = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if (hash[i] == 0) continue;

            char ch = (char) ('a' + i);

            left.repeat(ch, hash[i] / 2);

            if ((hash[i] & 1) == 1) {
                middle = String.valueOf(ch);
            }
        }

        String firstHalf = left.toString();
        left.reverse();

        return firstHalf + middle + left.toString();
    }
}