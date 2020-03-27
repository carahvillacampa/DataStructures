import edu.princeton.cs.algs4.*;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class ProgrammingAssignment3 {
	//static int count;
    //////////////////////////////////////////// EXERCISE 1: GRAMMAR PRODUCTIONS
    static public Set<String> allProductions (Grammar g, Grammar.Token token) {
      HashSet<String> grammar= new HashSet();
      if(token.isTerminal()) { //if all lower case, add to the set, if not add it
    	  grammar.add(token.getValue());
      }
      else {
    	  HashSet<String> returnSet= new HashSet<>();
    	  if(!token.isTerminal()) { //is it's not all lower case, make a new list to get the rules 
    		  for(List<Grammar.Token> T: g.rulesFor(token) ) {
    			  for(Grammar.Token t: T) {
    				  returnSet.add(t.getValue());
    				  concat(returnSet,(HashSet<String>) concat(grammar,returnSet));
    			  }  
    		  }
    	  }  
      }
    
    return Collections.<String>emptySet ();
    
    }
    static public Set<String> concat(HashSet<String> first,HashSet <String>sec){
    	
    	HashSet<String> concat= new HashSet<>();
    	concat.addAll(first);
    	concat.addAll(sec);
    	return concat;
    }

    //////////////////////////////////////////////////// EXERCISE 2: GRAPH TESTS
    static public boolean isDirectedTree (Digraph graph) {
    	int count = 0;
    	int sourceVertex = 0;
    	
    	if(graph.E() > 0) {
	    	if(hasDirectedCycle(graph)) { //if graph has a cycle, return false;
	    		return false;
	    	}
	    	else {
	    		for (int i =0; i < graph.V(); i++) { //iterate over all the vertices of the graph
	        		int curInDegree = graph.indegree(i); 
	        		if (curInDegree == 0) {
	        			sourceVertex = i;
	        			count++;
	        		}
	        		if (count > 1) {
	        			return false;
	        		}
	        	}
	    		for (int j =0; j < graph.V(); j++) {
	        		int curInDegree = graph.indegree(j);
	        		if (sourceVertex == j) {
	        			continue;
	        		}
	        		if (curInDegree != 1) {
	        			return false;
	        		}
	        	}
	    		
	    	return true;
	    	}
    	}
    	else {
    		return true;
    	}
    }
    
    static public boolean isTournament (Digraph graph) {
    	DirectedCycle G = new DirectedCycle(graph);
    	//tournament graphs has a cycle but not self loops
    	if(!hasSelfLoop(graph) && isCompleteDir(graph)) { //G.hasCycle() && 
    		return true;
    	}
    return false;
    }
    
    static public boolean isComplete (Graph graph) {
        //check if there's self loops/cycles 
        if(hasUndirectedSelfLoop(graph)) {
        	return false;
        }
        else {
        	int completeDeg= (graph.V()*(graph.V()-1));	
        	int totalV= graph.V();
        	
        	//calculate total degree of every vertex
        	int degreeSum=0;
        	for(int i=0; i< graph.V(); i++) {
        		degreeSum += graph.degree(i);
        	}
        	//property1
        	if (graph.E() == completeDeg/2) {
        		//property 2
            	for(int v=0; v< totalV; v++) {
            		if(graph.degree(v)==graph.V()-1){ //graph.degree(totalV-1)
            			//property3
                    	if(degreeSum == completeDeg) {
                    		return true;
                    	}
            		}
            	}	
            }
        }
        return false;
        }
 
    	static public boolean isWheel (Graph graph) {
    	
    	//must satisfy condition that wheels must have at least 2 vertices
    	if(graph.V() <=1) {
    		System.out.println("Need more vertices, can't have less than 2");
    		return false;
    	}
    	else {
            
            if (!hasUndirectedSelfLoop(graph)) {
    			int midVertex=0;
    			int midCount=0;
    			for(int i=0; i< graph.V();i++) {
    				if(graph.degree(i)== graph.V()-1){
    					midVertex=i;
    					midCount++;
    				}
    			}
    			
    			int counter=0;
        		for(int i=0; i< graph.V(); i++) {
        			if(hasEdge(graph, midVertex,i)== true) {
        				counter++;
        			}
        		}
        			
        		if(counter== graph.V()-1) {
        			return true;
        			}	
    			}
            }
    	return false;
    	} 
    	

        /*
         * 1. check if graph has a self loop, if not 
         * 2. find the middle vertex
         * 3. check if every vertex is connected to the middle vertex
         * 
         *  G.addEdge(vertices[V-1], vertices[1]);
         *  if (!hasUndirectedSelfLoop(graph)) {
			int midVertex=0;
			for(int i=0; i< graph.V()-1;i++) {
				if(graph.degree(i)== graph.V()-1){
					midVertex+=i;
				}
			}
			
			for(int i=0; i< graph.V(); i++) {
				for(int j:graph.adj(i)) {
					if(hasEdge(graph, midVertex, j)) {
						return true;
					}
				}
			}
		}
		/*
    		 *int [] vertices= new int[graph.V()];
    		for (int i = 0; i < graph.V(); i++)
                vertices[i] = i;
            StdRandom.shuffle(vertices); 
            
            for(int j:graph.adj(i)) {
    					
    				}
    				
    		if(j == graph.degree(3)) {
        					threeDeg++;
        				}
        	if(graph.degree(i) == 3) {
    					threeDeg++;
    				}
    				
    				int counter=0;
    			for(int i=0; i< graph.V()-1; i++) {
    				for(int j: graph.adj(i)) {
    					if(hasEdge(graph, midVertex, j) == true) {
    						counter++;
    					}
    				}	
    			}
    		 
         */
    
    
    static public boolean isCompleteDir (Digraph graph) {
        //check if there's self loops/cycles 
        if(hasSelfLoop(graph)) {
        	for(int i=0; i< graph.V(); i++) {
        		for(int j=0; j< graph.V(); j++) {
        			if (i ==j) {
        				return false;
        			}
        		}
        	}
        }
        //test if it's a complete graph property 1
        int completeDeg= (graph.V()*(graph.V()-1));	
        if(graph.E() !=completeDeg/2) {
        	return false;
        }
        int inDegSum=0;
        int outDegSum=0;
        int totalDeg= inDegSum+outDegSum;
        
        for(int i=0; i< graph.V(); i++) {
        	inDegSum += graph.indegree(i);
        	outDegSum += graph.outdegree(i);
        }
        //test for property 2
        if(completeDeg ==totalDeg) {
        	return true;
        }
        //test for property 3
        int size= graph.V()-1;
        for(int i=0; i< graph.V(); i++) {
        	if(graph.indegree(i)==size||graph.outdegree(i)== size) {
        		return true;
        	}
        }
 
     return true;
    }
    
    
    static public boolean hasSelfLoop(Digraph graph) {
    	// checks if vertex v1 and v2 has an edge between them
    	for(int i=0; i<graph.V(); i++) {
    		//BreadthFirstPaths bfs = new BreadthFirstPaths(graph, i);
    		ArrayList<Integer> vertices= new ArrayList<>();
    		for(int n: graph.adj(i)) {
    			vertices.add(n);
    		}
    		if (vertices.contains(i)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public static boolean hasEdge(Digraph graph, int source, int destination) {
    	ArrayList <Integer>tempArray= new ArrayList<>();
    	for(int i: graph.adj(source)) {
    		tempArray.add(i);
    	}
    	if(tempArray.contains(destination)){
			return true;
		}
    	return false;
    }
    
    public static boolean hasDirectedCycle(Digraph graph) {
    	DirectedCycle G= new DirectedCycle(graph);
    	if(G.hasCycle()) { //if graph has a cycle, return false;
    		return true;
    	}
    	return false;
    }
    public static boolean hasUndirectedCycle(Graph graph) {
    	Cycle G= new Cycle(graph);
        if(G.hasCycle()) {
        	return true;
        }
        return false;
    }
    
    private static boolean hasUndirectedSelfLoop(Graph G) {
    	Stack cycle;
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (v == w) {
                    cycle = new Stack<Integer>();
                    cycle.push(v);
                    cycle.push(v);
                    return true;
                }
            }
        }
       return false;
    }
    
    public static boolean hasEdge(Graph graph, int source, int destination) {
    	ArrayList <Integer>tempArray= new ArrayList<>();
    	for(int i: graph.adj(source)) {
    		tempArray.add(i);
    	}
    	if(tempArray.contains(destination)){
			return true;
		}
    	return false;
    }
  
    /////////////////////////////////////////////////// EXERCISE 3: VIRUS SPREAD
    static public int virusSpread(int[][] network) {
    	boolean curr = false;
    	boolean lastUninfected = false;
    	int nLength=network.length;
    	int toInfectCount = 0;
    	int numCompInfected = 0;
    	
    	//create copy of network array
    	int[][] arrayCopy = new int[network.length][]; 
    	for (int i = 0; i < arrayCopy.length; ++i) {
    		arrayCopy[i] = new int[network[i].length];
    		for (int j = 0; j < arrayCopy[i].length; ++j) {
    			arrayCopy[i][j] = network[i][j];
    		}
    	}

    	if(!curr == false) { 
    		return 0;
    	}
    	else {
    		for (int R = 0; R < nLength; R++) {
    			for (int C = 0; C < network[R].length; C++) {
    				if (network[R][C] != 1) continue;
    				else curr = true;
    			}
    		}
    		if (!curr) {
    			return 0;
    		}	
    	}
    	
    	curr = false;
    	
    	if (!curr == false) {
    		return -1;
    	}
    	else {
    		for (int R = 0; R < nLength; R++) {
    			for (int C = 0; C < network[R].length; C++) {
    				if (network[R][C] == 0) continue;
    				else curr = true;
    			}
    		}
    		if (!curr) {
    			return -1;
    		}
    	}
    	for (int R = arrayCopy.length - 1; R >= 0; R--) { 
    		for (int C = arrayCopy[R].length - 1; C >= 0; C--) {
    			if (arrayCopy[R][C] != 2) {
    				continue;
    			}
    			else {
    				if (R < (nLength - 1)) {
    					if (arrayCopy[R + 1][C] == 1) {
    						arrayCopy[R +1][C] = 2;
        					toInfectCount++;
    					}
    				}
    				if (R > 0) {
    					if (arrayCopy[R - 1][C] == 1) {
    						arrayCopy[R - 1][C] = 2;
    						toInfectCount++;
    					}
    				}
    				if (C < (arrayCopy[R].length - 1)) {
    					if (arrayCopy[R][C + 1] == 1) {
    						arrayCopy[R][C + 1] = 2;
    						toInfectCount++;
    					}
    				}
    				if (C > 0) {
    					if (arrayCopy[R][C -1] == 1) {
    						arrayCopy[R][C - 1] = 2;
    						toInfectCount++;
    					}
    				}
    			}  
    			if (toInfectCount > 0) {
    				numCompInfected++;
    				toInfectCount = 0;
    			} 
    			else {
    				continue;
    			}
    		}
    	}
    	
    	//forward iteration
    	for (int R = 0; R < arrayCopy.length; R++) { 
    		for (int C = 0; C < arrayCopy[R].length; C++) {
    			if (arrayCopy[R][C] != 2) {
    				continue;
    			}
    			else {
    				if (R < (nLength - 1)) {
    					
    					if (arrayCopy[R + 1][C] == 1) {
    						arrayCopy[R +1][C] = 2;
        					toInfectCount++;
    					}
    				}
    				if (R > 0) {
    					if (arrayCopy[R - 1][C] == 1) {
    						arrayCopy[R - 1][C] = 2;
    						toInfectCount++;
    					}
    				}
    				if (C < (arrayCopy[R].length - 1)) {
    					if (arrayCopy[R][C + 1] == 1) {
    						arrayCopy[R][C + 1] = 2;
    						toInfectCount++;
    					}
    				}
    				if (C > 0) {
    					if (arrayCopy[R][C -1] == 1) {
    						arrayCopy[R][C - 1] = 2;
    						toInfectCount++;
    					}
    				}
    			}  
    			if (toInfectCount > 0) {
    				numCompInfected++;
    				toInfectCount = 0;
    			} 
    			else {
    				continue;
    			}
    		}
    	}
    	
    	//reverse iteration
    	
    	for (int R = 0; R < arrayCopy.length; R++) {
    		for (int C = 0; C < arrayCopy[R].length; C++) {
    			if (arrayCopy[R][C] == 1) {
    				lastUninfected = true;
    			} else {
    				continue;
    			}
    		}
    	}
    	if (lastUninfected == true) {
    		return -1;
    	}
    	else {
    		return numCompInfected;
    	}  	
    }  
}









