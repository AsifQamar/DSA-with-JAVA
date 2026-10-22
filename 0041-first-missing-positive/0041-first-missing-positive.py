class Solution:
    def firstMissingPositive(self, arr: list[int]) -> int:
        n = len(arr)
        i = 0

        while i < n:
            x = arr[i]
            if 1 <= x <= n and arr[x - 1] != x:
                arr[i], arr[x - 1] = arr[x - 1], arr[i]
            else:
                i += 1

        for i in range(n):
            if arr[i] != i + 1:
                return i + 1
        return n + 1
        