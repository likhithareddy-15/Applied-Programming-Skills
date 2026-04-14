import java.util.*;

class Solution {
    List<int[]> list = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        Collections.sort(list, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });

        List<List<Integer>> res = new ArrayList<>();
        int prev = Integer.MIN_VALUE;

        for (int[] node : list) {
            if (node[0] != prev) {
                res.add(new ArrayList<>());
                prev = node[0];
            }
            res.get(res.size() - 1).add(node[2]);
        }

        return res;
    }

    void dfs(TreeNode root, int col, int row) {
        if (root == null) return;
        list.add(new int[]{col, row, root.val});
        dfs(root.left, col - 1, row + 1);
        dfs(root.right, col + 1, row + 1);
    }
}