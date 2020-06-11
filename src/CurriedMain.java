import java.util.function.Function;

public class CurriedMain {
    public static void main(String[] args) {
        Function<String, String> sayHello = Sample.sayWith("Hello");
        String apply = sayHello.apply(" world");
    }
}

class Sample {
    static public Function<String, String> sayWith(String word) {
        return (spell)-> (word + spell);
    }
}
