import heapq
class Solution:
    def findKthLargest(self, nums: list[int], k: int) -> int:
        heap=[]
        for num in nums:
            heapq.heappush_max(heap, num)

        for i in range(k):
            largest = heapq.heappop_max(heap)

        return largest

        