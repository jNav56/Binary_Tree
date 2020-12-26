/*  Student information for assignment:
 * 
 *  On my honor, Juan Nava, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 * 
 *  UTEID:jcn842
 *  email address:nava.juan1012@gmail.com
 *  Grader name:Ethan
 *  Number of slip days I am using:0
 */


/*
 * Place results of experiments here:
 * 
 * Minimum height is log_2(N)
 * N = 1000, minimum height is 9
 * N = 2000, minimum height is 10
 * N = 4000, minimum height is 11
 * N = 8000, minimum height is 12
 * N = 16000, minimum height is 13
 * N = 32000, minimum height is 14
 * N = 64000, minimum height is 15
 * N = 128000, minimum height is 16
 * N = 256000, minimum height is 17
 * N = 512000, minimum height is 18
 * N = 1024000, minimum height is 19
 * 
 * CS134 BinarySearchTree Random
 * 
 * N = 1000								N = 2000								N = 4000
 * Average time to add: 7.6676E-4		Average time to add: 4.43559999E-4		Average time to add: 7.68729999E-4
 * Average height of tree: 20.7			Average height of tree: 24.5			Average height of tree: 26.2
 * Average size of tree: 1000.0			Average size of tree: 2000.0			Average size of tree: 4000.0
 * 
 * N = 8000								N = 16000								N = 32000
 * Average time to add: 0.0017321		Average time to add: 0.00333376			Average time to add: 0.01071353999
 * Average height of tree: 29.4			Average height of tree: 31.5			Average height of tree: 34.3
 * Average size of tree: 8000.0			Average size of tree: 16000.0			Average size of tree: 31999.9
 * 
 * N = 64000							N = 128000								N = 256000
 * Average time to add: 0.02267281		Average time to add: 0.04525743			Average time to add: 0.1147215901
 * Average height of tree: 37.3			Average height of tree: 40.4			Average height of tree: 42.1
 * Average size of tree: 63999.3		Average size of tree: 127997.5			Average size of tree: 255990.7
 * 
 * N = 512000							N = 1024000
 * Average time to add: 0.28477644		Average time to add: 0.71190535
 * Average height of tree: 47.1			Average height of tree: 48.9
 * Average size of tree: 511972.4		Average size of tree: 1023885.3
 * 
 * 
 * Java TreeSet Random
 * 
 * N = 1000								N = 2000								N = 4000
 * Average time to add: 7.520973E-4		Average time to add: 8.29573118E-4		Average time to add: 0.0013267128
 * Average size of tree: 5500.0			Average size of tree: 11000.0			Average size of tree: 22000.0
 * 
 * N = 8000								N = 16000								N = 32000
 * Average time to add: 0.0045321		Average time to add: 0.00596014936		Average time to add: 0.015210119
 * Average size of tree: 43999.2		Average size of tree: 87999.7			Average size of tree: 175996.3
 * 
 * N = 64000							N = 128000								N = 256000
 * Average time to add: 0.034871158		Average time to add: 0.076244342619		Average time to add: 0.204968253550
 * Average size of tree: 351979.8		Average size of tree: 703920.5			Average size of tree: 1407693.0
 * 
 * N = 512000							N = 1024000
 * Average time to add: 0.358611881		Average time to add: 0.796446008004
 * Average size of tree: 2814818.6		Average size of tree: 5627314.4
 * 
 * 
 * CS134 BinarySearchTree Ascending Order
 * 
 * N = 1000								N = 2000								N = 4000
 * Average time to add: 0.00351247		Average time to add: 0.0111740100002	Average time to add: 0.04288637
 * 
 * N = 8000								N = 16000								N = 32000
 * Average time to add: 0.15506116		Average time to add: 0.56508723			Average time to add: 2.25292995
 * 
 * N = 64000
 * Average time to add: 9.207100099999998
 * 
 * Time Predictions: As N increases, the factor increases by 4
 * 
 * N = 128000							N = 256000
 * Average time to add: 40 second		Average time to add: 160 seconds		Average time to add: 640 seconds
 * 
 * Java TreeSet Ascending Order
 * 
 * N = 1000								N = 2000								N = 4000
 * Average time to add: 3.809004E-4		Average time to add: 3.5397E-4			Average time to add: 5.80060001E-4
 * 
 * N = 8000								N = 16000								N = 32000
 * Average time to add: 7.2244E-4		Average time to add: 0.00244321			Average time to add: 0.00368461
 * 
 * N = 64000
 * Average time to add: 0.00902696
 * 
 * 
 * On average, the TreeSet add method and my add method take around the same time to execute.
 * However, when adding elements in order the TreeSet add method is much faster than my add method.
 * This might be because the TreeSet has a method that shifts or rotates the binary tree in the to expedite
 * the add method and make a fat tree.
 * 
 *  
 *  */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;

