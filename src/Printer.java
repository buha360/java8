public class Printer<T extends Number> {

    T item;

    public Printer(T item) {
        this.item = item;
    }

    public void print() {
        System.out.println("The number is: " + item);
    }
}
