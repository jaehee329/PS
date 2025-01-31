class Solution {
    public String[] reorderLogFiles(String[] logs) {
        // 1. digit log와 letter log들을 구분한다.
        // letter의 경우 identifier 제외 -> identifier number -> 전체 문자열 idx
        List<LetterLog> letters =  new ArrayList<>();
        List<String> digits = new ArrayList<>();
        
        int length = logs.length;
        for (int i = 0; i < length; i++) {
            String log = logs[i];
            LetterLog letterLog = new LetterLog(log, i);
            if (letterLog.nonIdentifiered == null) {
                digits.add(log);
                continue;
            }
            letters.add(letterLog);
        }
        // 2. identifier를 제외한 letter log들을 사전순으로 정렬한다.
        letters.sort(Comparator.comparing(LetterLog::getNonIdentifiered).thenComparing(LetterLog::getIdentifier));
        // 3. 합친다.
        String[] sorted = new String[logs.length];
        int i = 0;
        for (LetterLog letter : letters) {
            sorted[i] = logs[letter.idx];
            i++;
        }

        for (String digit : digits) {
            sorted[i] = digit;
            i++;
        }
        return sorted;
    }

    private class LetterLog {
        final String nonIdentifiered;
        final String identifier;
        final int idx;

        public LetterLog(String log, int idx) {
            int spaceIdx = log.indexOf(" ");
            if (Character.isDigit(log.charAt(spaceIdx + 1))) {
                this.nonIdentifiered = null;
                this.identifier = null;
                this.idx = -1;
                return;
            }
            this.nonIdentifiered = log.substring(spaceIdx + 1, log.length());
            this.identifier = log.substring(0, spaceIdx);
            this.idx = idx;
        }

        public String getNonIdentifiered() {
            return this.nonIdentifiered;
        }

        public String getIdentifier() {
            return this.identifier;
        }

        public int getIdx() {
            return this.idx;
        }
    }
}
