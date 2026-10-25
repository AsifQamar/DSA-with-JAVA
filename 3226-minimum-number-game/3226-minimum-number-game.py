class Solution:
    def numberGame(self, v: List[int]) -> List[int]:
        n = len(v)
        v.sort()
        for i in range(0, n, 2):
            if i + 1 < n:
                v[i], v[i + 1] = v[i + 1], v[i]
        return v
        
        