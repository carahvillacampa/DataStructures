import java.util.List;
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Collections; 
import edu.princeton.cs.algs4.*;

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
    	
     if(key == null||tree== null) return false;
     
      boolean searchFind;
      
      for(int i=0; i< tree.getNKeys();i++) {
    	  int compare= tree.getKey(i).compareTo(key);
    	  if(compare > 0 && tree.getChild(i)!= null) {
    		  searchFind=contains(tree.getChild(i),key);
    		  if(searchFind) {
    			  return true;
    		  }
    	  } 
    	  else if(compare <  0 && tree.getChild(i+1)!=null) {
    		  searchFind=contains(tree.getChild(i+1),key);
    		  if (searchFind) {
    			  return true;
    		  }
    	  }
    	  else if( compare==0) {
    		  return true;
    	  }
      }
      return false;
    }

    static public <Key extends Comparable<Key>>
    Key min (NakedTree<Key> tree) {
      if (tree.getNKeys()== 0) return null;
      
      if (tree.getChild(0)== null) {
    	  return tree.getKey(0);
      }
      else {
    	  return min(tree.getChild(0));
      }
    }


    //////// EXERCICE 1.2: put
    static public <Key extends Comparable<Key>>
    NakedTree<Key> putHelp(NakedTree<Key> tree, Key key){
    	 
    	if (tree ==null) {
    		tree= new NakedTree<Key>();
  
    	}
    	if(tree.getNKeys() ==1) {
    		Key k= tree.getKey(0);
    		if(k.compareTo(key) <0) {
    			tree.insertKey(1, key);
    		}
    		else {
    			tree.insertKey(0, key);
    		}
    		return tree;
    	}
    	
    	else if(tree.getNKeys()==0) {
    		tree.insertKey(0, key);
    		return tree;
    	}
    	else {
    		return tree;
    	}
    }
    
    static public <Key extends Comparable<Key>>
    NakedTree<Key> put (NakedTree<Key> tree, Key key) {
      // TODO
      
      if(tree.getNKeys()==0) { //if tree is empty, make it the root. return it.
    	  tree.insertKey(0, key);
    	  return tree;
      }
      if(tree.getChild(0)== null) { //if tree has no children, and if there's only 1 Key, 
    	  int compare= tree.getKey(0).compareTo(key);
    	  
    	  if(tree.getNKeys() ==1) { //if there's only one item in the tree
    		  return putHelp(tree,key);
    	  }
    	  else if(tree.getNKeys()==2){
    		  if(key.compareTo(tree.getKey(0)) >0 && (key.compareTo(tree.getKey(1))< 0)) {
    			  NakedTree<Key> x= tree.getChild(1);
    			  if(x== null) {
    				  tree.setChild(1, putHelp(null,key));
    			  }
    			  else {
    				  put(tree.getChild(1), key);
    			  }
  
    		  }
    		  else if(key.compareTo(tree.getKey(0)) <0) {
    			  NakedTree<Key> x= tree.getChild(0);
    			  if(x == null) {
    				  tree.setChild(0, putHelp(null,key));
    			  }
    			  else {
    				  put(tree.getChild(0), key);
    			  }
    		  }
    	  }
    	  else {
    		  NakedTree<Key> x= tree.getChild(2);
    		  if(x== null) {
    			  tree.setChild(2, putHelp(null, key));
    		  }
    		  else {
    			  put(tree.getChild(2), key);
    		  }
    	  }
      }
      //return split(NakedTree<Key>,int i)
       
      return tree;
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
    
    static public <Key extends Comparable<Key>>
    NakedTree<Key> recursiveDelete (NakedTree<Key> tree, Key key) {
    	
    	
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
    	if(keys.isEmpty()) {
    		return null;
    	}
    	
    	if(keys.size() ==1) { //if there's only one item in the list
    		NakedTree<Key> tempTree= new NakedTree<>(1); //create a new NakedTree
    		tempTree.insertKey(0, keys.get(0)); //add that one item in the list 
    		return tempTree; //return the tree
    	}
    	else {
    		NakedTree<Key> tNode= new NakedTree<Key>(1); //if there's more, create a new tree with the capacity of the list
    		tNode.insertKey(0, keys.get(0)); //insert the first element of the list to the new Tree
    		int n=1; //assuming there's more than 1, counter for the while loop 
    		
    		List<Key> leftTree= new ArrayList<Key>();
    		
    		while(n< keys.size() && keys.get(n).compareTo(keys.get(0)) < 0) {
    			leftTree.add(keys.get(n));
    			n++;
    		}
    		
    		List<Key> rightTree= new ArrayList<Key>();
    		while(n < keys.size()) {
    			rightTree.add(keys.get(n));
    			n++;
    		}
    		
    		tNode.setChild(0, preorderToBST(leftTree));
    		tNode.setChild(1, preorderToBST(rightTree));
    		return tNode;
    	}
    	
    	//Collections.sort(keys); //sorts the list
    	//int n=0;
    	
    	//Key min= keys.get(0); //get min
    	//Key max= keys.get(keys.size()); //get max
    	
    	
      // TODO
      //return null;
    }
    
    ////////////////////////// BONUS 1: BEST INSERT ORDER IN 2-3 TREES
    static public <Key extends Comparable<Key>>
    NakedTree<Key> deleteBubble (NakedTree<Key> tree, Key key) {
      // TODO
      return null;
    }

    ////////////////////////// BONUS 2: MAKE min AND contains ITERATIVE
    
    static public <Key extends Comparable<Key>>
    Key minIterative (NakedTree<Key> tree) {
    	while(tree.getChild(0) != null) {
    		tree=tree.getChild(0);
    	}
    	return tree.getKey(0);
    }
    
    static public <Key extends Comparable<Key>>
    boolean containsIterative (NakedTree<Key> tree, Key key) {
    	if(tree.getNKeys()!=0 && key!= null) {
    		for(int i=0; i < tree.getNKeys(); i++) {
        		if(key.equals(tree.getKey(i))) {
        			return true;
        		}
        	}
    	}
    	return false;
    }
}