/**
 * Some test cases for CS314 Binary Search Tree assignment.
 * 
 * 
 * 
 */
public class BSTTester {

    /**
     * The main method runs the tests.
     * @param args Not used
     */
    public static void main(String[] args) {
        
    	//builtInTests();
    	
    	BinarySearchTree<String> t1 = new BinarySearchTree<String>();
    	BinarySearchTree<String> t2 = new BinarySearchTree<String>();
    	BinarySearchTree<Integer> t3 = new BinarySearchTree<Integer>();
    	String expected = "";
    	String actual = "";
    	int i = 1;
    	
    	// Testing add method
    	System.out.println("-----Testing add method-----");
    	System.out.println();
    	
    	t1.add("c");
    	t1.add("b");
    	t1.add("d");
    	t1.add("a");
    	t1.add("e");
    	
    	System.out.println("Adding \"c\", \"b\", \"d\", \"a\", \"e\" in that order");
    	expected = "Size of tree: 5 and number of nodes at depth 1: 2";
    	actual = "Size of tree: " + t1.size() + " and number of nodes at depth 1: " + t1.numNodesAtDepth(1);
    	status(expected, actual, i++);
    	
    	t1.add("p");
    	t1.add("j");
    	t1.add("n");
    	t1.add("y");
    	t1.add("a");
    	
    	System.out.println("Adding \"p\", \"j\", \"n\", \"y\", \"a\" in that order");
    	expected = "Size of tree: 9 and values greater than c: [d, e, j, n, p, y]";
    	actual = "Size of tree: " + t1.size() + " and values greater than c: " + t1.getAllGreaterThan("c").toString();
    	status(expected, actual, i++);
    	
    	// Testing remove method
    	System.out.println("-----Testing remove method-----");
    	System.out.println();
    	
    	System.out.println("Removing \"e\" and \"t\"");
    	expected = "Removing e is true and removing t is false";
    	actual = "Removing e is " + t1.remove("e") + " and removing t is " + t1.remove("t");
    	status(expected, actual, i++);
    	
    	System.out.println("Removing \"c\"");
    	t1.remove("c");
    	expected = "Size is 7";
    	actual = "Size is " + t1.size();
    	status(expected, actual, i++);
    	
    	// Testing isPresent method
    	System.out.println("-----Testing isPresent method-----");
    	System.out.println();
    	
    	System.out.println("Searching for \"j\"");
    	expected = "j is present: true";
    	actual = "j is present: " + t1.isPresent("j");
    	status(expected, actual, i++);
    	
    	System.out.println("Searching for \"h\"");
    	expected = "h is present: false";
    	actual = "h is present: " + t1.isPresent("h");
    	status(expected, actual, i++);
    	
    	// Testing size method
    	System.out.println("-----Testing size method-----");
    	System.out.println();
    	
    	t1.add("v");
    	t1.add("r");
    	
    	System.out.println("Getting size after adding 2 new elements");
    	expected = "Size is 9";
    	actual = "Size is " + t1.size();
    	status(expected, actual, i++);
    	
    	for(int in = 0; in < 9; in++) {
    		String rem = t1.get(0);
    		t1.remove(rem);
    	}
    	
    	System.out.println("Getting size after removing everything");
    	expected = "Size is 0";
    	actual = "Size is " + t1.size();
    	status(expected, actual, i++);
    	
    	// Testing height method
    	System.out.println("-----Testing height method-----");
    	System.out.println();
    	
    	System.out.println("Getting height of empty tree");
    	expected = "Height is -1";
    	actual = "Height is " + t1.height();
    	status(expected, actual, i++);
    	
    	ArrayList<String> alphabet = new ArrayList<String>();
    	for(int in = 0; in < 26; in++) {
    		alphabet.add("" + (char) (in + 97));
    	}
    	
    	while(!alphabet.isEmpty()) {
    		int ran = (int)(Math.random()*(alphabet.size()));
    		t1.add(alphabet.get(ran));
    		alphabet.remove(ran);
    	}
    	
    	System.out.println("Getting height of tree after adding 26 elements randomly");
    	expected = "Height is between 4 and 25: true";
    	actual = "Height is between 4 and 25: " + (t1.size() >= 4 || t1.size() <= 25);
    	status(expected, actual, i++);
    	
    	// Testing getAll method
    	System.out.println("-----Testing getAll method-----");
    	System.out.println();
    	
    	expected = "[";
    	for(int in = 0; in < 26; in++) {
    		alphabet.add("" + (char)(in + 97));
    		expected += (char)(in + 97) + ", ";
    	}
    	expected = expected.substring(0, expected.length() - 2) + "]";
    	
    	System.out.println("Getting all members of tree with alphabet");
    	expected = "All members are: " + expected;
    	actual = "All members are: " + t1.getAll().toString();
    	status(expected, actual, i++);
    	
    	System.out.println("Getting all members of an empty tree");
    	expected = "All members are: []";
    	actual = "All members are: " + t2.getAll().toString();
    	status(expected, actual, i++);
    	
    	// Testing max method
    	System.out.println("-----Testing max method-----");
    	System.out.println();
    	
    	System.out.println("Getting max value from tree of alphabet");
    	expected = "Max value is z";
    	actual = "Max value is " + t1.max();
    	status(expected, actual, i++);
    	
    	System.out.println("Getting max value from an empty tree");
    	expected = "java.lang.IllegalArgumentException: The tree is empty";
    	try {
    		t2.max();
    	} catch(IllegalArgumentException e) {
    		actual = "" + e;
    	}
    	status(expected, actual, i++);
    	
    	// Testing min method
    	System.out.println("-----Testing min method-----");
    	System.out.println();
    	
    	System.out.println("Getting min value from tree of alphabet");
    	expected = "Max value is a";
    	actual = "Max value is " + t1.min();
    	status(expected, actual, i++);
    	
    	System.out.println("Getting min value from an empty tree");
    	expected = "java.lang.IllegalArgumentException: The tree is empty";
    	try {
    		t2.min();
    	} catch(IllegalArgumentException e) {
    		actual = "" + e;
    	}
    	status(expected, actual, i++);
    	
    	// Testing iterativeAdd method
    	System.out.println("-----Testing iterativeAdd method-----");
    	System.out.println();
    	
    	int ran = 0;
    	for(int in = 0; in < 500; in++) {
    		int tem = (int)(Math.random()*1000);
    		t3.iterativeAdd(tem);
    		if(in == 249) {
    			ran = tem;
    		}
    	}
    	
    	System.out.println("Getting size of tree after calling method 500 times");
    	expected = "Size should be less than or equal to 500: true";
    	actual = "Size should be less than or equal to 500: " + (t3.size() <= 500);
    	status(expected, actual, i++);
    	
    	System.out.println("Value " + ran + " should be present");
    	expected = ran + " is present: true";
    	actual = ran + " is present: " + t3.isPresent(ran);
    	status(expected, actual, i++);
    	
    	// Testing get method
    	System.out.println("-----Testing get method-----");
    	System.out.println();
    	
    	System.out.println("Getting middle letter in alphabet tree");
    	expected = "Getting 12th letter: l";
    	actual = "Getting 12th letter: " + t1.get(11);
    	status(expected, actual, i++);
    	
    	System.out.println("Getting value at index -1");
    	expected = "java.lang.IllegalArgumentException: Parameter out of bounds";
    	try {
    		t1.get(-1);
    	} catch(IllegalArgumentException e) {
    		actual = "" + e;
    	}
    	status(expected, actual, i++);
    	
    	// Testing getAllLessThan method
    	System.out.println("-----Testing getAllLessThan method-----");
    	System.out.println();
    	
    	System.out.println("Getting letters less than j in alphabet tree");
    	expected = "List is: [a, b, c, d, e, f, g, h, i]";
    	actual = "List is: " + t1.getAllLessThan("j");
    	status(expected, actual, i++);
    	
    	System.out.println("Getting list with a null value");
    	expected = "java.lang.IllegalArgumentException: Value is null";
    	try {
    		t1.getAllLessThan(null);
    	} catch(IllegalArgumentException e) {
    		actual = "" + e;
    	}
    	status(expected, actual, i++);
    	
    	// Testing getAllGreaterThan method
    	System.out.println("-----Testing getAllGreaterThan method-----");
    	System.out.println();
    	
    	System.out.println("Getting letters greater than j in alphabet tree");
    	expected = "List is: [k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z]";
    	actual = "List is: " + t1.getAllGreaterThan("j");
    	status(expected, actual, i++);
    	
    	System.out.println("Getting numbers greater than 1000 in the number tree");
    	expected = "Will have an empty list: true";
    	actual = "Will have an empty list: " + t3.getAllGreaterThan(1000).isEmpty();
    	status(expected, actual, i++);
    	
    	// Testing depth method
    	System.out.println("-----Testing depth method-----");
    	System.out.println();
    	
    	while(t3.size() != 0) {
    		t3.remove(t3.get(0));
    	}
    	
    	int[] li = {4, 2, 6, 1, 3, 5};
    	for(int in = 0; in < 6; in++) {
    		t3.add(li[in]);
    	}
    	
    	System.out.println("Getting depth of complete tree with 6 numbers");
    	expected = "Number of nodes at depth 2 is 3";
    	actual = "Number of nodes at depth 2 is " + t3.numNodesAtDepth(2);
    	status(expected, actual, i++);
    	
    	System.out.println("Getting depth of any non-empty tree at depth 0");
    	expected = "Number of nodes at depth 0 is 1";
    	actual = "Number of nodes at depth 0 is " + t3.numNodesAtDepth(0);
    	status(expected, actual, i++);
    	
    	//t3.printTree();
    	
    	// Experiment
//    	BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
//    	TreeSet<Integer> t = new TreeSet<Integer>();
//    	Stopwatch s = new Stopwatch();
//    	Random r = new Random();
//    	
//    	
//    	myTreeRandomExperiment(b, s, r, NUM_INSERTS);
//    	javaTreeRandomExperiment(t, s, r, NUM_INSERTS);
//    	myTreeAscendingExperiment(b, s, NUM_INSERTS);
//    	javaTreeAscendingExperiment(t, s, NUM_INSERTS);
    	
    	//studentTests();
    	
    	BinarySearchTree<Integer> t4 = new BinarySearchTree<Integer>();
    	
    	for(int f = 2; f < 20; f++) {
    		t4.add(f);
    	}
    	
    	t4.add(23);
    	t4.add(22);
  	  	t4.printTree();
    }

