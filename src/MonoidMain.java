import java.util.function.Function;

public class MonoidMain {
    public static void main(String[] args) {
        String hello_world = TextAnalyzer.unit("Hello World")
                .flatMap(s -> TextAnalyzer.unit(s.toLowerCase()))
                .fold(s -> s);
        System.out.println(hello_world);
    }
}



abstract class TextAnalyzer {
    abstract TextAnalyzer flatMap(Function<String, TextAnalyzer> f);
    abstract String fold(Function<String, String> f);
    public static TextAnalyzer unit(String text) {
        if (text.length() > 20) return LongText.unit(text);
        return ShortText.unit(text);
    }


}

class LongText extends TextAnalyzer {
    private String s;
    public LongText(String s) {
        this.s = s;
    }
    @Override
    public TextAnalyzer flatMap(Function<String, TextAnalyzer> f) {
        return f.apply(s);
    }
    public static TextAnalyzer unit(String s) {
        return new LongText(s);
    }
    @Override
    public String fold(Function<String, String> f) {
        return f.apply(s).toUpperCase();
    }
}

class ShortText extends TextAnalyzer {

    private String s;
    public ShortText(String s) {
        this.s = s;
    }
    @Override
    public TextAnalyzer flatMap(Function<String, TextAnalyzer> f) {
        return f.apply(s);
    }

    public static TextAnalyzer unit(String a) {
        return new ShortText(a);
    }
    @Override
    public String fold(Function<String, String> f) {
        return f.apply(s).replaceAll(" ", "!!!!");
    }
}
