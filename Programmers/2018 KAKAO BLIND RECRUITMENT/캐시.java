import java.util.*;

class Solution {
    public static int solution(int cacheSize, String[] cities) {
        TreeMap<Integer, String> cacheOrder = new TreeMap<>();
        Map<String, Integer> cache = new HashMap<>();
        int cost = 0;
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (cache.containsKey(city)) {
                cost += 1;
                int order = cache.get(city);
                cacheOrder.remove(order);
                cacheOrder.put(i, city);
                cache.put(city, i);
            } else {
                cost += 5;
                if (cache.size() < cacheSize) {
                    cache.put(city, i);
                    cacheOrder.put(i, city);
                } else {
                    Map.Entry<Integer, String> entry = cacheOrder.firstEntry();
                    if (Objects.isNull(entry)) {
                        continue;
                    }
                    int oldestOrder = entry.getKey();
                    String oldestCity = entry.getValue();
                    cacheOrder.remove(oldestOrder);
                    cache.remove(oldestCity);
                    cacheOrder.put(i, city);
                    cache.put(city, i);
                }
            }
        }
        return cost;
    }
}