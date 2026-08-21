class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++)
            {
                if(k==0 || nums[i]>=0)break;
                nums[i]=-1*nums[i];
                k--;
                if(k<=0)break;
            }
        int sum=0;
        Arrays.sort(nums);
        for(int i=0;i<n;i++)
            sum+=nums[i];
        
        if(k%2!=0)sum-=2*nums[0];
        return sum;
    }
}