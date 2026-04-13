public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length());
            sb.append('*');
            sb.append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    // "5*Hello5*World"
    //   
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*') {
                num = num * 10 + s.charAt(i) - '0';
            } else {
                res.add(s.substring(i + 1, i + 1 + num));
                i += num;
                num = 0;
            }
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));