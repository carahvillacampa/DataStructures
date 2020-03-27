import java.security.Key;

public class bubbleDel {
	static public <Key extends Comparable<Key>>
	NakedTree<Key> deleteBubble(NakedTree<Key> tree, Key key){
		NakedTree<Key> subTree;
		
		for(int i=0; i < tree.getNKeys(); i++) {
			if (key.compareTo(tree.getKey(i))==0) { //if the key is the root, just delete the key and return 
				tree.deleteKey(i);
				return tree;
				
			}
			//if key is not the root do the following:
			
			subTree= tree.getChild(i+1);
			key= min(subTree);
			tree.setKey(i, key);
			tree.setChild(+1, deleteBubble(subTree, key));
				
			//check if tree is empty, if it is tree is the left child
			if(tree.getNKeys()== 0) { 
				tree= tree.getChild(0);
			}
				
			//check if either of the subtrees and their children are 0
			//if they are, bubble up
			subTree= tree.getChild(i+1);
			if(subTree.getNKeys()==0) {
				tree= bubbleUp(tree, subTree, i+1);
				return tree;
			}
			
			//if key is in the left and it's not null
			//set that tree as the child of the deleted key
			else if(key.compareTo(tree.getKey(i)) < 0 && tree.getChild(i) != null) {
				subTree= tree.getChild(i);
				tree.setChild(i, deleteBubble(subTree, key));
				if(tree.getNKeys()==0) {
					tree= tree.getChild(0);
				}
				
				subTree= tree.getChild(i);
				if(subTree.getNKeys()==0) {
					tree= bubbleUp(tree, subTree, i);
				}
				return tree;
			}
			
		if(tree.getChild(tree.getNKeys())== null) {
			return tree;
		}
		
		subTree= tree.getChild(tree.getNKeys());
		tree.setChild(tree.getNKeys(), deleteBubble(subTree, key));
		
		if(tree.getNKeys()==0) {
			tree= tree.getChild(0);
		}
		
		
		subTree= tree.getChild(tree.getNKeys());
		if(subTree.getNKeys()== 0) {
			tree= bubbleUp(tree, subTree, tree.getNKeys());
			return tree;
		}

		}
		return tree;
		
	}
	 private static NakedTree<Key> bubbleUp(NakedTree<Key> tree, NakedTree<Key> subTree, int i) {
		// TODO Auto-generated method stub
		return null;
	}
	//returns min of the key
	 static public <Key extends Comparable<Key>>
	    Key min(NakedTree<Key> tree) { 
		if (tree.isEmpty ())
	        return null;
	      while (tree.getChild (0) != null)
	        tree = tree.getChild (0);
	      return tree.getKey (0);
		
	}
	 
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
