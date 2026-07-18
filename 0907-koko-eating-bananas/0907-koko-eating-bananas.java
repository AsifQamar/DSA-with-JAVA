class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1 ; int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while(left <= right){
            int mid= left +(right - left) /2;
            if(fun(piles , mid) <=h){
                right = mid-1;
            }else{
                left = mid +1;
            }
        }
          return left;
    }

    public long fun(int[] piles , int hr){
        long totalhr = 0;
        for(int i = 0 ; i < piles.length ; i++){
            totalhr+= (int)Math.ceil((double)piles[i]/hr);
        }
        return totalhr;
    }

}
//O(NlogM)