class Solution:
    def runningSum(self, nums: list[int]) -> list[int]:
        prefix_sum = []
        running_sum = 0
        for i in range(len(nums)):
            running_sum += nums[i]
            prefix_sum.append(running_sum)
        return prefix_sum