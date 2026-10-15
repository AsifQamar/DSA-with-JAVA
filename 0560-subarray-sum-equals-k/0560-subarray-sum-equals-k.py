class Solution:
    def subarraySum(self, nums: list[int], k: int) -> int:
        prefix_map = {0: 1}
        current_sum = 0
        count = 0

        for i in range(len(nums)):
            current_sum += nums[i]

            needed = current_sum - k

            if needed in prefix_map:
                count += prefix_map[needed]

            if current_sum in prefix_map:
                prefix_map[current_sum] += 1
            else:
                prefix_map[current_sum] = 1

        return count