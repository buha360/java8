import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KISS {
    public static void main(String[] args) {
        int sumImperativ = calculateImperativeSum(new int[]{1, 2, 3, 4, 5});
        System.out.println(sumImperativ);
        System.out.println("-----------------");

        int sumStream = calculateStreamSum(new int[]{1, 2, 3, 4, 5});
        System.out.println(sumStream);
        System.out.println("-----------------");

        // list with stream
        printStream(Arrays.asList("Apple", "Banana", "Cherry").stream());
        printStream(Arrays.stream(new String[]{"Cherry", "Banana", "Apple"}));
        printStream(Stream.of(1, 2, 3));
        printStream(Stream.iterate(0, n -> n + 1).limit(10));
        printStream(Stream.generate(() -> (int) (Math.random() * 100)).limit(5));

        filteredList();

        Printer<Integer> printer1 = new Printer<>(23);
        printer1.print();
        Printer<Double> printer2 = new Printer<>(23.825);
        printer2.print();
        /*
        Printer<String> printer3 = new Printer<>("23.825 - asd");
        printer3.print();

         */
    }

    public static void filteredList() {
        System.out.println("-----------------");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 10, 8, 2);
        List<Integer> collect = list.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * 2)
                .distinct()
                .sorted((a, b) -> (b - a))
                .limit(3)
                .skip(1)
                .collect(Collectors.toList());
        System.out.println(collect);
        System.out.println("-----------------");
    }

    public static void printStream(Stream<?> stream) {
        stream.forEach(System.out::println);
        System.out.println("-----------------");
    }

    public static int calculateImperativeSum(int[] array) {
        int sum = 0;
        for (int j : array) {
            if (j % 2 == 0) {
                sum++;
            }
        }
        return sum;
    }

    public static int calculateStreamSum(int[] array) {
        return (int) Arrays.stream(array).filter(i -> i % 2 == 0).count();
    }
}
