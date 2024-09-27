import java.io.*;
import java.util.*;

// 배열 내 원소들의 변화율 경향성이 일치하는 배열의 쌍 수 구하기.
// 각 배열들을 크기 순으로 normalize한 후, 배열의 모든 원소를 문자열로 더해버린 뒤 Objects.hash().
// 같은 해시값을 가지는 쌍을 구한다. 세 배열이 서로 일치하면 2 + 1 = 3쌍이 구해지며, 네 배열이 서로 일치하면 3 + 2 + 1 = 6쌍이 구해진다.
public class a18869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int spaceCount = Integer.parseInt(st.nextToken());
        int planetCount = Integer.parseInt(st.nextToken());
        int[][] spaces = new int[spaceCount][planetCount];
        int[][] copy = new int[spaceCount][planetCount];
        for (int i = 0; i < spaceCount; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < planetCount; j++) {
                int elem = Integer.parseInt(st.nextToken());
                spaces[i][j] = elem;
                copy[i][j] = elem;
            }
        }

        int[][] normalizedSpaces = normalize(spaces, copy);
        String[] stringifiedSpaces = stringify(normalizedSpaces);

        Map<String, Integer> map = new HashMap<>();
        int pairs = 0;
        for (int i = 0; i < spaceCount; i++) {
            String stringifiedSpace = stringifiedSpaces[i];
            if (!map.containsKey(stringifiedSpace)) {
                map.put(stringifiedSpace, 0);
            } else {
                map.put(stringifiedSpace, map.get(stringifiedSpace) + 1);
                pairs += map.get(stringifiedSpace);
            }
        }
        System.out.println(pairs);
    }

    private static int[][] normalize(int[][] space, int[][] copy) {
        int[][] normalized = new int[space.length][space[0].length];
        int rowCount = space.length;
        for (int i = 0; i < rowCount; i++) {
            int[] row = copy[i];
            Arrays.sort(row);
            Map<Integer, Integer> rankMap = new HashMap<>();
            int rank = 0;
            for (int elem : row) {
                if (!rankMap.containsKey(elem)) {
                    rankMap.put(elem, rank);
                    rank++;
                }
            }

            row = space[i];
            for (int j = 0; j < row.length; j++) {
                normalized[i][j] = rankMap.get(row[j]);
            }
        }
        return normalized;
    }

    private static String[] stringify(int[][] normalizedSpaces) {
        String[] stringified = new String[normalizedSpaces.length];
        StringBuilder sb;
        for (int i = 0; i < stringified.length; i++) {
            int[] row = normalizedSpaces[i];
            sb = new StringBuilder();
            for (int j = 0; j < row.length; j++) {
                sb.append(Integer.toString(row[j]));
            }
            stringified[i] = sb.toString();
        }
        return stringified;
    }
}
