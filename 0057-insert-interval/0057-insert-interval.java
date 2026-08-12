class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            list.add(interval);
        }
        list.add(newInterval);
        list.sort((a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        for (int[] interval : list) {

            if (result.isEmpty() ||
                result.get(result.size() - 1)[1] < interval[0]) {
                result.add(interval);

            } else {
                result.get(result.size() - 1)[1] =
                    Math.max(result.get(result.size() - 1)[1], interval[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}