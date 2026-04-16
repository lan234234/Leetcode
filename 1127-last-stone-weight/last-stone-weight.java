class Solution {
    public int lastStoneWeight(int[] stones) {
        int[] count = new int[1001];
        for (int s : stones) {
            count[s]++;
        }

        int cur = 0;
        int i = count.length - 1;
        while (i > 0) {
            if (i == 8) {
                int a = 1;
            }
            if (count[i] == 0) {
                i--;
                continue;
            }
            if (cur == 0) {
                cur = i;
            } else {
                int rem = cur - i;
                if (rem > i) {
                    cur = rem;
                } else {
                    count[rem]++;
                    cur = 0;
                }
            }
            count[i]--;
        }
        return cur; 
    }
}