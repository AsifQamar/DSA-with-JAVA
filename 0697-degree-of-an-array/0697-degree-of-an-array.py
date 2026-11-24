class Solution:
    def findShortestSubArray(self, nums: list[int]) -> int:
        count = {}
        left = {}
        right = {}
        for i, num in enumerate(nums):
            count[num] = count.get(num, 0) + 1
            if num not in left:
                left[num] = i
            right[num] = i
        degree = max(count.values())
        res = float('inf')
        for num in count:
            if count[num] == degree:
                res = min(res, right[num] - left[num] + 1)
        return res
        