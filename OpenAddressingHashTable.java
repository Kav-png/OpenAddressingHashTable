
public class OpenAddressingHashTable<V> { // Used to cast the data type from the parent class that's creating this new component
    private Integer[] keys; // Array to store the keys
    private V[] values; // Array to store the values
    private int size;

    public static final int INITIAL_CAPACITY = 16; // Default value for the initial capacity
    public static final double LOAD_FACTOR = 0.75; // The ratio of the number of elements to the capacity to the table =

    public OpenAddressingHashTable() {
        this.keys = new Integer[INITIAL_CAPACITY]; // key is an integer
        this.values = (V[]) new Object[INITIAL_CAPACITY]; // value can be any object being cast to the object passed in
        this.size = 0; // When the hash table is created there are no key and string pairs
    }

    // The parameters keys anf values are arrays of integers and any object respectively

    /* .put() function
     * @input Integer[] keys, V[] Values
     * @process complete validation and add the elements at the index in both the arrays
     */

    public void put(Integer key, V value) {
        if(size >= LOAD_FACTOR * keys.length) {
            // So, if the size is greater than the max keys that have to be loaded then you should increase the size of the array
            resize();
        }
        // let's use linear probing

        // calculate the index, if there is a value there just go the next value

        Integer index = findIndex(key);
        if (keys[index] == null) {
            keys[index] = key;
            values[index] = value;
        }
    }

    private void resize() {
        int newSize = keys.length * 2; // double the size
        Integer[] oldKeys = keys;
        V[] oldValues = values;

        keys = new Integer[newSize];
        values = (V[]) new Object[newSize];

        // add the older values into the new ones
        for (int i = 0; i < oldKeys.length; i++) {
            keys[i] = oldKeys[i];
            values[i] = oldValues[i];
        }
    }

    public V get(Integer key) {
        Integer index = findIndex(key);
        return keys[index] != null ? values[index] : null;
    }

    public void remove(Integer key) {
        Integer index = findIndex(key);
        if (keys[index] != null) {
            keys[index] = null;
            values[index] = null;
            size--;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private int findIndex(Integer key) {
        Integer index = (key%keys.length); 
        while (keys[index] != null && !keys[index].equals(key)) { 
            index++; // Move onto the next index until a null is found
        }
        return index;
    }
    public static void main(String[] args) {
        System.out.println("This is the class for implementing Hash Table with Open Addressing");

        OpenAddressingHashTable<String> hashTable = new OpenAddressingHashTable<>();
        // Testing a collision: The collision is avoided because the size is double so MOD is different
        hashTable.put(4, "Value4");
        hashTable.put(20, "Value20");

        System.out.println("Get key 4: " + hashTable.get(4));
        System.out.println("Get key 20: " + hashTable.get(20));
    }
}
