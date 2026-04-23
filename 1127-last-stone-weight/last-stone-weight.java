class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length <= 1)  return 1;

        int[] freq = new int[1001];
        for (int s : stones) {
            freq[s]++;
        }

        int rem = 0;
        for (int i = freq.length - 1; i > 0; i--) {
            if (i == 8) {
                int a = 0;
            }
            if (freq[i] == 0)   continue;
            if (rem == 0) {
                freq[i] = freq[i] % 2;
                if (freq[i] == 0)   continue;
                rem = i;
                freq[i] = 0;
            } else {
                freq[i]--;
                int diff = rem - i;
                if (diff >= i) {
                    rem = diff;
                } else {
                    freq[diff]++;
                    rem = 0;
                }
                i++;
            }
        }
        return rem;
    }
}