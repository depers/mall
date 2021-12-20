package cn.bravedawn.java8.functionalinterfaces;

public class ConverterTest {

    public static void main(String[] args) {
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);
    }
}
