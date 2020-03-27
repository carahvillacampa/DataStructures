import java.util.Set;
import java.util.TreeSet;
import java.io.File;
import java.io.*;
import java.util.concurrent.Callable;
import edu.princeton.cs.algs4.In;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

class ProgrammingAssignment2 {
    ///////////////////////////////////////////////////////////////// EXERCISE 1
    class FileUnionDifference {
        
        String filesToArray;
        private ArrayList<Set<String>> wordFileSet;
        private HashSet<String> finalSet= new HashSet<>();
        Set<String> returnSet= new HashSet<>();
        char[] charArray;
        
        // Public constructor
        public FileUnionDifference (List<String> files) {
        	wordFileSet= new ArrayList<>();
        	
        	try {
        		for(String file: files) {
        			Set<String> wordSet= new HashSet<>();
        			File f= new File(file);
        			Scanner scanInput= new Scanner(f);
        			
        			while(scanInput.hasNextLine()) {
        				String ln= scanInput.nextLine();
        				if(ln == null) {
        					break;
        				}
        				else {
        					for(String words: ln.split(" ")) {
        						wordSet.add(words);
        					}
        				}
        			}
        			
        			wordFileSet.add(wordSet);
        		}
        	}
        	catch (FileNotFoundException e){
        		
        	}
        	finalSet= (HashSet<String>) combineAll();
        	this.wordFileSet= wordFileSet;
        	
        	}
        public int findFileIndex(char x) {
        	int indexFile= Character.getNumericValue(x)-1;
        	return indexFile;
        	
        }
     // Public query function
        public Set<String> query (String s) {
        	
        	//Set<String> returnSet= new HashSet<>();
        	if(s== null) {
        		return null;
        	}
        	else{
        		{
        			char plus='+';
        			char minus='-';
        			char intersection='i';
        			char complement='c';
            		this.charArray= s.toCharArray();
            		
            		for(int i=0; i< charArray.length; i++) {
            			if(charArray[i] == intersection) {
            				int x=findFileIndex(charArray[i+1]);
            				Set<String> intersectionTemp= new HashSet<>();
            				
            				for(String setWord: returnSet) {
            					if(this.wordFileSet.get(x).contains(setWord)) {
            						intersectionTemp.add(setWord);
            					}
            				}
            				//returnSet=null;
            				returnSet= intersectionTemp;
            			}
            			
            			if(charArray[i] == complement) {
            				Set<String> tempHashSet= new HashSet<>();
            				tempHashSet.addAll(this.finalSet);
            				
            				for(String setWord: returnSet) {
            					tempHashSet.remove(setWord);
            				}
            				
            				//this.returnSet= null;
            				this.returnSet=tempHashSet;
            			}
            			
            			if(charArray[i]== plus) {
       
            				int x=findFileIndex(charArray[i+1]);
            				this.returnSet.addAll(this.wordFileSet.get(x));
            			}
            			
            			if(charArray[i]==minus ) {
            				int x=findFileIndex(charArray[i+1]);
            				this.returnSet.removeAll(this.wordFileSet.get(x));
            			}
            			
            			else {
            				continue;
            			}
            		}
            		
            	}
        	}
        
			return returnSet;
        	
        }
        
        private Set<String> combineAll(){
        	Set<String> tempHash= new HashSet<>();
        	
        	if (wordFileSet == null) {
        		return null;
        	}
        	else {
        		for(Set<String> setsOfFiles: wordFileSet) {
        			tempHash.addAll(setsOfFiles);
        		}
        	}
        	return (HashSet<String>) tempHash;
        	
        }
        
        }

  

