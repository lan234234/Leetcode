class Solution {
    Map<String, Integer> map;

    public List<String> topKFrequent(String[] words, int k) {
        map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> list = new ArrayList<>();
        for (String s : map.keySet()) {
            list.add(s);
        }

        quickSelect(list, 0, list.size() - 1, k);
        List<String> res = new ArrayList<>(list.subList(0, k));
        Collections.sort(res, (a, b) -> (compare(a, b)));
        return res;
    }

    private int compare(String a, String b) {
        int count1 = map.get(a);
        int count2 = map.get(b);
        if (count1 == count2)   return a.compareTo(b);
        return count2 - count1;
    }

    private void quickSelect(List<String> list, int left, int right, int k) {
        if (left == right)  return;

        int pivotInd = (int) (Math.random() * (right - left + 1) + left);
        String p = list.get(pivotInd);
        swap(list, pivotInd, right);
        int i = left;
        int j = right - 1;
        while (i <= j) {
            if (compare(list.get(i), p) <= 0) {
                i++;
            } else if (compare(list.get(j), p) > 0) {
                j--;
            } else {
                swap(list, i++, j--);
            }
        }
        swap(list, i, right);

        int len = i - left + 1;
        if (len == k || len - 1 == k)   return;
        if (len < k) {
            quickSelect(list, i + 1, right, k - len);
        } else {
            quickSelect(list, left, i - 1, k);
        }
    }

    private void swap(List<String> list, int i, int j) {
        String temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}