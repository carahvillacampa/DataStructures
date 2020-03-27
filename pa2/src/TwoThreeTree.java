import edu.princeton.cs.algs4.*;
import java.util.List;

class TwoThreeTree<Key extends Comparable<Key>> {
    private NakedTree<Key> tree;

    public TwoThreeTree () {
      tree = new NakedTree<Key>(3);
    }

    // Returns the number of keys in the tree.
    public int size () {
      return sizeInternal (tree);
    }

    static private <Key extends Comparable<Key>>
    int sizeInternal (NakedTree<Key> tree) {
      if (tree == null)
        return 0;
      int val = tree.getNKeys ();
      for (int i = 0; i <= tree.getNKeys (); ++i)
        val += sizeInternal (tree.getChild (i));
      return val;
    }


    // Returns i such that
    // getKey (i - 1) < key <= getKey(i)
    // It may be that key is actually getKey (i).
    static public <Key extends Comparable<Key>>
    int findKeyAtRoot (NakedTree<Key> tree, Key key) {
      int i;

      for (i = 0; i < tree.getNKeys (); ++i)
        if (key.compareTo (tree.getKey (i)) <= 0)
          return i;
      return i;
    }

    // True if key is present in the tree.
    public boolean contains (Key key) {
      NakedTree<Key> x = tree;

      while (x != null && x.getNKeys () > 0) {
        assert (x.getNKeys () == 1 || x.getNKeys () == 2);
        int i = findKeyAtRoot (x, key);
        if (i < x.getNKeys () && key.compareTo (x.getKey (i)) == 0)
          return true;
        x = x.getChild (i);
      }
      return false;
    }

    // Inserts a new key, does nothing if key is already there.
    public void put (Key key) {
      // If tree is empty, create a new one.
      if (tree == null || tree.isEmpty ()) {
        tree = new NakedTree<Key>(3);
        tree.insertKey (0, key);
      }

      // Insert in the tree
      putInternal (tree, key);

      // Check if we need to split the root.
      if (tree.getNKeys () == 3) {
        NakedTree<Key> new_root = new NakedTree<Key>(3);

        new_root.setChild (0, tree);
        split (new_root, 0);
        tree = new_root;
      }
    }

    // split the i-th child of tree if it's a 4-node.  That is, insert the
    // middle key of getChild(i) at the root of tree, and rearrange.
    static private <Key extends Comparable<Key>>
    void split (NakedTree<Key> tree, int i) {
      if (tree.getChild (i).getNKeys () == 3) {
        NakedTree<Key> l = new NakedTree<Key> (3);
        NakedTree<Key> r = new NakedTree<Key> (3);
        NakedTree<Key> four = tree.getChild (i);

        l.insertKey (0, four.getKey (0));
        l.setChild (0, four.getChild (0));
        l.setChild (1, four.getChild (1));

        r.insertKey (0, four.getKey (2));
        r.setChild (0, four.getChild (2));
        r.setChild (1, four.getChild (3));
        
        tree.insertKey (i, four.getKey (1));
        tree.setChild (i, l);
        tree.setChild (i + 1, r);
      }
    }

    // Go down the tree, and insert the key at the leaf.
    static private <Key extends Comparable<Key>>
    void putInternal (NakedTree<Key> tree, Key key) {
      int i = findKeyAtRoot (tree, key); //could be in any subtree of tree

      // Key was already there: return.
      if (i < tree.getNKeys () && key.compareTo (tree.getKey (i)) == 0)
        return;
      // Not at a leaf
      if (tree.getChild (i) != null) { //
        putInternal (tree.getChild (i), key);
        split (tree, i);
      }
      else tree.insertKey (i, key); // at a leaf: insert.
    }

    // Removes a key; may change the tree even if the key does not appear.
    public void delete (Key key) {
      tree = ProgrammingAssignment2.deleteBubble (tree, key);
    }

    // Returns the minimum of the tree.
    static public <Key extends Comparable<Key>>
    Key minInternal (NakedTree<Key> tree) {
      if (tree.isEmpty ())
        return null;
      while (tree.getChild (0) != null)
        tree = tree.getChild (0);
      return tree.getKey (0);
    }

    public Key min () {
      return minInternal (tree);
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

      return is23Traversal (tree, null, null, 0, height ());
    }

    private boolean is23Traversal (NakedTree<Key> subtree,
                                   Key low, Key high,
                                   int curdepth, int goaldepth) {
      if (subtree == null)
        return curdepth == goaldepth; //if the current depth of the null tree is the actual depth of the tree
      								// returns true/false
      if (subtree.getNKeys () != 1 && subtree.getNKeys () != 2) //if 
        return false;
      
      Key cur;
      for (int i = 0; i < subtree.getNKeys (); ++i) {
        cur = subtree.getKey (i);
        if (((low == null) || low.compareTo (cur) <= 0)) {
          if (!is23Traversal (subtree.getChild (i), low, cur, curdepth + 1, goaldepth))
            return false;
          low = cur;
        } else return false;
      }
      cur = subtree.getKey (subtree.getNKeys () - 1);
      return (((high == null) || high.compareTo (cur) >= 0) &&
              is23Traversal (subtree.getChild (subtree.getNKeys ()),
                             cur, high, curdepth + 1, goaldepth));
    }
}