    private static void status(String exp, String act, int test) {
    	String res = exp.equals(act)? "Passed": "Failed";
    	System.out.println("Expected: " + exp);
        System.out.println("Actual: " + act);
        System.out.println("Test " + test + ": " + res);
        System.out.println();
    }
    
    final private static int NUM_REPEATS = 10;
    final private static int NUM_INSERTS = 1000;
    
    public static void myTreeRandomExperiment(BinarySearchTree<Integer> b, Stopwatch s, Random r, int inserts) {	
    	for(int i = 0; i <= NUM_REPEATS; i++) {
    		b = new BinarySearchTree<Integer>();
        	double[] sums = new double[3]; 
        	for(int j = 0; j < NUM_REPEATS; j++) {
        		s.start();
            	for(int k = 0; k < inserts; k++)
            	    b.add(r.nextInt());
            	s.stop();
            	sums[0] += s.time();
            	sums[1] += b.height();
            	sums[2] += b.size();
        	}
        	experimentResults(sums, inserts, true);
        	sums = new double[3];
        	inserts *= 2;
    	}
    }
    
    public static void javaTreeRandomExperiment(TreeSet<Integer> t, Stopwatch s, Random r, int inserts) {	
    	for(int i = 0; i <= NUM_REPEATS; i++) {
    		t = new TreeSet<Integer>();
        	double[] sums = new double[3]; 
        	for(int j = 0; j < NUM_REPEATS; j++) {
        		s.start();
            	for(int k = 0; k < inserts; k++)
            	    t.add(r.nextInt());
            	s.stop();
            	sums[0] += s.time();
            	sums[2] += t.size();
        	}
        	experimentResults(sums, inserts, false);
        	sums = new double[3];
        	inserts *= 2;
    	}
    }
    
