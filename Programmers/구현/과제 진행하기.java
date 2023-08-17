import java.util.*;

class Solution {

    private static class Plan {

        private final String name;
        private final int startMinute;
        private final int playtime;

        private Plan(String name, int startMinute, int playtime) {
            this.name = name;
            this.startMinute = startMinute;
            this.playtime = playtime;
        }

        public Plan(String[] plan) {
            this.name = plan[0];
            this.startMinute = toMinute(plan[1]);
            this.playtime = Integer.parseInt(plan[2]);
        }

        private int toMinute(String start) {
            String[] hourAndMinute = start.split(":");
            int hour = Integer.parseInt(hourAndMinute[0]);
            int minute = Integer.parseInt(hourAndMinute[1]);
            return hour * 60 + minute;
        }

        public boolean isDone(int currentMinute) {
            return startMinute + playtime <= currentMinute;
        }

        public Plan partialReduce(int currentMinute) {
            return new Plan(name, startMinute, playtime - (currentMinute - startMinute));
        }

        public Plan restart(int startMinute) {
            return new Plan(this.name, startMinute, this.playtime);
        }

        public int getStartMinute() {
            return startMinute;
        }
    }
    public String[] solution(String[][] plans) {
        int planCount = plans.length;
        String[] answer = new String[planCount];
        LinkedList<Plan> planList = new LinkedList<>();
        for (String[] plan : plans) {
            planList.add(new Plan(plan));
        }
        planList.sort(Comparator.comparing(Plan::getStartMinute));

        Queue<Plan> planQueue = planList;
        Stack<Plan> planDelayed = new Stack<>();

        int finishRank = 0;
        int currentMin = 0;
        Plan currentPlan = null;
        while (!planQueue.isEmpty()) {
            if (Objects.nonNull(currentPlan) && currentPlan.isDone(currentMin)) {
                answer[finishRank++] = currentPlan.name;
                currentPlan = null;
            }
            if (Objects.nonNull(currentPlan)) {
                if (planQueue.peek().startMinute <= currentMin) {
                    planDelayed.add(currentPlan.partialReduce(currentMin));
                    currentPlan = planQueue.poll();
                }
            } else if(planQueue.peek().startMinute <= currentMin) {
                currentPlan = planQueue.poll();
            } else if(!planDelayed.isEmpty()) {
                currentPlan = planDelayed.pop().restart(currentMin);
            }
            currentMin++;
        }
        answer[finishRank++] = currentPlan.name;

        while (!planDelayed.isEmpty()) {
            Plan plan = planDelayed.pop();
            answer[finishRank++] = plan.name;
        }

        return answer;
    }
}
