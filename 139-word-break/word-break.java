class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] canBreak = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if ((j == 0 || canBreak[j - 1]) && set.contains(s.substring(j, i + 1))) {
                    canBreak[i] = true;
                    continue;
                }
            }
        }
        return canBreak[n - 1];
    }
}