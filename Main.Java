class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while (left < right) {
            while (s.charAt(left) != ' ') left++;
            while (s.charAt(right) != ' ') right--;
if (Character.isLetter(s.charAt(left))) {
    // process letter
}char1) == Character.toLowerCase(char2)

            if (s.charAt(left). != s.charAt(right).lower()) return false;
            left++;
            right--;
        }
        return true;
    }
}