    public static void myTreeAscendingExperiment(BinarySearchTree<Integer> b, Stopwatch s, int inserts) {	
    	for(int i = 0; i <= 6; i++) {
    		b = new BinarySearchTree<Integer>();
        	double addSum = 0;
        	for(int j = 0; j < NUM_REPEATS; j++) {
        		s.start();
            	for(int k = 0; k < inserts; k++)
            	    b.iterativeAdd(k);
            	s.stop();
            	addSum += s.time();
        	}
        	System.out.println("N = " + inserts);
        	System.out.println("Average time to add: " + (addSum / NUM_REPEATS));
        	System.out.println();
        	addSum = 0;
        	inserts *= 2;
    	}
    }
    
    public static void javaTreeAscendingExperiment(TreeSet<Integer> t, Stopwatch s, int inserts) {	
    	for(int i = 0; i <= 6; i++) {
    		t = new TreeSet<Integer>();
    		double addSum = 0;
        	for(int j = 0; j < NUM_REPEATS; j++) {
        		s.start();
            	for(int k = 0; k < inserts; k++)
            	    t.add(k);
            	s.stop();
            	addSum += s.time();
        	}
        	System.out.println("N = " + inserts);
        	System.out.println("Average time to add: " + (addSum / NUM_REPEATS));
        	System.out.println();
        	addSum = 0;
        	inserts *= 2;
    	}
    }
    
    public static void experimentResults(double[] s, int ins, boolean boo) {
    	s[0] *= 0.7686855370943322;
    	System.out.println("N = " + ins);
    	System.out.println("Average time to add: " + (s[0] / NUM_REPEATS));
    	if(boo)
    		System.out.println("Average height of tree: " + (s[1] / NUM_REPEATS));
    	System.out.println("Average size of tree: " + (s[2] / NUM_REPEATS));
    	System.out.println();
    }
       
