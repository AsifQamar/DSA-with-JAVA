class Solution:
    def maxTurbulenceSize(self, arr: list[int]) -> int:
        ans = 1
        curr = 1

        for i in range(1, len(arr)):
            if arr[i] == arr[i - 1]:
                curr = 1

            elif i == 1 or (arr[i] > arr[i - 1]) != (arr[i - 1] > arr[i - 2]):
                curr += 1

            else:
                curr = 2

            ans = max(ans, curr)

        return ans