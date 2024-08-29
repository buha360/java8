import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // imperative approach
        int sumImperativ = imperativArray();
        System.out.println(sumImperativ);
        System.out.println("-----------------");

        // stream approach
        int sumStream = streamArray();
        System.out.println(sumStream);
        System.out.println("-----------------");

        // list with stream
        listStream();
        filteredList();
    }

    public static void filteredList () {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> collect = list.stream().filter(x -> x % 2 == 0).map(x -> x * 2).collect(Collectors.toList());
        System.out.println(collect); // sysout -> sout
    }

    public static void listStream () {
        List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
        Stream<String> myStream = list.stream();
        myStream.forEach(System.out::println);
        System.out.println("-----------------");

        String[] array = {"Cherry", "Banana", "Apple"};
        Stream<String> stream = Arrays.stream(array);
        stream.forEach(System.out::println);
        System.out.println("-----------------");

        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        integerStream.forEach(System.out::println);
        System.out.println("-----------------");

        Stream<Integer> limit = Stream.iterate(0, n -> n + 1).limit(10);
        limit.forEach(System.out::println);
        System.out.println("-----------------");

        Stream<Integer> limit1 = Stream.generate(() -> (int) (Math.random() * 100)).limit(5);
        limit1.forEach(System.out::println);
        System.out.println("-----------------");
    }

    public static int imperativArray () {
        // imperative approach
        int[] array = {1, 2, 3, 4, 5};
        int sum = 0;

        for (int j : array) {
            if (j % 2 == 0) {
                sum++;
            }
        }

        return sum;
    }

    public static int streamArray () {
        // stream approach
        int[] array = {1, 2, 3, 4, 5};

        return (int) Arrays.stream(array).filter(i -> i % 2 == 0).count();
    }
}