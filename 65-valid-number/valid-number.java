class Solution {
    public boolean isNumber(String s) {
        List<Map<String, Integer>> list = new ArrayList<>();
        list.add(Map.of("digit", 1, "sign", 2, "dot", 3));
        list.add(Map.of("e", 5, "dot", 4, "digit", 1));
        list.add(Map.of("digit", 1, "dot", 3));
        list.add(Map.of("digit", 4));
        list.add(Map.of("digit", 4, "e", 5));
        list.add(Map.of("digit", 7, "sign", 6));
        list.add(Map.of("digit", 7));
        list.add(Map.of("digit", 7));
        Set<Integer> numberState = new HashSet(List.of(1, 4, 7));

        int state = 0;
        for (int i = 0; i < s.length(); i++) {
            String op;
            char c = s.charAt(i);
            if (c == '.') {
                op = "dot";
            } else if (c == 'e' || c == 'E') {
                op = "e";
            } else if (Character.isDigit(c)) {
                op = "digit";
            } else if (c == '+' || c == '-') {
                op = "sign";
            } else {
                return false;
            }

            Integer next = list.get(state).get(op);
            if (next == null)   return false;
            state = next;
        }
        return numberState.contains(state);
    }
}