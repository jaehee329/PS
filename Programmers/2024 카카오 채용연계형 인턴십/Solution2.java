import java.util.*;

public class Solution2 {

    private static Map<Integer, Node> graph;
    private static Set<Integer> unvisit;

    public int[] solution(int[][] edges) {
        graph = new HashMap<>(edges.length);
        unvisit = new HashSet<>(edges.length);
        for (int[] edge : edges) {
            int src = edge[0];
            int dst = edge[1];
            if (!graph.containsKey(src)) {
                graph.put(src, new Node(src));
                unvisit.add(src);
            }
            if (!graph.containsKey(dst)) {
                graph.put(dst, new Node(dst));
                unvisit.add(dst);
            }
            graph.get(src).addDest(dst);
            graph.get(dst).addSrc(src);
        }

        int[] answer = new int[4];
        Queue<Integer> uncheckedQueue = new LinkedList<>(graph.keySet());
        while (uncheckedQueue.size() > 1) {
            int src = selectNoneOriginSource(uncheckedQueue);
            // 생성 정점만 남았다면 종료
            if (src == -1) {
                break;
            }
            if (unvisit.contains(src)) {
                search(src, answer);
            }
        }
        int last = uncheckedQueue.poll();
        answer[0] = last;

        return answer;
    }

    // 생성 정점을 피해서 탐색을 시작할 정점 반환
    private int selectNoneOriginSource(Queue<Integer> uncheckedQueue) {
        while (uncheckedQueue.size() > 1) {
            int src = uncheckedQueue.poll();
            if (!unvisit.contains(src)) {
                continue;
            }
            if (graph.get(src).dest.size() < 2) {
                return src;
            } else {
                uncheckedQueue.add(src);
            }
        }
        return -1;
    }

    private void search(int start, int[] answer) {
        Stack<Integer> stack = new Stack<>();
        stack.add(start);
        boolean foundAnswer = false;
        // dfs
        while (!stack.isEmpty()) {
            int src = stack.pop();
            unvisit.remove(src);
            Node node = graph.get(src);
            List<Integer> dsts = node.dest;
            // 목적지가 0개면 막대
            if (dsts.size() == 0) {
                foundAnswer = true;
                answer[2]++;
                // 역추적
                backtrack(start);
                continue;
            }
            int firstDst = dsts.get(0);
            if (unvisit.contains(firstDst)) {
                stack.add(firstDst);
            }

            // 목적지가 2개면 8자
            if (dsts.size() == 2) {
                answer[3]++;
                foundAnswer = true;
                int secondDst = dsts.get(1);
                if (unvisit.contains(secondDst)) {
                    stack.add(secondDst);
                }
            }
        }
        if (!foundAnswer) {
            answer[1]++;
        }
    }

    // 막대일 때 뒤쪽의 노드들 방문처리
    private void backtrack(int start) {
        int current = start;
        while (true) {
            Node srcNode = graph.get(current);
            if (srcNode.src.size() == 0) {
                return;
            }
            if (srcNode.src.size() == 1) {
                int parent = srcNode.src.get(0);
                // 부모가 자신 이외의 다른 곳과 인접한다면 생성 정점
                if (graph.get(parent).dest.size() != 1) {
                    return;
                }
                unvisit.remove(parent);
                current = parent;
                continue;
            }
            // 생성 정점과 결합된 노드인 경우
            int parent1 = srcNode.src.get(0);
            int parent2 = srcNode.src.get(1);
            // 첫 번째 부모가 생성 정점이라면
            if (graph.get(parent1).dest.size() != 1) {
                unvisit.remove(parent2);
                current = parent2;
                continue;
            }
            unvisit.remove(parent1);
            current = parent1;
        }
    }

    private static class Node {
        private final int number;
        private final List<Integer> dest;
        private final List<Integer> src;

        public Node(int number) {
            this.number = number;
            this.dest = new ArrayList<>();
            this.src = new ArrayList<>();
        }

        private void addDest(int to) {
            dest.add(to);
        }

        private void addSrc(int from) {
            src.add(from);
        }
    }
}
