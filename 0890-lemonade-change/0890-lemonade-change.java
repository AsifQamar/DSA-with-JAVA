class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for(int i = 0 ; i <bills.length ; i++){
            if(bills[i] == 5){
                five=five+1;
            }else if(bills[i] == 10){
                if (five > 0){
                    five-=1;
                    ten+=1;
                }else{
                    return false;
                }
            } else{
                if(ten> 0 && five > 0){
                    five-=1;
                    ten-=1;
                } else if (five>=3){
                    five-=3;
                }else{
                    return false;
                }
            }

        }
        return true;
    }
}