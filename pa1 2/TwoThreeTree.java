import edu.princeton.cs.algs4.*;
import java.util.List;

class TwoThreeTree<Key extends Comparable<Key>> {
    private NakedTree<Key> tree;

    public TwoThreeTree () {
      tree = new NakedTree<Key>(3);
    }

    // Returns the number of keys in the tree.
    public int size () {
      return ProgrammingAssignment1.size (tree);
    }

    // True if key is present in the tree.
    public boolean contains (Key key) {
      return ProgrammingAssignment1.contains (tree, key);
    }

    // Inserts a new key, does nothing if key is already there.
    public void put (Key key) {
      tree = ProgrammingAssignment1.put (tree, key);
    }

    // Removes a key; may change the tree even if the key does not appear.
    public void delete (Key key) {
      tree = ProgrammingAssignment1.delete (tree, key);
    }

    // Returns the minimum of the tree.
    public Key min () {
      return ProgrammingAssignment1.min (tree);
    }


    // Delegates toString to the NakedTree
    public String toString () {
      if (tree == null)
        return "";
      return tree.toString ();
    }

    // Delegates fromString to NakedTree
    public static TwoThreeTree<Integer> fromString (String str) {
      TwoThreeTree<Integer> tttree = new TwoThreeTree<Integer> ();
      tttree.tree = NakedTree.fromString (str);
      return tttree;
    }

    // Computes the height, assuming this is a 2-3 tree.
    public int height () {
      NakedTree<Key> x = tree;
      int d = 0;
      while (x != null) {
        x = x.getChild (0);
        ++d;
      }
      return d;
    }

    // This checks that the tree is balanced, 2-3, and ordered.
    public boolean is23 () {
      if (tree == null || tree.getNKeys () == 0)
        return true;

      return is23traversal (tree, null, null, 0, height ());
    }

    private boolean is23traversal (NakedTree<Key> subtree,
                                   Key low, Key high,
                                   int curdepth, int goaldepth) {
      if (subtree == null)
        return curdepth == goaldepth;
      if (subtree.getNKeys () != 1 && subtree.getNKeys () != 2)
        return false;
      Key cur;
      for (int i = 0; i < subtree.getNKeys (); ++i) {
        cur = subtree.getKey (i);
        if (((low == null) || low.compareTo (cur) <= 0)) {
          if (!is23traversal (subtree.getChild (i), low, cur, curdepth + 1, goaldepth))
            return false;
          low = cur;
        } else return false;
      }
      cur = subtree.getKey (subtree.getNKeys () - 1);
      return (((high == null) || high.compareTo (cur) >= 0) &&
              is23traversal (subtree.getChild (subtree.getNKeys ()),
                             cur, high, curdepth + 1, goaldepth));
    }
}