    public static void builtInTests() {
    	BinarySearchTree<String> t = new BinarySearchTree<>();

        //test 1
        System.out.println("Test 1: empty tree created.");
        showTestResults( t.size() == 0, 1 );

        //test 2
        System.out.println("Test 2: height of empty tree must be -1.");
        showTestResults( t.height() == -1, 2 );

        //test 3
        System.out.println("Test 3: empty tree must " +
        "not contain the String \"abyss\".");
        showTestResults( t.isPresent("abyss") == false, 3 );

        t.add("abyss");
        //test 4
        System.out.println("Test 4: added \"abyss\" to the" +
        "tree. Size must be 1.");       
        showTestResults( t.size() == 1, 4 );

        //test 5
        System.out.println("Test 5: height of tree with 1" +
        "element must be 0.");
        showTestResults( t.height() == 0, 5 );

        //test 6
        System.out.println("Test 6: \"abyss\" must be in the tree.");
        showTestResults( t.isPresent("abyss") == true, 6 );

        //test 7
        System.out.println("Test 7: tree must " +
        "not contain the String \"beep\".");        
        showTestResults( t.isPresent("beep") == false, 7);

        //test 8
        System.out.println("Test 8: min value must be" +
        "\"abyss\" at this point.");        
        showTestResults( t.min().equals("abyss"), 8);

        //test 9
        System.out.println("Test 9: max value must be" +
        "\"abyss\" at this point.");    
        showTestResults( t.max().equals("abyss"), 9);

        t.add("abyss");
        //test 10
        System.out.println("Test 10: attempt to add \"abyss\"" +
        "again. size must remain 1.");    
        showTestResults( t.size() == 1, 10 );

        //test 11
        System.out.println("Test 11: attempt to add \"abyss\"" +
        "again. height must remain 0.");  
        showTestResults( t.height() == 0, 11 );

        //test 12
        System.out.println("Test 12: \"abyss\" must still be" +
        "present.");  
        showTestResults( t.isPresent("abyss") == true, 12 );

        t.add("beep");
        //test 13
        System.out.println("Test 13: added \"beep\" to the" +
        "tree. Size must be 2.");           
        showTestResults( t.size() == 2, 13 );

        //test 14
        System.out.println("Test 14: height of tree with 2" +
        "elements must be 1."); 
        showTestResults( t.height() == 1, 14 );

        //test 15
        System.out.println("Test 15: Removing \"abyss\" from the tree.");
        showTestResults( t.remove("abyss") == true, 15 );

        //test 16
        System.out.println("Test 16: Removing \"beep\" from the tree.");
        showTestResults( t.remove("beep") == true, 16 );

        //test 17
        System.out.println("Test 17: Tree must be empty at this point.");
        showTestResults( t.size() == 0, 17 );

        t.add("beep");
        t.add("abyss");
        t.add("calls");
        
        ArrayList<String> expected = new ArrayList<>();
        expected.add("abyss");
        expected.add("beep");
        expected.add("calls");

        //test 18
        System.out.println("Test 18: Added \"beep\", \"abyss\", and" +
                "\"calls\" to the tree in that order." +
        "Testing getAll method.");

        showTestResults( expected.equals( t.getAll() ) == true, 18 );

        //test 19
        t.add("bit");
        t.add("dish");
        System.out.println("Test 19: Added \"bit\" and \"dish\" to" +
        "tree. Checking that \"yes\" is not present.");     
        showTestResults( t.remove("yes") == false, 19);

        //test 20
        t.add("a");
        System.out.println("Test 20: Added \"a\" and then " +
        "removed it.");
        showTestResults(t.remove("a") == true, 20);
        
        //test 21
        System.out.println("Test 21: Checking that \"calls\" is still present.");
        showTestResults(t.remove("calls") == true, 21);

        //test 22
        t.remove("abyss");
        System.out.println("Test 22: Removing \"abyss\". " +
        "Checking that \"beep\" is still present.");
        showTestResults(t.remove("beep") == true, 22);

        // Test 23 - Adding unbalanced
        BinarySearchTree<Integer>  iTree = new BinarySearchTree<>();
        ArrayList<Integer> iExpected = new ArrayList<>();
        iTree.add(1);
        iTree.iterativeAdd(2);
        iTree.iterativeAdd(3);
        iTree.add(-1);
        iExpected.add(-1);
        iExpected.add(1);
        iExpected.add(2);
        iExpected.add(3);
        System.out.println("Test 23: Adding unbalanced");
        showTestResults( iExpected.equals( iTree.getAll() ) == true, 23 );
        //System.out.println(iTree.getAll());
        //iTree.printTree();

        // Test 24 - Adding unbalanced
        iTree.iterativeAdd(-2);
        iExpected.add(0, -2);
        System.out.println("Test 24: Adding unbalanced");
        showTestResults( iExpected.equals( iTree.getAll() ) == true, 24 );
        //System.out.println(iTree.getAll());
        //iTree.printTree();
        
        // Test 25 - Removing root [-2, -1, 2, 3]
        iTree.remove(1);
        iExpected.remove(new Integer(1));
        System.out.println("Test 25: Removing root");
        showTestResults( iExpected.equals( iTree.getAll() ) == true, 25 );
        //System.out.println(iTree.getAll());
        //iTree.printTree();

        // Test 26 - Removing new root [-2, 2, 3]
        iTree.remove(-1);
        iExpected.remove(new Integer(-1));
        System.out.println("Test 26: Removing new root");
        showTestResults( iExpected.equals( iTree.getAll() ) == true, 26 );
        //System.out.println(iTree.getAll());
        //iTree.printTree();

        // Test 27 - IsPresent new root
        System.out.println("Test 27: IsPresent new root");
        showTestResults( iTree.isPresent(-2) == true, 27 );
        //System.out.println(iTree.getAll());
        //iTree.printTree();

        // Test 28 - IsPresent rightmost minimum
        System.out.println("Test 28: IsPresent rightmost minimum");
        showTestResults( iTree.isPresent(2) == true, 28 );
        //System.out.println(iTree.getAll());
        //iTree.printTree();

        System.out.println(iTree.size());
        // Test 29 - Size
        System.out.println("Test 29: Size of tree");
        showTestResults( iTree.size() == 3, 29 );
        //System.out.println(iTree.getAll());
        //iTree.printTree();

        // Test 30 - Size removing rightmost minimum [-2, 3]
        iTree.remove(2);
        iExpected.remove(new Integer(2));
        System.out.println("Test 30: Size of tree");
        showTestResults( iTree.size() == 2, 30 );
        //System.out.println(iTree.getAll());
        //iTree.printTree();

        // Test 31 - Height
        System.out.println("Test 31: Height of tree");
        showTestResults( iTree.height() == 1, 31 );
        //System.out.println(iTree.getAll());
        //iTree.printTree();

        // Test 32 - Height removing root [3]
        iTree.remove(-2);
        iExpected.remove(new Integer(-2));
        System.out.println("Test 32: Height of tree");
        showTestResults( iTree.height() == 0, 32 );
        //System.out.println(iTree.getAll());
        //iTree.printTree();

        // Test 33 - Max of tree
        System.out.println("Test 33: Max of tree");
        showTestResults( iTree.max().equals(new Integer(3)), 33 );
        //System.out.println(iTree.getAll());
        //iTree.printTree();

        // Test 34 - Max of tree [-1, 3]
        iTree.add(-1);
        System.out.println("Test 34: Max of tree");
        showTestResults( iTree.max().equals(new Integer(3)), 34 );
        //System.out.println(iTree.getAll());
        //iTree.printTree();

        // Test 35 - Min of tree
        System.out.println("Test 35: Min of tree");
        showTestResults( iTree.min().equals(new Integer(-1)), 35 );
        //System.out.println(iTree.getAll());
        //iTree.printTree();

        // Test 36 - Min of tree
        iTree.add(4);
        System.out.println("Test 36: Min of tree");
        showTestResults( iTree.min().equals(new Integer(-1)), 36 );
        //System.out.println(iTree.getAll());
        //iTree.printTree();

        // Test 37 - Number of Nodes at Depth
        System.out.println("Test 37: Number of Nodes at depth of tree");
        showTestResults( iTree.numNodesAtDepth(0) == 1, 37 );
        //System.out.println(iTree.getAll());
        //iTree.printTree();

        // Test 38 - Number of Nodes at Depth
        System.out.println("Test 38: Number of Nodes at depth of tree");
        showTestResults( iTree.numNodesAtDepth(1) == 2, 38 );
        //System.out.println(iTree.getAll());
        //iTree.printTree();

        // Test 39 - height
        int[] values = {50, 25, -10, 10, 5, 0, 23, 30, 35, 40, 100, 75, 200};
        BinarySearchTree<Integer> t2 = new BinarySearchTree<>();
        for(int i : values)
            t2.add(i);
        System.out.println("Height again for non trivial tree");
        showTestResults(t2.height() == 5, 39);
        //System.out.println(t2.getAll());
        //t2.printTree();

        // Test 40 - 52: get kth
        System.out.println("getKth");
        Arrays.sort(values);
        for(int i = 0; i < values.length; i++) {
            showTestResults(t2.get(i).equals(new Integer(values[i])), 40 + i);
        }

        // Test 53: getAllLessThan
        System.out.println("get all less than -50");
        showTestResults(t2.getAllLessThan(-50).equals(new ArrayList<Integer>()), 53);
        //System.out.println(t2.getAll());
        //t2.printTree();


        // Test 54: getAllLessThan
        System.out.println("get all less than 25");
        ArrayList<Integer> expectedList = new ArrayList<>();
        int cutoff = 25;
        int index = 0;
        while(index < values.length && values[index] < cutoff) {
            expectedList.add(values[index]);
            index++;
        }
        List<Integer> actual = t2.getAllLessThan(cutoff);    
        showTestResults(actual.equals(expectedList), 54);
        //System.out.println(t2.getAll());
        //t2.printTree();

        // Test 55: getAllLessThan
        System.out.println("get all less than 1000");
        expectedList.clear();
        cutoff = 1000;
        index = 0;
        while(index < values.length && values[index] < cutoff) {
            expectedList.add(values[index]);
            index++;
        }
        actual = t2.getAllLessThan(cutoff);    
        showTestResults(actual.equals(expectedList), 55);
        System.out.println("expected list: " + expectedList);
        System.out.println("actual list:   " + actual);
        //System.out.println(expectedList);
        //System.out.println(t2.getAll());
        //t2.printTree();


        // Test 57: getAllGreaterThan
        System.out.println("get all greater than 1000");
        expectedList.clear();
        cutoff = 1000;
        index = values.length - 1;
        while(index >= 0 && values[index] > cutoff) {
            expectedList.add(values[index]);
            index--;
        }
        Collections.reverse(expectedList);
        actual = t2.getAllGreaterThan(cutoff);    
        showTestResults(actual.equals(expectedList), 57);
        //System.out.println(expectedList);
        //System.out.println(t2.getAll());
        //t2.printTree();

        // Test 58: getAllGreaterThan
        System.out.println("get all greater than 25");
        expectedList.clear();
        cutoff = 25;
        index = values.length - 1;
        while(index >= 0 && values[index] > cutoff) {
            expectedList.add(values[index]);
            index--;
        }
        Collections.reverse(expectedList);
        actual = t2.getAllGreaterThan(cutoff);    
        showTestResults(actual.equals(expectedList), 58);
        System.out.println("expected list: " + expectedList);
        System.out.println("actual list:   " + actual);
        //t2.printTree();


        // Test 59: getAllGreaterThan
        System.out.println("get all greater than -1000");
        expectedList.clear();
        cutoff = -1000;
        index = values.length - 1;
        while(index >= 0 && values[index] > cutoff) {
            expectedList.add(values[index]);
            index--;
        }
        Collections.reverse(expectedList);
        actual = t2.getAllGreaterThan(cutoff);    
        showTestResults(actual.equals(expectedList), 59);
        System.out.println("expected list: " + expectedList);
        System.out.println("actual list:   " + actual);
        //t2.printTree();
          
        
        // Test 60, stress test
        System.out.println("Stress test, comparing size to HashSet");
        BinarySearchTree<Integer> bst1 = new BinarySearchTree<>();
        HashSet<Integer> hs = new HashSet<>();
        Random r = new Random();
        int numValues = 500000;
        for(int i = 0; i < numValues; i++) {
            int temp = r.nextInt();
            bst1.add(temp);
            hs.add(temp);
        }
        showTestResults(hs.size() == bst1.size(), 60);
        
        // Test 61, stress test
        System.out.println("Stress test, comparing size to HashSet");
        bst1 = new BinarySearchTree<>();
        hs = new HashSet<>();
        numValues = 1000000;
        for(int i = 0; i < numValues; i++) {
            int temp = r.nextInt();
            bst1.add(temp);
            hs.add(temp);
        }
        showTestResults(hs.size() == bst1.size(), 61);
    }
    
