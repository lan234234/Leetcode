public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '/' || c == '#') {
                    sb.append('/');
                }
                sb.append(c);
            }
            sb.append('#');
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '/') {
                sb.append(s.charAt(++i));
            } else if (c == '#') {
                res.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));