import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class stream {
    public static void main(String[] args) {
        String s = "323";
        IntStream intStream = s.chars();
        int cnt = (int)intStream.distinct().count();
        System.out.println(cnt);
    }
}