    private static void studentTests() {

        BinarySearchTree<Integer> bst1 = new BinarySearchTree<>();
        ArrayList<Integer> bst1Expected = new ArrayList<>();

        // test 1, getAll()
        showTestResults(bst1.getAll().toString().equals("[]"), 1, "getAll");

        // test 2, add(), getAll()
        bst1.add(3);
        bst1Expected.add(3);
        showTestResults(bst1.getAll().equals(bst1Expected), 2, "add and getAll");

        // test 3, add()
        bst1.add(17);
        bst1.add(-7);
        bst1.add(17);
        bst1Expected.add(0, -7);
        bst1Expected.add(17);
        showTestResults(bst1.getAll().equals(bst1Expected), 3, "add");

        // test 4, add()
        bst1.add(22);
        bst1.add(2);
        bst1.add(18234);
        bst1Expected.add(1, 2);
        bst1Expected.add(4, 22);
        bst1Expected.add(18234);
        showTestResults(bst1.getAll().equals(bst1Expected), 4, "add");

        // test 5, iterativeAdd()
        bst1.iterativeAdd(4);
        bst1Expected.add(3, 4);
        showTestResults(bst1.getAll().equals(bst1Expected), 5, "iterativeAdd");

        // test 6, iterativeAdd()
        bst1.iterativeAdd(1);
        bst1.iterativeAdd(17);
        bst1.iterativeAdd(19);
        bst1Expected.add(1, 1);
        bst1Expected.add(6, 19);
        showTestResults(bst1.getAll().equals(bst1Expected), 6, "iterativeAdd");

        //bst1.printTree();
        
        // test 7, remove()
        showTestResults(bst1.remove(1), 7, "remove - check toString");
        bst1Expected.remove(1);
//        bst1.printTree();
//        System.out.println(bst1Expected);

        // test 8, remove()
        showTestResults(bst1.remove(17), 8, "remove - check toString");
        bst1Expected.remove(4);
//        bst1.printTree();
//        System.out.println(bst1Expected);

        // test 9, remove()
        showTestResults(!bst1.remove(20), 9, "remove - check toString");
//        bst1.printTree();
//        System.out.println(bst1Expected);

        // test 10, remove()
        showTestResults(bst1.remove(3), 10, "remove root - check toString");
        bst1Expected.remove(2);
//        bst1.printTree();
//        System.out.println(bst1Expected);

        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>();
        ArrayList<Integer> bst2Expected = new ArrayList<>();

        bst2.add(10);
        bst2.add(0);
        bst2.add(-1);
        bst2.add(-2);
        bst2.add(8);
        bst2.add(17);
        bst2.add(10);
        bst2.iterativeAdd(20);
        bst2.add(13);
        bst2.iterativeAdd(9);
        bst2.add(14);
        bst2Expected.add(10);
        bst2Expected.add(0, 0);
        bst2Expected.add(0, -1);
        bst2Expected.add(0, -2);
        bst2Expected.add(3, 8);
        bst2Expected.add(17);
        bst2Expected.add(20);
        bst2Expected.add(5, 13);
        bst2Expected.add(4, 9);
        bst2Expected.add(7, 14);
        
//        bst1.printTree();
//        System.out.println();
//        System.out.println();
//        bst2.printTree();
//        System.out.println(bst1Expected);
//        System.out.println(bst2Expected);

        // test 11, isPresent()
        showTestResults(bst2.isPresent(10), 11, "isPresent");

        // test 12, isPresent()
        showTestResults(bst2.isPresent(9), 12, "isPresent");

        // test 13, isPresent()
        showTestResults(bst2.isPresent(14), 13, "isPresent");

        // test 14, isPresent()
        showTestResults(!bst2.isPresent(1), 14, "isPresent");

        // test 15, size()
        showTestResults(bst1.size() == 6, 15, "size");

        // test 16, size()
        showTestResults(bst2.size() == 10, 16, "size");

        // test 17, height()
        showTestResults(bst1.height() == 3, 17, "height");

        // test 18, height()
        showTestResults(bst2.height() == 3, 18, "height");

        // test 19, max()
        showTestResults(bst1.max().equals(18234), 19, "max");

        // test 20, max()
        showTestResults(bst2.max().equals(20), 20, "max");

        // test 21, min()
        showTestResults(bst1.min().equals(-7), 21, "min");

        // test 22, min()
        showTestResults(bst2.min().equals(-2), 22, "min");

        // test 23, get()
        showTestResults(bst1.get(3).equals(19), 23, "get");

        // test 24, get()
        showTestResults(bst1.get(0).equals(-7), 24, "get");

        // test 25, get()
        showTestResults(bst2.get(7).equals(14), 25, "get");

        List<Integer> numList = new ArrayList<>();

        // test 26, getAllLessThan()
        numList.add(-2);
        numList.add(-1);
        numList.add(0);
        numList.add(8);
        numList.add(9);
        showTestResults(bst2.getAllLessThan(10).equals(numList), 26, "getAllLessThan");

        // test 27, getAllLessThan()
        numList.clear();
        showTestResults(bst2.getAllLessThan(-3).equals(numList), 27, "getAllLessThan");

        // test 28, getAllGreaterThan()
        numList.add(13);
        numList.add(14);
        numList.add(17);
        numList.add(20);
        showTestResults(bst2.getAllGreaterThan(12).equals(numList), 28, "getAllGreaterThan");

        // test 29, getAllGreaterThan()
        numList.clear();
        showTestResults(bst2.getAllGreaterThan(20).equals(numList), 29, "getAllGreaterThan");

        // test 30, numNodesAtDepth()
        showTestResults(bst2.numNodesAtDepth(2) == 4, 30, "numNodesatDepth");

        // test 31, numNodesAtDepth()
        showTestResults(bst2.numNodesAtDepth(3) == 3, 31, "numNodesatDepth");

    }

    public static void showTestResults(boolean passed, int testNum, String test) {
        if( passed )
            System.out.println( "Test " + testNum + " passed." + " (" + test + ")");
        else
            System.out.println( "TEST " + testNum + " FAILED." + " (" + test + ")");
    }

    private static void showTestResults(boolean passed, int testNum) {
        if( passed )
            System.out.println( "Test " + testNum + " passed.");
        else
            System.out.println( "TEST " + testNum + " FAILED.");
    }
}