import java.util.*;
import java.util.stream.IntStream;

public class stream {
    public static void main(String[] args) {
        List<Integer> idealList = List.of(1,2,3);
        List<Integer> answerList = List.of(2, 3, 1);
        IntStream intStream = answerList.stream().mapToInt(Integer::intValue);
        int ball = (int)intStream.filter((s)->idealList.contains(s)).count();
        System.out.println(ball);
    }
}
