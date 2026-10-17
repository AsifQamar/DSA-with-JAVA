class Solution:
    def longestConsecutive(self, arr: list[int]) -> int:
        n = len(arr)
        seen =set()
        for x in arr:
            seen.add(x)
        
        max_len = 0
        for x in seen:
            if x-1 not in seen:
                curr = x
                curr_len = 1

                while curr+1 in seen:
                    curr+=1
                    curr_len+=1
                
                max_len = max(max_len , curr_len)
        return max_len

