class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        java.util.List<Integer>[] bucket = new java.util.List[nums.length + 1];
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new java.util.ArrayList<>();
            }
            bucket[freq].add(key);
        }

        java.util.List<Integer> result = new java.util.ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && result.size() < k; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}