import java.util.*;

// 정확도 50%정도만 통과
public class Solution4 {
    public int solution(int coin, int[] cards) {
        // 손패
        Set<Integer> hands = new HashSet<>();
        int initialHands = cards.length / 3;
        for (int i = 0; i < initialHands; i++) {
            hands.add(cards[i]);
        }
        // 코인을 쓰지 않고 버린 카드
        Set<Integer> stashed = new HashSet<>();
        // 초기 조합 탐색
        int target = cards.length + 1;
        int combinations = findCombinations(hands, target);
        int round = 0;
        do {
            round++;
            if (initialHands + (round - 1) * 2 >= cards.length) {
                round--;
                break;
            }
            int firstDraw = cards[initialHands + (round - 1) * 2];
            int secondDraw = cards[initialHands + (round - 1) * 2 + 1];
            // 당장의 손패와 더해 n+1을 만들 수 있다면 coin 사용.
            if (coin == 0) {
                continue;
            }
            if (hasCurrentCombinationWith(firstDraw, hands, target)) {
                hands.add(firstDraw);
                combinations++;
                coin--;
            }
            if (coin == 0) {
                continue;
            }
            if (hasCurrentCombinationWith(secondDraw, hands, target)) {
                hands.add(secondDraw);
                combinations++;
                coin--;
            }
            // 당장 조합을 만들 순 없지만 생존 가능한 미래 내에서 조합되면 뽑는다.
            if (coin == 0) {
                continue;
            }
            if (!hands.contains(firstDraw) && isUsefulInFuture(firstDraw, round, combinations, cards)) {
                hands.add(firstDraw);
                coin--;
            }
            if (coin == 0) {
                continue;
            }
            if (!hands.contains(secondDraw) && isUsefulInFuture(secondDraw, round, combinations, cards)) {
                hands.add(secondDraw);
                coin--;
            }
            // 당장 필요하지 않았으면 버린다
            if (!hands.contains(firstDraw)) {
                stashed.add(firstDraw);
            }
            if (!hands.contains(secondDraw)) {
                stashed.add(secondDraw);
            }
            // 끝날 상황에서 코인 2개를 써서 버린 카드 중의 조합을 찾아본다
            if (coin < 2 || round < combinations) {
                continue;
            }
            if (findFromStashed(stashed, target)) {
                combinations++;
                coin -= 2;
            }

        } while (round <= combinations);

        return round;
    }

    private int findCombinations(Set<Integer> hands, int target) {
        int count = 0;
        Set<Integer> used = new HashSet<>(hands.size());
        for (Integer unused : hands) {
            int pair = target - unused;
            if (hands.contains(pair) && !used.contains(pair)) {
                count++;
                used.add(unused);
                used.add(pair);
            }
        }
        return count;
    }

    private boolean hasCurrentCombinationWith(int draw, Set<Integer> hands, int target) {
        return hands.contains(target - draw);
    }

    private boolean isUsefulInFuture(int draw, int round, int combinations, int[] cards) {
        int target = cards.length + 1;
        int nearestFuture = Math.min(cards.length / 3 + round * 2, cards.length - 1);
        int maxFuture = Math.min(cards.length / 3 + (round + combinations) * 2 - 1, cards.length - 1);

        for (int i = nearestFuture; i <= maxFuture; i++) {
            if (cards[i] == target - draw) {
                return true;
            }
        }
        return false;
    }

    private boolean canCombineWithStashed(int draw, Set<Integer> stashed, int target) {
        return stashed.contains(target - draw);
    }

    private boolean findFromStashed(Set<Integer> stashed, int target) {
        boolean isPossible = false;
        int pair1 = 0;
        int pair2 = 0;
        for (Integer unused : stashed) {
            int pair = target - unused;
            if (stashed.contains(pair)) {
                pair1 = unused;
                pair2 = pair;
                isPossible = true;
                break;
            }
        }
        stashed.remove(pair1);
        stashed.remove(pair2);
        return isPossible;
    }
}
