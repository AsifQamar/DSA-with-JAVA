class Solution:
    def pivotIndex(self, arr: list[int]) -> int:
        n = len(arr)
        leftsum = [0] * n
        leftsum[0] = arr[0]

        for i in range(1 , n):
            leftsum[i]= leftsum[i-1] +arr[i]

        rightsum = [0]*n
        rightsum[n-1] = arr[n-1]

        for i in range(n-2 , -1 ,-1):
            rightsum[i] = rightsum[i+1] +arr[i]

        for i in range(n):
                left = leftsum[i ] 
                right = rightsum[i] 
                if left == right:
                    return i
        return -1
