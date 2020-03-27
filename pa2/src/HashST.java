import edu.princeton.cs.algs4.*;

// This is a stripped down version of LinearProbingHashST, with delete
// removed.
public class HashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int n;           // number of key-value pairs in the symbol table
    private int m;           // size of linear probing table
    private Key[] keys;      // the keys
    private Value[] vals;    // the values


    public HashST() {
      this(INIT_CAPACITY);
    }

    public HashST(int capacity) {
      m = capacity;
      n = 0;
      keys = (Key[])   new Object[m];
      vals = (Value[]) new Object[m];
    }

    public int size() { return n; }
    public boolean isEmpty() { return size() == 0; }
    public boolean contains(Key key) { return get(key) != null; }
    public static <Key>
    int hash(Key key, int m) { return (key.hashCode() & 0x7fffffff) % m; }

    // resizes the hash table to the given capacity by re-hashing all of the keys
    private void resize(int capacity) {
      HashST<Key, Value> temp = new HashST<Key, Value>(capacity);
      for (int i = 0; i < m; i++) {
        if (keys[i] != null) {
          temp.put(keys[i], vals[i]);
        }
      }
      keys = temp.keys;
      vals = temp.vals;
      m    = temp.m;
    }

    public void put(Key key, Value val) {
      if (n >= m/2) resize(2*m);

      int i;
      for (i = hash(key, m); keys[i] != null; i = (i + 1) % m)
        if (keys[i].equals(key)) {
          vals[i] = val;
          return;
        }
      keys[i] = key;
      vals[i] = val;
      n++;
    }

    public Value get(Key key) {
      for (int i = hash(key, m); keys[i] != null; i = (i + 1) % m)
        if (keys[i].equals(key))
          return vals[i];
      return null;
    }

    public void delete(Key key) {
      if (ProgrammingAssignment2.deleteInHash (keys, vals, key)) {
        n--;
        if (n > 0 && n <= m/8) resize(m/2);
      }
    }

    public Iterable<Key> keys() {
      Queue<Key> queue = new Queue<Key>();
      for (int i = 0; i < m; i++)
        if (keys[i] != null) queue.enqueue(keys[i]);
      return queue;
    }

    // integrity check
    public boolean check() {
      if (m < 2*n) {
        StdOut.println("Hash table size m = " + m + "; array size n = " + n);
        return false;
      }

      for (int i = 0; i < m; i++)
        if (keys[i] != null && get(keys[i]) != vals[i]) {
          StdOut.println("get[" + keys[i] + "] = " + get(keys[i]) + "; vals[i] = " + vals[i]);
          return false;
        }
      return true;
    }

    public String toString () {
      String s = "";
      for (int i = 0; i < m; ++i)
        s = s + keys[i] + " ";
      return s;
    }
}
