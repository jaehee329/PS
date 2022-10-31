import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleUnaryOperator;
import java.util.function.ToDoubleBiFunction;
import java.util.stream.Stream;

public class test {
    @FunctionalInterface
    interface Factory<T> {
        T create();
    }
    public static void main(String[] args) {
        DoubleUnaryOperator oper;
        oper = (n) -> Math.abs(n);
        System.out.println(oper.applyAsDouble(-5));

        oper = Math::abs;
        System.out.println(oper.applyAsDouble(-5));


        ToDoubleBiFunction<Double, Double> function;
        
        function = (a, b) -> Math.pow(a, b);
        System.out.println(function.applyAsDouble(5.0, 2.0));

        function = Math::pow;
        System.out.println(function.applyAsDouble(5.0, 2.0));
        
        Consumer<String> consumer;

        consumer = (a) -> System.out.print(a);
        consumer.accept("print\n");

        consumer = System.out::print;
        consumer.accept("print\n");

        List<Integer> intList = List.of(1,2,3);
        Stream<Integer> intStream = intList.stream();

        intStream.forEach(System.out::print);


        List<Score> scores = new ArrayList<>();
        scores.add(new Score(100));
        scores.add(new Score(120));
        Score score = scores.stream().filter(Score::over100).findFirst().orElseThrow(IllegalArgumentException::new);
        System.out.println(score.score);
    }

    static class Score {
        int score;
        public Score(int score) {
            this.score = score;
        }
        public boolean over100() {
            return this.score>100;
        }
    }
}