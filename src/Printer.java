public class Printer <T> {

    T item;

    public Printer (T item) {
        this.item = item;
    }

    public void print() {
        System.out.println(item);
    }

}
