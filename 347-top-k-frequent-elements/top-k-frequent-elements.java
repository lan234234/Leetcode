class Solution {
    Map<Integer, Integer> freq;
    public int[] topKFrequent(int[] nums, int k) {
        freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int[] arr = new int[freq.size()];
        int i = 0;
        for (int key : freq.keySet()) {
            arr[i++] = key;
        }

        quickSelect(arr, 0, arr.length - 1, k);

        return Arrays.copyOfRange(arr, 0, k);
    }

    private void quickSelect(int[] arr, int left, int right, int k) {
        if (right - left + 1 == k)  return;

        int pivotInd = (int) (Math.random() * (right - left + 1) + left);
        int pFreq = freq.get(arr[pivotInd]);
        swap(arr, pivotInd, right);
        int i = left;
        int j = right - 1;
        while (i <= j) {
            if (freq.get(arr[i]) > pFreq) {
                i++;
            } else if (freq.get(arr[j]) <= pFreq) {
                j--;
            } else {
                swap(arr, i++, j--);
            }
        }
        swap(arr, right, i);

        int len = i - left;
        if (len == k)   return;
        if (len < k) {
            quickSelect(arr, i, right, k - len);
        } else {
            quickSelect(arr, left, i - 1, k);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}