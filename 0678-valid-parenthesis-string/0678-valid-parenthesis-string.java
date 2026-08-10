class Solution {
    public boolean checkValidString(String s) {
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
                right++;
            } else if (s.charAt(i) == ')') {
                if (left > 0) left--;
                right--;
            } else {
                if (left > 0) left--;
                right++;
            }

            if (right < 0) return false;
        }

        return left == 0;
    }
}