import edu.princeton.cs.algs4.*;
import java.util.concurrent.Callable;
import java.io.File;
import java.util.List;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

class Test {

    //////////////////////////////////////////////////////////// EXERCISE 1 TEST
    static private Void testEx1 () throws TestException {
      String[] expres = {"azzab", "azab", "azb", "attb"};
      Grammar g = new Grammar ();

      g.addRule ("S", "aCb");
      g.addRule ("S", "aBb");
      g.addRule ("C", "z");
      g.addRule (new Grammar.Token ("B", false),
                 Collections.singletonList (new Grammar.Token ("tt", true)));
      g.addRule ("B", "za");
      g.addRule ("B", "zCa");

      Set<String> res =
        ProgrammingAssignment3.allProductions (g, new Grammar.Token ("S", false));
      
      if (! (res.equals (new TreeSet<String> (Arrays.asList(expres)))))
        throw new TestException ("unexpected answer: " + res);

      res = ProgrammingAssignment3.allProductions (g, new Grammar.Token ("Z", false));
      if (! (res.equals (Collections.EMPTY_SET)))
        throw new TestException ("unexpected answer:" + res);
      
      g= new Grammar();
      g.addRule("S", "AB");
      //g.addRule(new Grammar.Token("S", false), 
    		//  Arrays.asList({new Grammar.Token("A", false), new Grammar.Token("B", false)});

      // This is a test that would show how good are the performances of allProductions.
      g = new Grammar ();
      g.addRule ("S", "AAAA");
      g.addRule ("A", "BBBBBBBB");
      g.addRule ("B", "CCCCCCCC");
      g.addRule ("C", "DDDDDDDD");
      g.addRule ("D", "EEEEEEEE");
      g.addRule ("E", "FFFFFFFF");
      g.addRule ("F", "GGGGGGGG");
      g.addRule ("G", "HHHHHHHH");
      g.addRule ("H", "IIIIIIII");
      g.addRule ("I", "x");

      res = ProgrammingAssignment3.allProductions (g, new Grammar.Token ("S", false));

      if (!res.iterator ().hasNext() || res.iterator ().next ().length () != 67108864)
        throw new TestException ("unexpected answer, wrong length.");

      return null;
    }

