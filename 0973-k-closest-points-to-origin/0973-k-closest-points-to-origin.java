class Solution {
    public int[][] kClosest(int[][] points, int k) {
        quickSelect(points, 0, points.length - 1, k);

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            result[i] = points[i];
        }

        return result;
    }

    private void quickSelect(int[][] points, int left, int right, int k) {
        if (left >= right) return;

        int pivot = partition(points, left, right);

        if (pivot == k) return;

        if (pivot < k) {
            quickSelect(points, pivot + 1, right, k);
        } else {
            quickSelect(points, left, pivot - 1, k);
        }
    }

    private int partition(int[][] points, int left, int right) {
        int[] pivot = points[right];
        int pivotDist = distance(pivot);

        int i = left;

        for (int j = left; j < right; j++) {
            if (distance(points[j]) <= pivotDist) {
                int[] temp = points[i];
                points[i] = points[j];
                points[j] = temp;
                i++;
            }
        }

        int[] temp = points[i];
        points[i] = points[right];
        points[right] = temp;

        return i;
    }

    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}