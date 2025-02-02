class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String str : strs) {
            String key = toIntegrated(str);
            if (!anagrams.containsKey(key)) {
                List<String> words = new ArrayList<>();
                words.add(str);
                anagrams.put(key, words);
            } else {
                List<String> words = anagrams.get(key);
                words.add(str);
            }
        }
        return new ArrayList<>(anagrams.values());
    }

    private String toIntegrated(String word) {
        char[] frequency = toFrequency(word);
        return new String(frequency);
    }

    private char[] toFrequency(String word) {
        char[] frequency = new char[26];
        char[] charArr = word.toCharArray();
        for (char c : charArr) {
            frequency[c - 'a']++;
        }
        return frequency;
    }
}

