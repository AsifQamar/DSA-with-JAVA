class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int first = 0;
        int last = mat.length - 1;
        int peak = -1;

        while (first < last) {
            int mid = (first + last) / 2;

            // maximum element in current row
            int curr = Integer.MIN_VALUE;
            for (int num : mat[mid]) {
                curr = Math.max(curr, num);
            }

            // maximum element in next row
            int next = Integer.MIN_VALUE;
            for (int num : mat[mid + 1]) {
                next = Math.max(next, num);
            }

            if (curr > next) {
                last = mid;
                peak = curr;
            } else {
                first = mid + 1;
                peak = next;
            }
        }

        // column index of peak
        int column = 0;
        for (int j = 0; j < mat[first].length; j++) {
            if (mat[first][j] == peak) {
                column = j;
                break;
            }
        }

        return new int[]{first, column};
    }
}