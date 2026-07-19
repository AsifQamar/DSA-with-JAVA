class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right =0;
        for(int num:nums){
            right = Math.max(num,right);
        }
        while(left <= right){
            int mid = left +(right-left)/2;
            if(fun(nums , mid) <= threshold){
                right = mid-1;
            }else{
                left = mid+1;
            }

        }
        return left;
    }

    public int fun(int[] nums , int d){
        int sum = 0 ;
        for(int i = 0 ; i <= nums.length-1 ;i++){
            sum+= (int)Math.ceil((double)nums[i]/d);
        }
        return sum;
    } 
}