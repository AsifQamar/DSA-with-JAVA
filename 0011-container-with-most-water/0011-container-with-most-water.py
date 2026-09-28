class Solution:
    def maxArea(self, arr: list[int]) -> int:
        l = 0
        r = len(arr)-1
        max_area = float('-inf')

        while l < r:
            width = r - l
            height = min(arr[l] , arr[r])
            max_area = max(max_area , width * height)
            if arr[l] < arr[r]:
                l+=1
            else:
                r-=1
        return max_area

        