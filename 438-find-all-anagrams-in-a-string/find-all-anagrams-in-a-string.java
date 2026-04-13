class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] freq = new int[26];
        int n = p.length();
        int uniq = 0;
        int match = 0;

        for (int i = 0; i < n; i++) {
            int index = p.charAt(i) - 'a';
            if (freq[index] == 0)   uniq++;
            freq[index]++;
        }

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            int index = s.charAt(right) - 'a';
            freq[index]--;
            if (freq[index] == 0)   match++;
            while (freq[index] < 0) {
                int leftIndex = s.charAt(left++) - 'a';
                freq[leftIndex]++;
                if (freq[leftIndex] == 1)   match--;
            }
            if (match == uniq)  res.add(left);
        }
        return res;
    }
}