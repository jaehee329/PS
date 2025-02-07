class Solution {
    public String longestPalindrome(String s) {
        String longestPalindrome = "";
        int length = s.length();
        for (int i = 0; i < length; i++) {
            String evenLpc = getLongestEvenLengthPalindromeFromCenterLeft(i, s);
            String oddLpc = getLongestOddLengthPalindromeFromCenter(i, s);
            String longer = oddLpc.length() > evenLpc.length() ? oddLpc : evenLpc;
            longestPalindrome = longer.length() > longestPalindrome.length() ? longer : longestPalindrome;
        }
        return longestPalindrome;
    }

    public String getLongestEvenLengthPalindromeFromCenterLeft(int index, String s) {
        int leftPoint = index;
        int rightPoint = index + 1;
        int length = s.length();
        String lpc = "";
        while (true) {
            if (leftPoint < 0 || rightPoint >= length) {
                break;
            }
            char leftChar = s.charAt(leftPoint);
            char rightChar = s.charAt(rightPoint);
            if (leftChar == rightChar) {
                StringBuilder sb = new StringBuilder();
                sb.append(leftChar).append(lpc).append(rightChar);
                lpc = sb.toString();
                leftPoint--;
                rightPoint++;
            } else {
                break;
            }
        }
        return lpc;
    }

    public String getLongestOddLengthPalindromeFromCenter(int index, String s) {
        int leftPoint = index - 1;
        int rightPoint = index + 1;
        int length = s.length();
        String lpc = Character.toString(s.charAt(index));
        while (true) {
            if (leftPoint < 0 || rightPoint >= length) {
                break;
            }
            char leftChar = s.charAt(leftPoint);
            char rightChar = s.charAt(rightPoint);
            if (leftChar == rightChar) {
                StringBuilder sb = new StringBuilder();
                sb.append(leftChar).append(lpc).append(rightChar);
                lpc = sb.toString();
                leftPoint--;
                rightPoint++;
            } else {
                break;
            }
        }
        return lpc;
    }
}