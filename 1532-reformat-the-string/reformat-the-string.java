class Solution {
    public String reformat(String s) {

        int len = s.length();
        char[] sArr = s.toCharArray();
        char[] letters = new char[len];
        char[] numbers = new char [len];
        int lCounter = 0;
        int nCounter = 0;

        for (char  ch : sArr) {
            if (Character.isDigit(ch)) {
                numbers[nCounter++] = ch;
            } else {
                letters[lCounter++] = ch;
            }
        }

        if (Math.abs(lCounter - nCounter) > 1) {
            return "";
        }
        
        boolean letterTurn = lCounter >= nCounter;
        
        for (int i = 0; i < len; i++) {
            if (letterTurn) {
                sArr[i] = letters[--lCounter];
            } else {
                sArr[i] = numbers[--nCounter];
            }
            letterTurn = !letterTurn;
        }

        return new String(sArr);
    }
}