import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main_DRY {
    public static void main(String[] args) {
        // Generikus metódus void visszatérési értékkel
        Shout("Hello", 123);
        Shout(45.67, "Generics are fun!");
        separator();

        // Generikus metódus visszatérési értékkel
        System.out.println("Returned value: " + ShoutAndReturn("Return this", 456));
        System.out.println("Returned value: " + ShoutAndReturn(789, "Return the number"));
        separator();

        // Combined approach for calculating sum
        printSumResult(new int[]{1, 2, 3, 4, 5}, false);
        printSumResult(new int[]{1, 2, 3, 4, 5}, true);
        separator();

        // list with stream
        printStream(Arrays.asList("Apple", "Banana", "Cherry").stream());
        printStream(Arrays.stream(new String[]{"Cherry", "Banana", "Apple"}));
        printStream(Stream.of(1, 2, 3));
        printStream(Stream.iterate(0, n -> n + 1).limit(10));
        printStream(Stream.generate(() -> (int) (Math.random() * 100)).limit(5));
        separator();

        // Filtered list example
        filteredList();
        separator();

        // Printer examples
        printNumber(new Printer<>(23));
        printNumber(new Printer<>(23.825));
        separator();

        // Join example with Stream
        printJoinedNames(Arrays.asList("John", "Jane", "Jack"));
        separator();

        // Date and time example
        printDateAndTime();
        separator();

        // Parallel Stream example
        printParallelSum(Arrays.asList(1, 2, 3, 4, 5));
    }

    // Generikus metódus void visszatérési értékkel
    private static <T, V> void Shout(T firstItem, V secondItem) {
        System.out.println("First item: " + firstItem);
        System.out.println("Second item: " + secondItem);
    }

    // Generikus metódus visszatérési értékkel
    private static <T, V> T ShoutAndReturn(T firstItem, V secondItem) {
        System.out.println("First item: " + firstItem);
        System.out.println("Second item: " + secondItem);
        return firstItem;
    }

    // Metódus a szétválasztó vonalakhoz
    private static void separator() {
        System.out.println("-----------------");
    }

    // Összegző metódus, DRY elv alapján egyszerűsítve
    private static void printSumResult(int[] array, boolean useStream) {
        int result = calculateSum(array, useStream);
        System.out.println(result);
    }

    // Számolás stream-mel vagy imperatív módszerrel
    private static int calculateSum(int[] array, boolean useStream) {
        return useStream ? (int) Arrays.stream(array).filter(i -> i % 2 == 0).count()
                : (int) Arrays.stream(array).filter(i -> i % 2 == 0).count();
    }

    // Stream elemek kiíratása
    public static void printStream(Stream<?> stream) {
        stream.forEach(System.out::println);
        separator();
    }

    // Szűrt lista előállítása és kiíratása
    public static void filteredList() {
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
    }

    // Printer példák számmal
    public static void printNumber(Printer<? extends Number> printer) {
        printer.print();
    }

    // Nevek összekapcsolása és kiíratása
    private static void printJoinedNames(List<String> names) {
        String joinedNames = names.stream().collect(Collectors.joining(", "));
        System.out.println(joinedNames);
    }

    // Dátum és idő kiíratása
    private static void printDateAndTime() {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1990, Month.AUGUST, 20);
        LocalTime time = LocalTime.now();
        LocalTime specificTime = LocalTime.of(14, 30, 0);
        System.out.println("Birthday: " + birthday);
        System.out.println("Today: " + today);
        System.out.println("Specific time: " + specificTime);
        System.out.println("Current time: " + time);
    }

    // Parallel Stream példával összegzés
    private static void printParallelSum(List<Integer> numbers) {
        int sum = numbers.parallelStream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum of even numbers (parallel): " + sum);
    }
}