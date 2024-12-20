
public class OpenAddressingHashTable<V> { // Used to cast the data type from the parent class that's creating this new component
    private Integer[] keys; // Array to store the keys
    private V[] values; // Array to store the values
    private int size;

    public static final int INITIAL_CAPACITY = 16; // Default value for the initial capacity
    public static final double LOAD_FACTOR = 0.75; // The ratio of the number of elements to the capacity to the table =

    public OpenAddressingHashTable(Integer[] key, V[] value) {
        this.keys = new Integer[INITIAL_CAPACITY]; // key is an integer
        this.values = (V[]) new Object[INITIAL_CAPACITY]; // value can be any object being cast to the object passed in
        this.size = 0; // When the hash table is created there are no key and string pairs
    }

    // The parameters keys anf values are arrays of integers and any object respectively

    /* .put() function
     * @input Integer[] keys, V[] Values
     * @process complete validation and add the elements at the index in both the arrays (currently without handling collisions)
     */

    public void put(Integer key, V value) {
        if(size >= LOAD_FACTOR * keys.length) {
            // So, if the size is greater than the max keys that have to be loaded then you should increase the size of the array
            // Resize the arrays
            
            int newSize = keys.length * 2;
            Integer[] oldKeys = keys;
            V[] oldValues = values;

            keys = new Integer[newSize];
            values = (V[]) new Object[newSize];

            for (int i = 0; i > keys.length; i++) {
                keys[i] = oldKeys[i];
                values[i] = oldValues[i];
            }
        }

        // create a hashing algo that assigns keys to index
        // let's use linear probing

        
    }




    



    public static void main(String[] args) {
        System.out.println("This is the class for implementing Hash Table with Open Addressing");
    }
}
