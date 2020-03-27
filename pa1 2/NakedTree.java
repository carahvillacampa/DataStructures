import edu.princeton.cs.algs4.*;
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.Scanner;
import java.util.ArrayList;

class NakedTree<Key> {
    private static final int N = 3;
    
    private Object[] keys;
    private Object[] children;
    private int nkeys;
    private final int maxkeys;

    public NakedTree () {
      this(N);
    }
    //constructor with specific size
    public NakedTree (int size) {
      keys = new Object[size];
      children = new Object[size + 1];
      nkeys = 0;
      maxkeys = size;
    }
    // returns if tree is empty
    //nkeys = size; if child is null: empty
    public boolean isEmpty () {
      return nkeys == 0 && children[0] == null;
    }
    
    public NakedTree<Key> getChild (int i) {
      return (NakedTree<Key>) children[i];
    }
    //sets child using index i
    //inserts a link between specified key and the tree
    public void setChild (int i, NakedTree<Key> child) {
      if (i < 0 || i > nkeys) throw new ArrayIndexOutOfBoundsException ();
      children[i] = child;
    }
    //return associated value if present
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
    // gets the size of the tree
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

    public static NakedTree<Integer> fromString (String str) {
      return fromString (str, N);
    }

    public static NakedTree<Integer> fromString (String str, int size) {
      Scanner s = new Scanner (str).useDelimiter ("(\\s+|\b|(?=[},])|(?<=[{]))");
      ArrayList<NakedTree<Integer>> lnt = fromStringInternal (s, size);
      if (lnt == null || lnt.size () > 1 || lnt.size () == 0)
        return null;
      return lnt.get (0);
    }

    private static ArrayList<NakedTree<Integer>> fromStringInternal (Scanner s, int size) {
      ArrayList<NakedTree<Integer>> lnt = new ArrayList<NakedTree<Integer>> ();
      NakedTree<Integer> cur = new NakedTree<Integer> (size);
      String str;

      while (s.hasNext ()) {
        switch (str = s.next ()) {
          case "--": // Children
            s.next (); // Skip over "{"
            ArrayList<NakedTree<Integer>> children = fromStringInternal (s, size);
            assert cur.getNKeys () == children.size () - 1;
            for (int i = 0; i <= cur.getNKeys (); ++i)
              cur.setChild (i, children.get (i));
            break;
          case ",":
            lnt.add (cur);
            cur = new NakedTree<Integer> (size);
            break;
          case "}":
            lnt.add (cur);
            return lnt;
          default:
            cur.insertKey(cur.getNKeys (), Integer.parseInt (str));
        }
      }
      lnt.add (cur);
      return lnt;
    }
}
