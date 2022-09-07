import java.util.Comparator;
public class test {
    
}

@FunctionalInterface
interface ExampleInterface {
    public int variable = 10;
    abstract void exampleMethod();
    default void defaultPrint() {
        System.out.println("abc");
    }
    static void staticPrint() {
    	System.out.println("def");
    }
}