    //////////////////////////////////////////////////////////// EXERCISE 2 TEST
    static private Void testEx2 () throws TestException {
      
     Digraph tree = DigraphGenerator.rootedOutTree (47);
     //Digraph d = new Digraph(4);
	 //System.out.println(d.E());
     
     //System.out.println("Directed tree test start");
     if (!ProgrammingAssignment3.isDirectedTree (tree))
        throw new TestException ("tree recognized as not tree.");

      tree.addEdge (0, 0);
      if (ProgrammingAssignment3.isDirectedTree (tree))
       throw new TestException ("nontree recognized as tree.");
      //System.out.println("Directed tree test end");

      Graph complete = GraphGenerator.complete (34);
      //Graph complete = new Graph(5);
      //complete.addEdge(1, 2);complete.addEdge(2, 3);
      //complete.addEdge(0,1); complete.addEdge(1,1); complete.addEdge(0,3); complete.addEdge(1,4);
      
      // Digraph tree1 = new Digraph(6);
      //tree1.addEdge(1, 2); tree1.addEdge(2, 3)
      //System.out.println("Does the undirected graph have a self loop: "+ ProgrammingAssignment3.hasCycles(complete));
      if (!ProgrammingAssignment3.isComplete (complete))
        throw new TestException ("complete recognized as not complete.");
      
      complete.addEdge (0, 0);
      if (ProgrammingAssignment3.isComplete (complete))
        throw new TestException ("noncomplete recognized as complete.");
      
      
      Digraph tournament = DigraphGenerator.tournament (37);
      if (!ProgrammingAssignment3.isTournament (tournament))
        throw new TestException ("tournament recognized as not tournament.");

      tournament.addEdge (0, 0);
      if (ProgrammingAssignment3.isTournament (tournament))
        throw new TestException ("nontournament recognized as tournament.");
      
      //test for hasEdge helper method
      Digraph newTree = new Digraph (5);
      
      
      //System.out.println(ProgrammingAssignment3.hasEdge(newTree, source, destination))
  
      
      Graph wheel = GraphGenerator.wheel (39);
      if (!ProgrammingAssignment3.isWheel (wheel))
        throw new TestException ("wheel recognized as not wheel.");

      wheel.addEdge (0, 0);
      if (ProgrammingAssignment3.isWheel (wheel))
        throw new TestException ("nonwheel recognized as wheel.");
      
      
      System.out.println("Extra Tests Ex 2");
      boolean failed;
      failed = false;
      
      jump:
      if(!failed) {
    	  System.out.println("Testing Directed Trees");
    	  Digraph d = new Digraph(4);
    	  d.addEdge(0, 1); d.addEdge(0, 2); d.addEdge(1, 3); d.addEdge(2, 3);
          if(ProgrammingAssignment3.isDirectedTree(d) != false) {
        	  System.out.println("Test failed\nExpected: false\nProduced: true");
        	  System.out.println(d);
        	  failed = true;
        	  break jump;
          }
          for(int i = 1; i < 5; ++i) {
        	  d = DigraphGenerator.rootedOutTree(i);
        	  if(ProgrammingAssignment3.isDirectedTree(d) != true) {
        		  System.out.println("Test failed\nExpected: true\nProduced: false");
        		  System.out.println(d);
            	  failed = true;
            	  break jump;
        	  }
          }
          d = DigraphGenerator.rootedOutTree(3);
          d.addEdge(0, 0);
          if(ProgrammingAssignment3.isDirectedTree(d) != false) {
        	  System.out.println("Test failed\nExpected: false\nProduced: true");
        	  System.out.println(d);
        	  failed = true;
        	  break jump;
          }
          d = new Digraph(4);
    	  d.addEdge(0, 1); d.addEdge(1, 2); d.addEdge(2, 3); d.addEdge(3, 0);
          if(ProgrammingAssignment3.isDirectedTree(d) != false) {
        	  System.out.println("Test failed\nExpected: false\nProduced: true");
        	  System.out.println(d);
        	  failed = true;
        	  break jump;
          }
          
          
          System.out.println("Testing Tournaments");
          
          d = new Digraph(3);
          d.addEdge(0, 0); d.addEdge(1, 1); d.addEdge(2, 2);
          if(ProgrammingAssignment3.isTournament(d) != false) {
        	  System.out.println("Test failed\nExpected: false\nProduced: true");
        	  System.out.println(d);
        	  failed = true;
        	  break jump;
          }
          
          for(int i = 3; i < 10; i++) {
        	  d = DigraphGenerator.tournament(i);
        	  if(ProgrammingAssignment3.isTournament(d) != true) {
            	  System.out.println("Test failed\nExpected: true\nProduced: false");
            	  System.out.println(d);
            	  failed = true;
            	  break jump;
              }
          }
    	
          System.out.println("Testing Complete Graphs");
          
          Graph g = new Graph(3);
          g.addEdge(0, 0); g.addEdge(1, 1);
          if(ProgrammingAssignment3.isComplete(g) != false) {
        	  System.out.println("Test failed\nExpected: false\nProduced: true");
        	  System.out.println(g);
        	  failed = true;
        	  break jump;
          }
          g.addEdge(2, 2);
          if(ProgrammingAssignment3.isComplete(g) != false) {
        	  System.out.println("Test failed\nExpected: false\nProduced: true");
        	  System.out.println(g);
        	  failed = true;
        	  break jump;
          }
          
          for(int i = 1; i < 5; ++i) {
        	  g = GraphGenerator.complete(i);
        	  if(ProgrammingAssignment3.isComplete(g) != true) {
            	  System.out.println("Test true\nExpected: false\nProduced: false");
            	  System.out.println(g);
            	  failed = true;
            	  break jump;
              }
          }
          
          /*
          System.out.println("Testing Wheels");
          
          g = new Graph(3);
          g.addEdge(0, 1); g.addEdge(0, 2); g.addEdge(1, 1); g.addEdge(2, 2);
          if(ProgrammingAssignment3.isWheel(g) != false) {
        	  System.out.println("Test failed\nExpected: false\nProduced: true");
        	  System.out.println(g);
        	  failed = true;
        	  break jump;
          }
         
          g = new Graph(4);
          g.addEdge(0, 1); g.addEdge(1, 2);g.addEdge(2, 0);
          if(ProgrammingAssignment3.isWheel(g) != false) {
        	  System.out.println("Test failed\nExpected: false\nProduced: true");
        	  System.out.println(g);
        	  failed = true;
        	  break jump;
          }
          
          g = new Graph(3);
          g.addEdge(0, 1); g.addEdge(1, 2); g.addEdge(2, 0);
          if(ProgrammingAssignment3.isWheel(g) != true) {
        	  System.out.println("Test failed\nExpected: true\nProduced: false");
        	  System.out.println(g);
        	  failed = true;
        	  break jump;
          }
          
          for(int i = 4; i < 10; i++) {
	          g = GraphGenerator.wheel(i);
	          if(ProgrammingAssignment3.isWheel(g) != true) {
	        	  System.out.println("Test failed\nExpected: true\nProduced: false");
	        	  System.out.println(g);
	        	  failed = true;
	        	  break jump;
	          }
          }
          */   
      }
      
      
      if(!failed) {System.out.println("Success\n");}
      /*
      int mat[][] = { {10, 20, 30, 40, 50, 60, 70, 80, 90},
              {15, 25, 35, 45},
              {27, 29, 37, 48},
              {32, 33, 39, 50, 51, 89},
            };


      for(int i=0; i<mat.length; i++) {
    	  for(int j=0; j<mat[i].length; j++) {
    		  System.out.println("Values at arr["+i+"]["+j+"] is "+mat[i][j]);
    	  }
      }
      */
      
	return null;
    }
	
    //////////////////////////////////////////////////////////// EXERCISE 3 TEST
    static private Void testEx3 () throws TestException {
      int[][] t1 = {{2,1,1},{1,1,0},{0,1,1}};
      int[][] t2 = {{2,1,1},{0,1,1},{1,0,1}};
      int[][] t3 = {{0, 2}};
      if (! (ProgrammingAssignment3.virusSpread (t1) == 4  &&
             ProgrammingAssignment3.virusSpread (t2) == -1  &&
             ProgrammingAssignment3.virusSpread (t3) == 0))
        throw new TestException ("incorrect virus spread.");

      return null;
    }


    /////////////////////////////////////////////////// TESTING FRAMEWORK & MAIN
    static class TestException extends Exception  {
        static final long serialVersionUID = 314;
        public TestException (String msg) {
          super (msg);
        }
    }

    static private void runTest (String name, Callable<Void> test) {
      StdOut.println ("TESTING " + name);
      try {
        test.call ();
        StdOut.println ("SUCCESS");
      }
      catch (TestException e) {
        StdOut.println ("TEST FAILED: " + e.getMessage ());
      }
      catch (Exception | Error e) {
        StdOut.print ("FATAL: ");
        e.printStackTrace ();
      }
    }

    static public void main(String[] args) {
      runTest ("EX 1", Test::testEx1);
      runTest ("EX 2", Test::testEx2);
      runTest ("EX 3", Test::testEx3);
    }

}
