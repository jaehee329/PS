import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        // 중복을 허용하는 다중집합을 만든다(알파벳인지 확인 및 대문자화)
        // Map에 key - 개수로 집어넣는다.
        Map<String, Integer> multiSet1 = toMultiSet(str1);
        Map<String, Integer> multiSet2 = toMultiSet(str2);
        if (multiSet1.size() == 0 && multiSet2.size() == 0) {
            return 65536;
        }
        // 합집합 찾기: Set에 Key를 넣으며 확인했는지 체크.
        // 1번 다중집합의 Key를 순회하며 2번 다중집합의 같은 Key에 매핑되는 value가 몇개인지 비교, 큰 값 선택
        // 2번 다중집합을 순회하면서 Set에 Key를 넣지 않았다면 해당 내용까지 체크
        int union = findUnionCount(multiSet1, multiSet2);
        int intersect = findIntersectionCount(multiSet1, multiSet2);
        return 65536 * intersect / union;
    }
    
    private Map<String, Integer> toMultiSet(String str) {
        Map<String, Integer> multiSet = new HashMap<>();
        boolean foundFirst = false;
        char prev = ' ';
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (Character.isAlphabetic(cur)) {
                cur = Character.toUpperCase(cur);
                if (!foundFirst) {
                    foundFirst = true;
                } else {
                    // 두 char로 문자열을 만들고 map에 넣는다.
                    String single = new String(new char[]{prev, cur});
                    if (multiSet.containsKey(single)) {
                        multiSet.put(single, multiSet.get(single) + 1);
                    } else {
                        multiSet.put(single, 1);
                    }
                }
                prev = cur;
            } else {
                if (foundFirst) {
                    foundFirst = false;
                    prev = ' ';
                }
            }
        }
        return multiSet;
    }
    
    private int findUnionCount(Map<String, Integer> multiSet1, Map<String, Integer> multiSet2) {
        Set<String> considered = new HashSet<>();
        int count = 0;
        for (String key : multiSet1.keySet()) {
            if (multiSet2.containsKey(key)) {
                count += multiSet1.get(key) > multiSet2.get(key) ? multiSet1.get(key) : multiSet2.get(key);
                considered.add(key);
                continue;
            }
            count += multiSet1.get(key);
            considered.add(key);
        }
        for (String key : multiSet2.keySet()) {
            if (!considered.contains(key)) {
                count += multiSet2.get(key);
            }
        }
        return count;
    }
    
    private int findIntersectionCount(Map<String, Integer> multiSet1, Map<String, Integer> multiSet2) {
        int count = 0;
        for (String key : multiSet1.keySet()) {
            if (multiSet2.containsKey(key)) {
                count += multiSet1.get(key) < multiSet2.get(key) ? multiSet1.get(key) : multiSet2.get(key);
            }
        }
        return count;
    }
}