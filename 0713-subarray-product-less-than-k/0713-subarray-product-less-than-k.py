class Solution:
    def numSubarrayProductLessThanK(self, nums: list[int], k: int) -> int:
        if k <= 1:
          return 0
        left = 0
        curr_product = 1
        count = 0

        for right in range(len(nums)):
            curr_product *= nums[right]

            while curr_product >= k:
                curr_product //= nums[left]
                left += 1

            count += right - left + 1

        return count