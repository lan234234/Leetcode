class Solution {
    private static final int FACTOR = 10003;
    private static final int MOD = 10000007;
    int N;

    public int strStr(String haystack, String needle) {
        N = needle.length();
        if (haystack == null || needle == null || needle.isEmpty() || haystack.length() < N)    return -1;

        long hash = getHash(needle);
        long curHash = getHash(haystack);
        long deduct = deduct();
        for (int i = needle.length(); i <= haystack.length(); i++) {
            int start = i - needle.length();
            if (hash == curHash && same(haystack, start, needle)) return start;
            if (i == haystack.length()) break;
            curHash = (curHash - deduct * haystack.charAt(start) % MOD + MOD) % MOD * FACTOR % MOD + haystack.charAt(i);
            curHash %= MOD;
        }
        return -1;
    }

    private long getHash(String s) {
        long hash = 0;
        for (int i = 0; i < N; i++) {
            hash = (hash * FACTOR % MOD + s.charAt(i)) % MOD;
        }
        return hash;
    }

    private long deduct() {
        long res = 1L;
        for (int i = 1; i < N; i++) {
            res = res * FACTOR % MOD;
        }
        return res;
    }

    private boolean same(String s1, int start, String s2) {
        if (start + s2.length() > s1.length())    return false;
        for (int i = 0; i < s2.length(); i++) {
            if (s1.charAt(start + i) != s2.charAt(i))   return false;
        }
        return true;
    }
}