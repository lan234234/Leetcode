class Solution {
    public int lastStoneWeight(int[] stones) {
        int[] count = new int[1001];
        for (int s : stones) {
            count[s]++;
        }

        int rem = 0;
        for (int i = count.length - 1; i > 0 ; i--) {
            if (count[i] == 0)  continue;
            if (rem == 0) {
                count[i] %= 2;
                rem = count[i] == 0 ? 0 : i;
            } else {
                count[i]--;
                rem -= i;
                if (rem <= i) {
                    count[rem]++;
                    rem = 0;
                }
                i++;
            }
        }
        return rem; 
    }
}