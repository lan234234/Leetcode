class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        int n = indices.length;
        Cell[] arr = new Cell[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Cell(indices[i], sources[i], targets[i]);
        }
        Arrays.sort(arr);

        int start = 0;
        for (Cell cur : arr) {
            int indice = cur.indice;
            String source = cur.source;
            if (indice > start) {
                sb.append(s.substring(start, indice));
                start = indice;
            }
            int end = indice + source.length();
            if (end > s.length())   continue;
            String subS = s.substring(indice, end);
            if (source.equals(subS)) {
                sb.append(cur.target);
                start = end;
            }
        }
        sb.append(s.substring(start, s.length()));
        return sb.toString();
    }

    class Cell implements Comparable<Cell>{
        int indice;
        String source;
        String target;

        Cell(int indice, String source, String target) {
            this.indice = indice;
            this.source = source;
            this.target = target;
        }

        @Override
        public int compareTo(Cell another) {
            return Integer.compare(this.indice, another.indice);
        }
    }
}