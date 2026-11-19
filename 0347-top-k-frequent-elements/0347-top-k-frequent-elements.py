class Solution:
    def topKFrequent(self, arr: list[int], k: int) -> list[int]:
        frequency = Counter(arr)
        min_heap = []

        for num, freq in frequency.items():
            heapq.heappush(min_heap, (freq, num))

            if len(min_heap) > k:
                heapq.heappop(min_heap)
        return [num for freq, num in min_heap]