class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)   return s;

        int n = s.length();
        int countInCycle = numRows * 2 - 2;
        int cycles = (n + countInCycle - 1) / countInCycle;
        StringBuilder sb = new StringBuilder();

        for (int r = 0; r < numRows; r++) {
            for (int cycle = 0; cycle < cycles; cycle++) {
                int firstInd = r + countInCycle * cycle;
                if (firstInd >= n)   continue;
                sb.append(s.charAt(firstInd));

                int secondInd = countInCycle * (cycle + 1) - r;
                if (secondInd > firstInd && r != 0 && secondInd < n) {
                    sb.append(s.charAt(secondInd));
                }
            }
        }
        return sb.toString();
    }
}