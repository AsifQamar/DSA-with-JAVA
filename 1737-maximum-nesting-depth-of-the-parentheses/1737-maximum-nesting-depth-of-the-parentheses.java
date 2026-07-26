class Solution {
    public int maxDepth(String s) {
        int ans = 0 ;
        int count = 0;

        for(Character c : s.toCharArray()){
            if(c == '('){
                count++;
            }else if(c == ')'){
                count--;
            }
            ans = Math.max(ans , count);
        }
        return ans;
        
    }
}