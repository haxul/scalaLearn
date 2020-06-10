import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Hello {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<String> strings = List.of("hello", "world", "my", "friend", "hello", "world");

        List<String> collect = strings.stream()
                .flatMap((string) -> numbers.stream()
                        .filter((number -> number > 3))
                        .map(n -> string + " - " + n))
                .collect(Collectors.toList());
        Map<String, List<String>> collect1 = strings.stream().collect(Collectors.groupingBy((s) -> String.valueOf(s.charAt(0))));

        String result = StringFormatter.unit("hello world")
                .flatMap(x -> StringFormatter.unit(x.toUpperCase()))
                .flatMap(x -> StringFormatter.unit(x.replace(" ", "!!!")))
                .fold(x -> x);
        System.out.println(result);
    }
}

class StringFormatter {
    private String a;

    public StringFormatter(String a) {
        this.a = a;
    }

    public StringFormatter flatMap(Function<String, StringFormatter> f) {
        return f.apply(a);
    }

    public String fold(Function<String, String> f) {
        return f.apply(a);
    }

    public static StringFormatter unit(String str) {
        return new StringFormatter(str);
    }
}