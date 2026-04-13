class Solution {
    public String reformat(String s) {
        List<Character> digs = new ArrayList<>();
        List<Character> letts = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                digs.add(c);
            } else {
                letts.add(c);
            }
        }

        if (Math.abs(digs.size() - letts.size()) > 1)   return "";

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        if (letts.size() > digs.size()) {
            sb.append(letts.get(j++));
        }
        while (j < letts.size()) {
            sb.append(digs.get(i++));
            sb.append(letts.get(j++));
        }
        if (i < digs.size()) {
            sb.append(digs.get(i));
        }
        return sb.toString();
    }
}