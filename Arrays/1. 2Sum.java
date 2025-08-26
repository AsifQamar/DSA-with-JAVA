class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map <Integer, Integer> map = new HashMap<>(); // creating new hashmap
        int n = nums.length; // taking n as length of array
        for (int i = 0 ; i < n ; i++) { // looping in array
            int num = target - nums[i];  //  checking if the number like n = target - num[i] is present or not
            // example if target is 9, checking if num = 9 - 2 = 7 is present or not
            if(map.containsKey(num)) // if 2 is present which is in index 0 
                return new int[] {map.get(num), i}; // create a new array with 0,1
            map.put(nums[i], i); // put index of num i which was 0 and num which is 2
        } 
        return new int[] {}; //return the new array (though won't run as one pair is always guaranteed)
    }
}
