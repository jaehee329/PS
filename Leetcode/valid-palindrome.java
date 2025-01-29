class Solution {
    public boolean isPalindrome(String s) {
        char[] charArr = s.toCharArray();
        char[] filteredArr = new char[charArr.length];

        int length = 0;
        for (int i = 0; i < charArr.length; i++) {
            char target = charArr[i];
            if (target >= 'a' && target <= 'z' || target >= '0' && target <= '9') {
                filteredArr[length] = target;
                length++;
            } else if (target >= 'A' && target <= 'Z') {
                filteredArr[length] = Character.toLowerCase(target);
                length++;
            }
        }

        filteredArr = Arrays.copyOfRange(filteredArr, 0, length);

        if (filteredArr.length == 1) {
            return true;
        }

        for (int i = 0; i < length / 2; i++) {
            if (filteredArr[i] != filteredArr[length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}

