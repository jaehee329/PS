class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = Arrays.stream(banned).collect(Collectors.toSet());
        String[] words = paragraph.split("[\\s!?,;'.]+");
        int length = words.length;
        int maxFreq = 0;
        String maxFreqWord = "";
        Map<String, Integer> frequency = new HashMap<>();
        for (int i = 0; i < length; i++) {
            String refined = words[i].toLowerCase();
            if (bannedSet.contains(refined)) {
                continue;
            }
            if (frequency.containsKey(refined)) {
                frequency.put(refined, frequency.get(refined) + 1);
            } else {
                frequency.put(refined, 1);
            }
            if (frequency.get(refined) + 1 > maxFreq) {
                maxFreq = frequency.get(refined) + 1;
                maxFreqWord = refined;    
            }
        }
        return maxFreqWord;
    }
}

