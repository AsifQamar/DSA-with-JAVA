class KthLargest:

    def __init__(self, k: int, nums: list[int]):
        self.Minheap = nums
        self.k = k
        heapq.heapify(self.Minheap)

        while len(self.Minheap) >k:
            heapq.heappop(self.Minheap)

    def add(self, val: int) -> int:
        heapq.heappush(self.Minheap , val)
        if len(self.Minheap) >self.k:
            heapq.heappop(self.Minheap)
        return self.Minheap[0]
        


# Your KthLargest object will be instantiated and called as such:
# obj = KthLargest(k, nums)
# param_1 = obj.add(val)