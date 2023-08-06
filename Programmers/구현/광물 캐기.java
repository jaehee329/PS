import java.util.*;

class Solution {

    private enum Mineral {
        diamond(25),
        iron(5),
        stone(1);

        public final int hardness;

        Mineral(int hardness) {
            this.hardness = hardness;
        }

        public static Mineral from(String mineral) {
            return valueOf(mineral);
        }

        public static int hardnessOf(String mineral) {
            return from(mineral).hardness;
        }
    }

    private enum Pick {
        DIA(25),
        IRON(5),
        STONE(1);

        private final int power;

        Pick(int power) {
            this.power = power;
        }

        public static int getCost(int order, int[] picks, String mineral) {
            int pickOrder = getPickOrder(order, picks);
            return toPick(pickOrder).costOf(Mineral.from(mineral));
        }

        private static int getPickOrder(int order, int[] picks) {
            if (order + 1 <= picks[0]) {
                return 0;
            } else if (order + 1 <= picks[0] + picks[1]) {
                return 1;
            } else {
                return 2;
            }
        }

        private int costOf(Mineral mineral) {
            int cost = mineral.hardness / power;
            return (cost != 0) ? cost : 1;
        }

        private static Pick toPick(int pickOrder) {
            if (pickOrder == 0) {
                return DIA;
            } else if (pickOrder == 1) {
                return IRON;
            } else {
                return STONE;
            }
        }
    }

    private class Group {

        private int groupCost;
        private List<String> minerals;

        public Group(int groupCost, List<String> minerals) {
            this.groupCost = groupCost;
            this.minerals = minerals;
        }

        public int getCost(int order, int[] picks) {
            int groupCost = 0;
            for (String mineral : minerals) {
                groupCost += Pick.getCost(order, picks, mineral);
            }
            return groupCost;
        }

        public int getGroupCost() {
            return groupCost;
        }
    }

    public int solution(int[] picks, String[] minerals) {
        int picksCount = picks[0] + picks[1] + picks[2];
        int mineableCount = Math.min(minerals.length, picksCount * 5);
        int groupCount = mineableCount / 5 + ((mineableCount % 5 == 0) ? 0 : 1);
        List<Group> groups = new ArrayList<>(groupCount);
        for (int i = 0; i < groupCount; i++) {
            int groupCost = 0;
            List<String> mineralList = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                int mineralIdx = 5 * i + j;
                if (mineralIdx >= mineableCount) {
                    continue;
                }
                groupCost += Mineral.hardnessOf(minerals[mineralIdx]);
                mineralList.add(minerals[mineralIdx]);
            }
            groups.add(new Group(groupCost, mineralList));
        }

        groups.sort(Comparator.comparing(Group::getGroupCost).reversed());
        int totalCost = 0;
        for (int i = 0; i < groupCount; i++) {
            totalCost += groups.get(i).getCost(i, picks);
        }
        return totalCost;
    }
}
