import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Single Responsibility Principle: Minden osztály egyetlen felelősséget kap
class ArraySumCalculator {
    public int calculateSum(int[] array) {
        return (int) Arrays.stream(array).filter(i -> i % 2 == 0).count();
    }
}

// Open/Closed Principle: A Printer osztály bővíthető, de a meglévő kód módosítása nélkül
interface Printable {
    void print();
}

class Printerr<T> implements Printable {
    private final T item;

    public Printerr(T item) {
        this.item = item;
    }

    @Override
    public void print() {
        System.out.println(item);
    }
}

// Dependency Inversion Principle: A Main osztály nem függ közvetlenül a konkrét implementációktól, hanem az absztrakcióktól
public class SOLID {
    public static void main(String[] args) {
        ArraySumCalculator calculator = new ArraySumCalculator();
        int sum = calculator.calculateSum(new int[]{1, 2, 3, 4, 5});
        System.out.println(sum);
        System.out.println("-----------------");

        // Interface Segregation Principle: Csak a szükséges metódusokkal rendelkező interfészt használunk
        Printable printer1 = new Printerr<>(23);
        printer1.print();

        // Single Responsibility Principle: A különböző stream feldolgozási feladatokat külön osztályokba helyezhetjük
        StreamPrinter<String> stringStreamPrinter = new StreamPrinter<>();
        stringStreamPrinter.printStream(Arrays.asList("Apple", "Banana", "Cherry").stream());

        FilteredListProcessor processor = new FilteredListProcessor();
        processor.processFilteredList();
    }
}

// Single Responsibility Principle: Az egyes feladatok külön osztályba kerültek
class StreamPrinter<T> {
    public void printStream(Stream<T> stream) {
        stream.forEach(System.out::println);
        System.out.println("-----------------");
    }
}

class FilteredListProcessor {
    public void processFilteredList() {
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
}
