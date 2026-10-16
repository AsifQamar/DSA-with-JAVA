class Solution:
    def grayCode(self, n: int) -> list[int]:
        size = 1 << n
        res = []
        for i in range(size):
            res.append(i ^ (i >> 1))
        return res
        