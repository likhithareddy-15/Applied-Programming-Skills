import java.util.*;

class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, List<Integer> temp) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int num : nums) {
            if (temp.contains(num)) continue;

            temp.add(num);
            backtrack(nums, temp);
            temp.remove(temp.size() - 1);
        }
    }
}