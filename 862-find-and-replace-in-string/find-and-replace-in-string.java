class Solution {
    /**
    0123         index
    abcd    [0,2]
      i
        s
    sb:eeebffff
     */
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Node[] arr = new Node[indices.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Node(indices[i], sources[i], targets[i]);
        }
        Arrays.sort(arr);

        int start = 0;
        StringBuilder sb = new StringBuilder();
        for (Node cur : arr) {
            int index = cur.index;
            if (index < start)  continue;
            if (index > s.length()) break;
            if (exist(s, index, cur.source)) {
                sb.append(s.substring(start, index));
                sb.append(cur.target);
                start = index + cur.source.length();
            }
        }
        sb.append(s.substring(start, s.length()));
        return sb.toString();
    }

    private boolean exist(String s, int start, String source) {
        if (start + source.length() > s.length())  return false;
        for (int i = 0; i < source.length(); i++) {
            if (s.charAt(start + i) != source.charAt(i))    return false;
        }
        return true;
    }

    class Node implements Comparable<Node>{
        int index;
        String source;
        String target;

        Node(int index, String source, String target) {
            this.index = index;
            this.source = source;
            this.target = target;
        }

        @Override
        public int compareTo(Node another) {
            return Integer.compare(this.index, another.index);
        }
    }
}