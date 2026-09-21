class Solution:

    def partitionLabels(self, s: str) -> list[int]:
        ends = {c: i for i, c in enumerate(s)}

        curr = 0
        ans = []

        while curr < len(s):
            last = ends[s[curr]]

            while curr <= last:
                last = max(last, ends[s[curr]])
                curr += 1

            ans.append(curr)

        result = []
        start = 0

        for end in ans:
            result.append(end - start)
            start = end

        return result