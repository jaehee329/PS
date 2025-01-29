class Solution {
    public void reverseString(char[] s) {
        int length = s.length;
        if (length == 1) {
            return;
        }
        int half = s.length / 2;
        for (int i = 0; i < half; i++) {
            char t = s[i];
            s[i] = s[length - i - 1];
            s[length - i - 1] = t;
        }
    }
}