    ///////////////////////////////////////////////////////////////// EXERCISE 2
    static public <Key extends Comparable<Key>>
    NakedTree<Key> deleteBubble (NakedTree<Key> tree, Key key) {
    //TwoThreeTree tree1= new TwoThreeTree();
    NakedTree<Key> subTree= new NakedTree<>();
    int rootVal;
    
    
    	
      if (tree != null && key != null) { 
    		if(tree.getNKeys()==1 && key == tree.getKey(0)) { //at the root and root is a leaf //BASE CASE
    			  tree.deleteKey(0);
    			  return tree;
    		  }	
      }
      if( key == tree.getKey(0) || key== tree.getKey(1)) { //BASE CASE
			//(key == tree.getKey(0) && 
			if (tree.getNKeys() < 2) {
				//if it's a 2 node 
				if( key == tree.getKey(0)) { //if key is equal to first element in root
  				tree.deleteKey(0);
  			}
  			if(key == tree.getKey(1)) { //if key is equal to second element in root 
  				tree.deleteKey(1);
  			}
			}
			
			else { //if it's at the root and it's a 3 node with leaves
				//subTree= new NakedTree<>();
				rootVal= TwoThreeTree.findKeyAtRoot(tree, key);
				subTree= tree.getChild(rootVal);
				
				if( key == tree.getKey(0)) { //if key is equal to first element in root
					tree.setKey(0, TwoThreeTree.minInternal(subTree));
					//key= TwoThreeTree.minInternal(subTree); 
  			}
  			if(key == tree.getKey(1)) { //if key is equal to second element in root 
  				tree.setKey(1, TwoThreeTree.minInternal(subTree));
  				//key= TwoThreeTree.minInternal(subTree); 
  			}	
  			
			else { //if we're not at the root 
				//int rootVal= TwoThreeTree.findKeyAtRoot(tree, key);
				subTree= tree.getChild(rootVal);
				
				if( key == tree.getKey(0)) { //if key is equal to first element in root
					tree.setKey(0, TwoThreeTree.minInternal(subTree));
					//key= TwoThreeTree.minInternal(subTree); 
				}
				if(key == tree.getKey(1)) { //if key is equal to second element in root 
					tree.setKey(1, TwoThreeTree.minInternal(subTree));
					//key= TwoThreeTree.minInternal(subTree); 
				}	
				tree.setChild(rootVal, deleteBubble(subTree, key));
				subTree= tree.getChild(rootVal);
				
				if (subTree.getNKeys()==0) {
			    	 tree= bubbleUp(tree, subTree); 
			      }
				}
			}
      }
		
      return tree;
    }
    
    
    //helper functions balance and something else
    static public <Key extends Comparable<Key>>
    NakedTree<Key> bubbleUp(NakedTree<Key> tree, NakedTree<Key> subTree){
    		
    	 //a subtree in the middle
    	NakedTree<Key> rightSibling;
    	NakedTree<Key> leftSibling;
    	int position= TwoThreeTree.findKeyAtRoot(tree,subTree.getKey(0));
    	
    	if (position < 1) { 
    		leftSibling= null; //if path is at 0; set left sibling to null
    	}
    	leftSibling= tree.getChild(position-1); 
    	
    	if (position > 1) { //
    		rightSibling= null;
    	}
        rightSibling= tree.getChild(position+1);
        
        if(leftSibling != null && leftSibling.getNKeys()==3) { //if there is a left sibling and the left sibling is a 3 node
        	//rebalance(leftSibling, 0); //rebalance from left sibling
        }
        
        else if(rightSibling !=null && rightSibling.getNKeys()==3) {
        	rebalance(rightSibling, rightSibling.getKey(0));
        }
        else if(leftSibling !=null) {
        	tree.setChild(1, tree.getChild(0));
        	 
    		//merge left sibling with its parent key
        	//take the key from the parent whose left and right
        	//pointers used to point to these two leaves and add this key to the merged node. 
    	}
    	else {
    		tree.setChild(2,rightSibling);
    		//merge right sibling with its parent key
    	}
        
    	return tree;
    	
    }
    
    static private <Key extends Comparable<Key>>
    void merge(NakedTree<Key> tree, Key key) {
    	
    }
    
    static private <Key extends Comparable<Key>>
    void rebalance(NakedTree<Key> tree, Key key) {
    	NakedTree<Key> rightSubtree;
    	NakedTree<Key> leftSubtree;
    	
    	rightSubtree= tree.getChild(1);
    	leftSubtree= tree.getChild(0);
    	
    	if (rightSubtree.getNKeys()==0) {
    		tree.setKey(0, tree.getChild(1).getKey(0)); //set first Key in the second subtree as the root
    		rightSubtree.setKey(0, tree.getKey(0)); //set the parent as left subtree
    		
    	}
    	if(leftSubtree.getNKeys()==0) {
    		tree.setKey(1, tree.getChild(0).getKey(1));
    		leftSubtree.setKey(1, tree.getKey(1));
    	}
    	
    }
    
    ///////////////////////////////////////////////////////////////// EXERCISE 3
    // Delete using the Find Replacement approach.
    // Returns true iff key was found and deleted.
    static public <Key> int getIndex( Key[] keys,Key key) {
    	int x;
    	int klength= keys.length;
    	
        for ( x= hash(key, klength); keys[x] != null; x = (x + 1) % klength)
          if (keys[x].equals(key))
            return x;
        return -1;
      }
    static public <Key, Value> void exchange(Key[] keys, Value[] vals, int x, int y) {   //i is the index of the deleted, j should replace it
    	int klength= keys.length;
    	while(keys[y] != null) {		
    		if(hash(keys[y], klength) <= x) { //
    			Value temp2 = vals[x];
    			vals[x] = vals[y];
    			vals[y] = temp2;
    			
    			Key temp = keys[x]; // keep the original keys[i]
    			keys[x] = keys[y];	
    			keys[y] = temp;
    				
    		}
    		y = y + 1;
    	}
    }

    static public <Key, Value>
    boolean deleteInHash (Key[] keys, Value[] vals, Key key) {
    	int i= getIndex(keys,key); //getting key index in array keys
    	int length= keys.length; //array length
    	
    	if(i !=-1) {
    		keys[i] = null; //when you delete out of the hash table
    		vals[i] = null;
    		
    		int y= (i+1) % keys.length;
    		exchange(keys, vals,i, y);
    		
    	}
    
		return false;	
    }	
    
    static private <Key>
    int hash(Key key, int m) { 
    	return (key.hashCode() & 0x7fffffff) % m; 
    }
    
    
}
