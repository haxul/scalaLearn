import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Hello {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5);
        List<String> strings = List.of("hello", "world", "my", "friend", "hello", "world");

        List<String> collect = strings.stream()
                .flatMap((string) -> numbers.stream()
                        .filter((number -> number > 3))
                        .map(n -> string + " - " + n))
                .collect(Collectors.toList());
        Map<String, List<String>> collect1 = strings.stream().collect(Collectors.groupingBy((s) -> String.valueOf(s.charAt(0))));

    }
}