class Solution:
    def findNthDigit(self, n: int) -> int:
        digit_length = 1
        numbers_count = 9
        start_number = 1

        while n > digit_length * numbers_count:
            n -= digit_length * numbers_count
            digit_length += 1
            numbers_count *= 10
            start_number *= 10

        number = start_number + (n - 1) // digit_length
        digit_index = (n - 1) % digit_length

        return int(str(number)[digit_index])