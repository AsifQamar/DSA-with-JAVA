class Solution:
    def searchMatrix(self, arr: List[List[int]], x: int) -> bool:
        m = len(arr)
        n = len(arr[0])

        left = 0
        right = m * n - 1

        while left <= right:
            mid = (left + right) // 2
            row = mid // n
            col = mid % n

            if arr[row][col] == x:
                return True
            elif arr[row][col] < x:
                left = mid + 1
            else:
                right = mid - 1
        return False