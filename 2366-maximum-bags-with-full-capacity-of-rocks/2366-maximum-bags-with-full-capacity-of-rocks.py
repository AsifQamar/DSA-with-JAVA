class Solution:
    def maximumBags(self, capacity: List[int], rocks: List[int], additionalRocks: int) -> int:
        need = []

        for i in range(len(capacity)):
            need.append(capacity[i] - rocks[i])

        need.sort()

        ans = 0

        for x in need:
            if additionalRocks >= x:
                additionalRocks -= x
                ans += 1
            else:
                break

        return ans