package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FlatMap {

    public static void main(String[] args) {
        List<String> string1 = Arrays.asList("11", "12", "13");
        List<String> string2 = Arrays.asList("21", "22", "23");
        List<String> string3 = Arrays.asList("31", "32", "33");

        Stream<List<String>> stream = Stream.of(string1, string2, string3);
        stream.flatMap(list -> {
            System.out.println();
            System.out.println("Flattening " + list);
            return list.stream();
        }).forEach(e -> System.out.print(e + " "));

        stream.filter(list -> list.size() > 0);

        System.out.println();
        System.out.println("using inner stream");
        stream = Stream.of(string1, string2, string3);
        stream.forEach(list -> {
            System.out.println();
            System.out.println("Getting stream from " + list);
            list.forEach(e -> System.out.print(e + " "));
        });
    }

}
