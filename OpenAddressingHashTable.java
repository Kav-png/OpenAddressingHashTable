public class OpenAddressingHashTable<K, V> {
    private K[] key;
    private V[] value;
    private int size;

    public static final int INTIAL_CAPACITY = 16; // Default vaue for the initial capacity
    public static final double LOAD_FACTOR = 0.75; // The ratio of the number of elements to the capacity to the table =

    public OpenAddressingHashTable(K[] key, V[] value) {
        this.key = key;
        this.value = value;
    }

    



    public static void main(String[] args) {
        System.out.println("This is the class for implementing Hash Table with Open Addressing");
    }
}
