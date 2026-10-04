class Solution:
    def trap(self, height: list[int]) -> int:

        l = 0
        r = len(height) - 1

        max_left = 0
        max_right = 0

        ans = 0

        while l < r:
            max_left = max(max_left, height[l])
            max_right = max(max_right, height[r])

            if max_left < max_right:
                ans += max_left - height[l]
                l += 1
            else:
                ans += max_right - height[r]
                r -= 1

        return ans