class Solution:
    def leastInterval(self, tasks: list[str], n: int) -> int:
        freq = list(Counter(tasks).values())
        heapq.heapify_max(freq)

        time = 0

        while freq:
            temp = []
            cycle = n + 1

            while cycle > 0 and freq:
                count = heapq.heappop_max(freq) - 1

                if count > 0:
                    temp.append(count)

                time += 1
                cycle -= 1

            for count in temp:
                heapq.heappush_max(freq, count)

            if freq:
                time += cycle

        return time