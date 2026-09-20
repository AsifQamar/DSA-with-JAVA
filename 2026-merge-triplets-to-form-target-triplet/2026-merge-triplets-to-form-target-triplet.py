class Solution:
    def mergeTriplets(self, triplets: List[List[int]], target: List[int]) -> bool:
        curr = [0, 0, 0]

        for triplet in triplets:
            if triplet[0] > target[0] or triplet[1] > target[1] or triplet[2] > target[2]:
                continue

            curr[0] = max(curr[0], triplet[0])
            curr[1] = max(curr[1], triplet[1])
            curr[2] = max(curr[2], triplet[2])

        return curr == target