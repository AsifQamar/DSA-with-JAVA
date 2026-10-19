class Solution:
    def topKFrequent(self, arr: list[int], k: int) -> list[int]:
        hashmap = {}
        for x in arr:
            if x in hashmap:
                hashmap[x] += 1
            else:
                hashmap[x] = 1

        ans = sorted(hashmap.items(), key=lambda x: x[1], reverse=True)
        result = []
        for i in range(k):
            result.append(ans[i][0])
        return result