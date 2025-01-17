package arrayandstring;

public class ReorganizeString_767 {
    public String reorganizeString(String s) {
        // corner case:
        if (s.length() == 1)    return s;
        // general case:
        int[] freq = new int[26];
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int charIndex = s.charAt(i) - 'a';
            freq[charIndex]++;
            if (freq[max] < freq[charIndex]) {
                max = charIndex;
            }
        }

        if (freq[max] > (s.length() + 1) / 2) return "";
        char c = (char) (max + 'a');
        char[] res = new char[s.length()];
        int i = 0;
        while (freq[max] > 0) {
            res[i] = c;
            i += 2;
            freq[max]--;
        }

        for (int j = 0; j < 26; j++) {
            while (freq[j] > 0) {
                if (i >= s.length()) {
                    i = 1;
                }
                res[i] = (char) (j + 'a');
                freq[j]--;
                i += 2;
            }
        }
        return new String(res);
    }
}
