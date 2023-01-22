import java.io.*;
import java.util.*;

public class a1916_wrong {
    private static int cities;
    private static int routes;
    private static HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
    private static int src;
    private static int dst;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cities = Integer.parseInt(br.readLine());
        routes = Integer.parseInt(br.readLine());
        HashSet<Integer> unvisited = new HashSet<>();
        HashMap<Integer, Integer> dist = new HashMap<>();
        StringTokenizer st;
        for (int i = 0; i < routes; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            if (map.get(from) == null) {
                map.put(from, new HashMap<>());
            }
            HashMap<Integer, Integer> toWeight = map.get(from);
            toWeight.put(to, weight);

            if (!unvisited.contains(from)) {
                unvisited.add(from);
                dist.put(from, Integer.MAX_VALUE);
            }
            if (!unvisited.contains(to)) {
                unvisited.add(to);
                dist.put(to, Integer.MAX_VALUE);
            }
        }
        st = new StringTokenizer(br.readLine());
        src = Integer.parseInt(st.nextToken());
        dst = Integer.parseInt(st.nextToken());
        dist.put(src, 0);

        while(unvisited.size() > 0) {
            int minDist = Integer.MAX_VALUE;
            int tar = 0;
            Set<Integer> unvisitSrcs = dist.keySet();
            // 방문하지 않은 노드 중 출발지로부터 최단 거리의 출발지를 찾는다 => 우선순위 큐를 사용하여 개선 여지 있음
            for (Integer unvisitSrc : unvisitSrcs) {
                if (dist.get(unvisitSrc) < minDist && unvisited.contains(unvisitSrc)) {
                    minDist = dist.get(unvisitSrc);
                    tar = unvisitSrc;
                }
            }

            unvisited.remove(tar);
            HashMap<Integer, Integer> near = map.get(tar);
            if (near != null) {
                Set<Integer> nearDsts = near.keySet();
                for (Integer nearDst : nearDsts) {
                    if (minDist + near.get(nearDst) < dist.get(nearDst)) {
                        dist.put(nearDst, minDist + near.get(nearDst));
                    }
                }
            }
        }
        System.out.println(dist.get(dst));
    }   
}