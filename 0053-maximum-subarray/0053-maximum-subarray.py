class Solution:
    def maxSubArray(self, arr: List[int]) -> int:
        maxending = arr[0]
        result = arr[0]

        for i in range(1, len(arr)):
            maxending = max(maxending +arr[i] , arr[i])
            result = max(result , maxending)
        
        return result
      