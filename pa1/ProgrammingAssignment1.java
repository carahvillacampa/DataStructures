import java.util.List;
//import edu.princeton.cs.algs4.*;

class ProgrammingAssignment1 {

    //////////////////// EXERCICE 1: TWO THREE TREES

    static public <Key extends Comparable<Key>>
    int size (NakedTree<Key> tree) {
      if (tree == null)
        return 0;
      int val = tree.getNKeys ();
      for (int i = 0; i <= tree.getNKeys (); ++i)
        val += size (tree.getChild (i));
      return val;
    }

    //////// EXERCICE 1.1: contains AND min

    static public <Key extends Comparable<Key>>
    boolean contains (NakedTree<Key> tree, Key key) {
      // TODO
      return false;
    }

    static public <Key extends Comparable<Key>>
    Key min (NakedTree<Key> tree) {
      // TODO
      return null;
    }


    //////// EXERCICE 1.2: put
    
    static public <Key extends Comparable<Key>>
    NakedTree<Key> put (NakedTree<Key> tree, Key key) {
      // TODO
      return null;
    }


    //////// EXERCICE 1.3: delete

    // Here is some pseudocode for delete; it is in two parts, one dealing with
    // the root, and one RecursiveDelete that goes down the tree.
    //
    // At root:
    // {  if key is at the root
    //      if the root is a leaf
    //        delete from the leaf, done.
    //      else
    //        replace key with successor in root
    //    if the root is a 3-node, start RecursiveDelete there
    //    find the child in which key would be
    //    if this child is a 3-node, start RecursiveDelete from there
    //    if this child is a 2-node
    //      if its sibling is a 3-node, balance from sibling, and start RecursiveDelete at the child.
    //      if its sibling is a 2-node, merge root and the two children into a 4-node, start RecursiveDelete at this node.
    //    At the end, after RecursiveDelete, check if the root needs to be split up.
    // }
    //
    // RecursiveDelete(tree, key):  (this function assumes that tree is a >2-node)
    // {
    //   if the key is at the root
    //     if tree is a leaf, delete it, done.
    //     otherwise, replace key with successor, and continue by deleting that successor.
    //   find the child X in which key would be
    //   if X is null, key not found
    //   if X is a 3-node, RecursiveDelete on it
    //   if X a 2-node
    //     if its right sibling is a 3-node, rebalance from it, and RecursiveDelete on X
    //     else if its left sibling is a 3-node, rebalance from it, and RecursiveDelete on X
    //     else if it has a right sibling, mergesibling, X, and one key of the parent into a 4-node; call RecursiveDelete on it
    //     else if it has a left sibling, merge sibling, X, and one key of the parent into a 4-node; call RecursiveDelete on it
    //  At the end, after RecursiveDelete, check if X needs splitting.
    // }
    static public <Key extends Comparable<Key>>
    NakedTree<Key> delete (NakedTree<Key> tree, Key key) {
      // TODO
      return null;
    }

    ////////////////////////// EXERCICE 2: BEST INSERT ORDER IN 2-3 TREES
    static public <Key extends Comparable<Key>>
    List<Key> bestInsertOrder (List<Key> keys) {
      // TODO
      return null;
    }

    ////////////////////////// EXERCICE 3: PREORDER TO BST
    static public <Key extends Comparable<Key>>
    NakedTree<Key> preorderToBST (List<Key> keys) {
      // TODO
      return null;
    }
    
    ////////////////////////// BONUS 1: BEST INSERT ORDER IN 2-3 TREES
    static public <Key extends Comparable<Key>>
    NakedTree<Key> deleteBubble (NakedTree<Key> tree, Key key) {
      // TODO
      return null;
    }

    ////////////////////////// BONUS 2: MAKE min AND contains ITERATIVE
}
