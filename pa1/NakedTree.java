//import edu.princeton.cs.algs4.*;
import java.lang.ArrayIndexOutOfBoundsException;

class NakedTree<Key> {
    private static final int N = 3;
    
    private Object[] keys;
    private Object[] children;
    private int nkeys;
    private final int maxkeys;

    public NakedTree () {
      this(N);
    }

    public NakedTree (int size) {
      keys = new Object[size];
      children = new Object[size + 1];
      nkeys = 0;
      maxkeys = size;
    }

    public boolean isEmpty () {
      return nkeys == 0 && children[0] == null;
    }

    public NakedTree<Key> getChild (int i) {
      return (NakedTree<Key>) children[i];
    }

    public void setChild (int i, NakedTree<Key> child) {
      if (i < 0 || i > nkeys) throw new ArrayIndexOutOfBoundsException ();
      children[i] = child;
    }

    public Key getKey (int i) {
      if (i < 0 || i >= nkeys) throw new ArrayIndexOutOfBoundsException ();
      return (Key) keys[i];
    }

    public void setKey (int i, Key key) {
      if (key == null) throw new IllegalArgumentException("calls setKey() with a null key");
      if (i < 0 || i >= nkeys) throw new ArrayIndexOutOfBoundsException ();
      keys[i] = key;
    }

    // This insert a new key at position i.  The child between keys i and i+1
    // (i.e. getChild(i+1)) will be null.
    //
    // Example:
    //
    // Given the tree:
    //   0___1___2___3___4
    //  /  |   |   |   |  \
    // A   B   C   D   E   F
    //
    // after insertKey(2, 8):
    //
    //   0___1___8___2___3___4
    //  /  |   |   |   |   |  \
    // A   B   C  NIL  D   E   F
    //
    // after insertKey(0, 9):
    //
    //   9___0___1___8___2___3___4
    //  /  |   |   |   |   |   |  \
    // A  NIL  B   C  NIL  D   E   F
    //
    // after insertKey(7, 7):
    //
    //   9___0___1___8___2___3___4___7
    //  /  |   |   |   |   |   |   |  \
    // A  NIL  B   C  NIL  D   E   F  NIL
    //    
    public void insertKey (int i, Key key) {
      if (i < 0 || i > nkeys || nkeys == maxkeys) throw new ArrayIndexOutOfBoundsException ();
      for (int j = nkeys; j > i; --j) {
        keys[j] = keys[j - 1];
        children[j + 1] = children[j];
      }
      children[i + 1] = null;
      keys[i] = key;
      ++nkeys;
    }

    // This deletes the key at position i.  The child between keys i and i + 1
    // (getChild(i+1)) is deleted.
    public void deleteKey (int i) {
      if (i < 0 || i >= nkeys) throw new ArrayIndexOutOfBoundsException ();
      for (int j = i; j < nkeys - 1; ++j) {
        keys[j] = keys[j + 1];
        children[j + 1] = children[j + 2];
      }
      children[nkeys] = null;
      --nkeys;
    }

    public int getNKeys () {
      return nkeys;
    }

    public String toString () {
      boolean seen_child = false;
      String s = "";
      
      for (int i = 0; i < nkeys; ++i)
        s = s + keys[i] + (i == nkeys - 1 ? "" : " ");

      for (int i = 0; i <= nkeys; ++i) {
        if (children[i] != null) {
          if (!seen_child) {
            s = s + " -- {";
            seen_child = true;
          } else
            s = s + ", ";
          s = s + ((NakedTree<Key>) children[i]).toString ();
        }
      }
      if (seen_child)
        s += "}";
      return s;
    }
}
