class Solution:
    def maxScore(self, arr: list[int], k: int) -> int:

        n = len(arr)
        total = sum(arr)

        window_size = n - k

        if window_size == 0:
            return total

        cur_sum = sum(arr[:window_size])
        min_sum = cur_sum

        for i in range(1, n - window_size + 1):
            cur_sum = cur_sum - arr[i - 1] + arr[i + window_size - 1]
            min_sum = min(min_sum, cur_sum)

        return total - min_sum