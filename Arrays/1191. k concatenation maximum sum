class Solution {

    final int MOD = 1000000007; // given in problem, final answer should be mod 10^9 + 7

    // using Kadane’s algorithm
    public int kadanes(int[] arr) {
        long current_sum = 0;
        long max_sum = 0;

        for (int i = 0; i < arr.length; i++) {
         // choose max: either start new subarray from current element
        // or continue the previous subarray by adding current element
         current_sum = Math.max(arr[i], current_sum + arr[i]);

        // update max_sum if current_sum is greater
         max_sum = Math.max(max_sum, current_sum);
}


        // return answer in modulo form
        return (int)(max_sum % MOD);
    }

    // Function to apply kadane on 2 copies of array (concatenated)
    public int kadanesoftwo(int[] arr) {
        int[] newarr = new int[arr.length * 2]; // make new array of size 2*n

        for (int i = 0; i < arr.length; i++) {
            newarr[i] = arr[i];                 // 1st copy
            newarr[i + arr.length] = arr[i];    // 2nd copy
        }

        return kadanes(newarr); // run kadane on the new array
    }

    public int kConcatenationMaxSum(int[] arr, int k) {
        long Sum = 0;

        // find total sum of original array
        for (int val : arr) Sum += val;

        // if k == 1, we just need normal kadane
        if (k == 1) {
            return kadanes(arr);
        }

        // max subarray sum from 2 copies of array
        int maxSumTwoConcat = kadanesoftwo(arr);

        // if total sum is <= 0, we can't gain anything from extra copies
        if (Sum <= 0) {
            return maxSumTwoConcat;
        } else {
            // if total sum > 0, we can add middle full arrays (k - 2) times
            long result = maxSumTwoConcat + ((k - 2) * Sum) % MOD;

            // final result mod 10^9+7
            return (int)(result % MOD);
        }
    }
}
