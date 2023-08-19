import java.util.Queue;
import java.util.LinkedList;
class Solution {
    static int height;
    static int width;
    static int[][] staticMap;
    static boolean[][] visited;
    static Queue<Integer[]> visitable;
    static int answer = -1;
    public int solution(int[][] maps) {
        staticMap = maps;
        height = maps.length;
        width = maps[0].length;
        visited = new boolean[height][width];
        visited[0][0] = true;
        visitable = new LinkedList<>();
        Integer[] currentPos = {0, 0, 1};
        visitable.add(currentPos);
        while(!visitable.isEmpty() && visited[height-1][width-1]==false){
            boolean end = bfs();
            if(end){
                break;
            }
        }
        return answer;
    }
    private boolean bfs() {
        Integer[] currentPos = visitable.poll();
        int step = currentPos[2];
        int[] xMoves = {0, 0, -1, 1};
        int[] yMoves = {1, -1, 0, 0};
        for(int i=0; i<xMoves.length; i++){
            int xPos = currentPos[1]+xMoves[i];
            int yPos = currentPos[0]+yMoves[i];
            Integer[] nextPos = {yPos, xPos, step+1};
            if(yPos==height-1 && xPos==width-1){
                answer = step+1;
                return true;
            }
            if(xPos>=0 && xPos<width && yPos>=0 && yPos<height) {
                if(staticMap[yPos][xPos]!=0 && visited[yPos][xPos]==false) {
                    visitable.add(nextPos);
                    visited[yPos][xPos] = true;
                }
            }
        }
        return false;
    }
}
