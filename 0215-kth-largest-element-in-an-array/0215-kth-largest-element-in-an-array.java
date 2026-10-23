class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int num : nums){
            heap.offer(num);
        }
        int large = Integer.MIN_VALUE;
        for(int i = 0 ; i <k ; i++){
            large = heap.poll();  
        }
        return large;      
    }
}