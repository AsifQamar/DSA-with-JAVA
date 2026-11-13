class Solution:
    def search(self, arr: list[int], x: int) -> bool:
        left = 0
        right = len(arr)-1

        while left<=right:
            mid = (left+right)//2

            if arr[mid] == x:
                return True
                break
            if arr[left] == arr[mid] ==arr[right]:
                left+=1
                right-=1
            elif arr[left] <= arr[mid]:
                if arr[left] <= x < arr[mid]:
                    right = mid-1
                else:
                    left = mid+1
            else:
                if arr[mid] < x <= arr[right]:
                    left = mid+1
                else:
                    right = mid-1
        return False

