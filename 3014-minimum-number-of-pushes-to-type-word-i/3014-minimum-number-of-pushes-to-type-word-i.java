class Solution {
    public int minimumPushes(String word) {
        int ans=0;
        int len=word.length();
        for(int i=0;i<len;i++){
            ans+=(i / 8 + 1);
        }
        return ans;
    }
}