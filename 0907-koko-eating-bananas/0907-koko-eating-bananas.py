class Solution:
    def minEatingSpeed(self, arr: list[int], h: int) -> int:
        left =1
        right = max(arr)
        min_speed = right

        while left <= right:
            eating_speed = (left +right)//2

            total_hr = 0
            for bananas in arr:
                needed_hr = (bananas + eating_speed-1)//eating_speed
                total_hr += needed_hr

            if total_hr <= h:
                min_speed = eating_speed
                right = eating_speed -1
            else:
                left = eating_speed+1
        return min_speed

        