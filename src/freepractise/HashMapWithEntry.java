package freepractise;


public class HashMapWithEntry<K, V> {

    static final int DEFAULT_INITIAL_CAPACITY = 4;
    static final int MAX_CAPACITY = 10;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    int threshold;
    float loadFactor;
    Entry[] table;
    int size; //TODO The number of key-value mappings contained in this map

    static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        Entry(K k, V v, Entry<K, V> n) {
            value = v;
            next = n;
            key = k;
        }
    }

    public HashMapWithEntry() {
        this.threshold = (int) (DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.size = 0;
        table = new Entry[DEFAULT_INITIAL_CAPACITY];
    }

    public HashMapWithEntry(int initialCapacity, float loadFactor) {
        if (loadFactor <= 0 || loadFactor > 1)
            throw new IllegalArgumentException("loadFactor not allowed!");
        if (initialCapacity < 0)
            throw new IllegalArgumentException("initialCapacity not allowed!");
        if (initialCapacity > MAX_CAPACITY)
            initialCapacity = MAX_CAPACITY;
        int capacity = 1;
        while (capacity < initialCapacity)
            capacity <<= 1; // TODO capacity must be power of 2, see the indexFor() below!
        this.threshold = (int) (capacity * loadFactor);
        this.loadFactor = loadFactor;
        table = new Entry[capacity];
    }

    static int indexFor(int h, int length) {
        return h & (length - 1); //TODO due to length being power of 2, so length-1 means significant bits all be 1; 
                                 //TODO so from 0 to length-1; we can get all information(similar with % operation) for hashcode to index
                                 //TODO if length is not power of 2, hashbuckets are not balanced(too many 0s may lose information for mapping) 
    }

    /**
     * don't consider the null as key
     * 
     * @param key
     * @param value
     * @return
     */
    public V put(K key, V value) {
        if (key == null)
            throw new IllegalArgumentException("key can not be null!");
        int i = indexFor(key.hashCode(), table.length);
        for (Entry<K, V> e = table[i]; e != null; e = e.next) {
            if (key.equals(e.value)) {
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
        addEntry(key, value, i); //TODO insert operation
        return null;
    }

    public V get(Object key) {
        if (key == null)
            throw new IllegalArgumentException("key can not be null!");
        for (Entry<K, V> e = table[indexFor(key.hashCode(), table.length)]; e != null; e = e.next) {
            if (key.equals(e.key))
                return e.value;
        }
        return null;
    }

    /**
     * insert operation
     * @param key
     * @param value
     * @param bucketIndex
     */
    public void addEntry(K key, V value, int bucketIndex) { 
        Entry<K, V> e = table[bucketIndex];
        table[bucketIndex] = new Entry<>(key, value, e);
        if (size++ >= threshold)
            resize(2 * table.length);
    }

    public void resize(int newCapacity) {
        Entry[] oldTable = table;
        int oldCapacity = oldTable.length;
        if (oldCapacity == MAX_CAPACITY) {
            threshold = Integer.MAX_VALUE;
            return;
        }
        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int) (newCapacity * loadFactor);
    }

    /**
     * transfer old table to new table
     * @param newTable
     */
    public void transfer(Entry[] newTable) {
        Entry[] src = table;
        int newCapacity = newTable.length;
        for (int i = 0; i < src.length; i++) {
            Entry<K, V> e = src[i];
            if (e != null) {
                src[i] = null; //TODO release space of old table
                do {
                    Entry<K, V> next = e.next;
                    int index = indexFor(e.key.hashCode(), newCapacity);
                    e.next = newTable[index]; //TODO insert operation
                    newTable[index] = e;
                    e = next;
                } while (e != null);
            }
        }
    }

    /**
     * return: s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
     * 
     * @param str
     * @return
     */
    public int stringHashCode(String str) {
        int h = 0;
        for (int i = 0; i < str.length(); i++) {
            h = 31 * h + str.charAt(i++);
        }
        return h;
    }

    public static void main(String[] args) {
    }

}
