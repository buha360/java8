import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    Due to YAGNI the followings were removed:
        - imperativArray()
        - calculateImperativeSum()
        + created calculateStreamSum() to replace both
 */

public class YAGNI {
    public static void main(String[] args) {
        int sum = calculateStreamSum(new int[]{1, 2, 3, 4, 5});
        System.out.println(sum);
        System.out.println("-----------------");

        // list with stream
        printStream(Arrays.asList("Apple", "Banana", "Cherry").stream());

        filteredList();

        Printer<Integer> printer1 = new Printer<>(23);
        printer1.print();
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

    public static int calculateStreamSum(int[] array) {
        return (int) Arrays.stream(array).filter(i -> i % 2 == 0).count();
    }
}