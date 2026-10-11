class Solution:
    def findMiddleIndex(self, nums: list[int]) -> int:
        total = sum(nums)
        left_sum = 0
        exists =False
        for i in range(len(nums)):
            right_sum = total - left_sum - nums[i]
            if right_sum == left_sum:
                return i
                exists = True
                break
            else:
                left_sum+=nums[i]
        if exists == False:
            return -1