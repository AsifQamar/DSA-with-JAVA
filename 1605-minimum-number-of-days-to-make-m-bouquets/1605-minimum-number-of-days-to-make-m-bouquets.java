class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) return -1;
        int left = 1;
        int right = 0 ;
        for(int b:bloomDay) right = Math.max(b,right);

        while(left <= right){
            int mid = left +(right-left)/2;
            if(possible(bloomDay , mid , m , k) ){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return left;
        
    }

    public boolean possible(int [] arr , int day , int m , int k ){
        int count =0;
        int noOfbouquets = 0;

        for(int i = 0 ; i <= arr.length-1 ; i++){
            if(arr[i]<= day){
                count++;
            }
            else{
                noOfbouquets += (count/k);
                count = 0;
            }
        }
        noOfbouquets += (count / k);
        if(noOfbouquets >= m){
            return true;
        }else return false;
    }
}