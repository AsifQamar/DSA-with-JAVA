class Solution:
    def findMin(self, arr: List[int]) -> int:

        left = 0
        right = len(arr)-1

        while left< right:
            mid = (left+right)//2

            if arr[mid] > arr[right]:
                left = mid+1
            else:
                right = mid
        return arr[left]