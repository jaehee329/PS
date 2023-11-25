import java.util.HashMap;
import java.util.Map;

class Solution1 {

    private Map<String, Integer> ids = new HashMap<>();

    public int solution(String[] friends, String[] gifts) {
        setIds(friends);
        int[][] records = new int[friends.length][friends.length];
        int[][] presentRate = new int[friends.length][2];

        for (String record : gifts) {
            String[] splitted = record.split(" ");
            String from = splitted[0];
            String to = splitted[1];

            givePresent(from, to, records, presentRate);
        }

        int[] expectations = expectNextMonth(records, presentRate);
        int max = 0;
        for (int expectation : expectations) {
            max = Math.max(max, expectation);
        }
        return max;
    }

    private void setIds(String[] friends) {
        int length = friends.length;
        for (int i = 0; i < length; i++) {
            ids.put(friends[i], i);
        }
    }

    private void givePresent(String from, String to, int[][] records, int[][] presentRate) {
        int fromId = ids.get(from);
        int toId = ids.get(to);
        records[fromId][toId]++;
        presentRate[fromId][0]++;
        presentRate[toId][1]++;
    }

    private int[] expectNextMonth(int[][] records, int[][] presentRate) {
        int length = records.length;
        int[] expectation = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int givenCount = records[i][j];
                int takenCount = records[j][i];
                if (givenCount > takenCount) {
                    expectation[i]++;
                } else if (givenCount < takenCount) {
                    expectation[j]++;
                } else {
                    int giverPresentRate = presentRate[i][0] - presentRate[i][1];
                    int takerPresentRate = presentRate[j][0] - presentRate[j][1];
                    if (giverPresentRate > takerPresentRate) {
                        expectation[i]++;
                    } else if (giverPresentRate < takerPresentRate) {
                        expectation[j]++;
                    }
                }
            }
        }
        return expectation;
    }
}
