import java.util.ArrayList;
import java.util.List;

/**
 * Shell for a binary search tree class.
 * @author scottm
 * @param <E> The data type of the elements of this BinartSearchTree.
 * Must implement Comparable or inherit from a class that implements
 * Comparable.
 *
 */
public class BinarySearchTree<E extends Comparable<? super E>> {

    private BSTNode<E> root;
    private int size;

    public BinarySearchTree() {
    	root = null;
    	size = 0;
    }

    /*  Add the specified item to this Binary Search Tree if it is not already present.
     *  Return true if data was not present before this call to add, false otherwise.
     *  pre: value != null */
    public boolean add(E value) {
    	if(value == null) {
    		throw new IllegalArgumentException("Value is null");
    	}
    	// Handles special case where tree is empty
    	if(root == null) {
    		root = new BSTNode<E>(value);
    		size++;
    		return true;
    	}
        return addHelper(root, value);
    }
    
    /* Returns true if value we are adding is not present prior to adding
     * @param n is traversal node
     * @param val is value we are adding */
    private boolean addHelper(BSTNode<E> n, E val) {
    	// Return false if value already exists 
    	if(val.equals(n.getData())) {
    		return false;
    	}
    	// Get the reference to left or right child based on comparison
    	BSTNode<E> temp = val.compareTo(n.getData()) < 0? n.getLeft(): n.getRight();
    	
    	// If child reference is not null, continue down the tree
    	if(temp != null) {
    		return addHelper(temp, val);
    	}
    	
    	// Set the left node to a new node with value of val is less than current node
    	// otherwise set the right node to a new node with value of val
    	if(val.compareTo(n.getData()) < 0) {
			n.setLeft(new BSTNode<E>(val));
		} else {
			n.setRight(new BSTNode<E>(val));
		}
    	// Increase size
		size++;
    	return true;
    }

    /* Return true if a specified item from this Binary Search Tree if it is present
     *  pre: value != null */
    public boolean remove(E value) {
    	// Check precondition, value must not be null
    	if(value == null) {
    		throw new IllegalArgumentException("Value is null");
    	}
    	// Handles special case where there is one element and it equals target value
    	if(size() == 1 && value.equals(root.getData())) {
    		root = null;
    		size--;
    		return true;
    	}
    	
        return removeHelper(root, value, root);
    }
    
    /* Traverse through tree until we find the target value, return true if the target value
     * was found, otherwise false
     * @param n is the traversal node
     * @param val is the target value
     * @param is the parent value of the current node we are in */
    private boolean removeHelper(BSTNode<E> n, E val, BSTNode<E> parent) {
    	// If current node is null, return false because we cannot traverse any longer
    	if(n == null) {
    		return false;
    	}
    	// Get the comparison value between the target value and the current data
    	int com = val.compareTo(n.getData());
    	// If target value is less than or greater than current member, go to left or right child
    	if(com < 0) {
    		return removeHelper(n.getLeft(), val, n);
    	} else if(com > 0) {
    		return removeHelper(n.getRight(), val, n);
    	}
		finallyRemoveMember(n, val, parent);
		// Decrease size to account for change and return true
		size--;
		return true;
    }

    // Remove a member from the tree
    private void finallyRemoveMember(BSTNode<E> n, E val, BSTNode<E> parent) {
    	// Current member is equal to target value, so get references to both
    	// children nodes of current nodes
    	BSTNode<E> left = n.getLeft();
		BSTNode<E> right = n.getRight();
		
		// Enter if-statement if node has two children
		if(left != null && right != null) {
			// Get maximum value from members on the left side of the current node
			E maxOnLeft = getMaxFromNode(n.getLeft());
			n.setData(maxOnLeft); // Set the current node to the max value
			removeHelper(n.getLeft(), maxOnLeft, n); // Remove node containing the max value
			size++; // Increase the size to account for decreasing size two times
			
		// Enter it-statement if node is leaf node
		} else if(left == null && right == null) {
			// If the current node is the left child of the parent node, set the parent's left
			// node to null otherwise set the parent's right to null
			if(parent.getLeft() != null && val.equals(parent.getLeft().getData())) {
				parent.setLeft(null);
			} else {
				parent.setRight(null);
			}
			
		// Enter if-statement if the node has one child
		} else {
			// Get reference of child node
			BSTNode<E> rep = left != null && right == null? n.getLeft(): n.getRight(); 
			// Set the data of current node to child node's data
        	n.setData(rep.getData());
        	// Set the current node's reference to the child nodes of the child node
        	n.setLeft(rep.getLeft());
    		n.setRight(rep.getRight());
		}
    }
    
    /* Return max value from given node 
     * @param n is the starting node */
    private E getMaxFromNode(BSTNode<E> n) {
		// Return data of current node if there is no value bigger than it
    	if(n.getRight() == null) {
    		return n.getData();
    	}   	
		return getMaxFromNode(n.getRight());
	}
      
	/* Return true if the specified element is in this Binary Search Tree
     * pre: value != null
     * @param value the value to look for in the tree */
    public boolean isPresent(E value) {
    	// Check precondition, value must not be null
    	if(value == null) {
    		throw new IllegalArgumentException("Value is null");
    	}
        return presentHelper(root, value);
    }
    
    /* Returns true if current node n is equal to value val
     * @param n is traversal node
     * @param val is value we are looking for */
    private boolean presentHelper(BSTNode<E> n, E val) {
    	// Returns false if the current node is false
    	if(n == null) {
    		return false;
    	}
    	// Returns true if we have found the value we are looking for
    	if(val.equals(n.getData())) {
    		return true;
    	}
    	// If current node does not equal the target value, then go down to children nodes
    	return presentHelper(n.getLeft(), val) || presentHelper(n.getRight(), val);
    }

    // Return how many elements are in this Binary Search Tree.
    public int size() {
        return size;
    }

    /* Return the height of this Binary Search Tree.
     * If the tree is empty return -1, otherwise return the height of the tree */
    public int height() {
        return size() == 0? -1: heightHelper(root);
    }

    /* Traverses tree and returns an int representing the height
     * @param n is the traversal node */
    private int heightHelper(BSTNode<E> n) {
    	// Return a 0 if the node is null
    	if(n == null) {
    		return 0;
    	}
    	// Int height will be 0 if current node is a leaf, otherwise height will be 1
    	int height = (n.getLeft() == null && n.getRight() == null)? 0: 1;
    	// Get the height starting from the left and right child
    	int left = heightHelper(n.getLeft());
    	int right = heightHelper(n.getRight());
		
    	// Return height and the greater value between left and right
		return height + (left > right? left: right);
	}

	/* Return a list of all the elements in this Binary Search Tree in ascending order
	 * If the tree is empty return an empty List */
    public List<E> getAll() {
    	// ArrayList to hold the elements in ascending order
    	ArrayList<E> result =  new ArrayList<E>();
    	// Traverse tree in ascending order to add values
    	getAllHelper(root, result);
    	
        return result;
    }

    /* Method will traverse tree in ascending order and add all values
     * Traversal node goes to sub trees and checks the left node, then the parent, and the right node
     * to keep the ascending order
     * @param n is a traversal node
     * @param list is an ArrayList to keep the elements < val */
    private void getAllHelper(BSTNode<E> n, ArrayList<E> list) {
    	// Method does nothing does nothing if node we are looking at is null
    	if(n != null) {
    		// Keeps traversal node going left to get to the first element of each subtree
    		getAllHelper(n.getLeft(), list);
    		
    		// Add current node that also serves as a parent node
    		list.add(n.getData());
    		
    		// Go to the next node that also acts the third element of each subtree
    		getAllHelper(n.getRight(), list);
    	}
    }

    /* Return the maximum value in this binary search tree
     * pre: size() > 0
     * post: return the largest value in this Binary Search Tree */
    public E max() {
    	// Check precondition, tree must not be empty
    	if(size() == 0) {
    		throw new IllegalArgumentException("The tree is empty");
    	}
    	//Traversal node
    	BSTNode<E> n = root;
    	
    	// Keep going right if a non-empty node exists
    	while(n.getRight() != null) {
    		n = n.getRight();
    	}
        return n.getData();
    }

    /* Return the minimum value in this binary search tree.
     * pre: size() > 0
     * post: return the smallest value in this Binary Search Tree */
    public E min() {
    	// Check precondition, tree must not be empty
    	if(size() == 0) {
    		throw new IllegalArgumentException("The tree is empty");
    	}
    	//Traversal node
    	BSTNode<E> n = root;
    	
    	// Keep going left if a non-empty node exists
    	while(n.getLeft() != null) {
    		n = n.getLeft();
    	}
        return n.getData();
    }

    /* An add method that implements the add algorithm iteratively instead of recursively.
     * Return true if data was not present before this call to add, false otherwise.
     * pre: data != null */
    public boolean iterativeAdd(E data) {
    	// Check precondition, data must not be null
    	if(data == null) {
    		throw new IllegalArgumentException("Data is null");
    	}
    	
    	// Special cas of empty tree, manually add value to root
    	if(root == null) {
    		root = new BSTNode<E>(data);
    		size++;
    		return true;
    	}
    	
    	// Traversal node for current node and its parent
    	BSTNode<E> trav = root;
    	BSTNode<E> prev = root;
    	
    	// Traverse through tree until we get to a null spot
    	while(trav != null) {
    		// Return false once we find the data already in the tree
    		if(data.compareTo(trav.getData()) == 0) {
    			return false;
    		}
    		// Set the previous node to the current node trav
    		prev = trav;
    		// If data is less than the current node, then we go left otherwise we go right
    		trav = data.compareTo(trav.getData()) < 0? trav.getLeft(): trav.getRight();
    	}
    	// Set the child of prev to a node with data
    	if(data.compareTo(prev.getData()) < 0) {
    		prev.setLeft(new BSTNode<E>(data));
    	} else {
    		prev.setRight(new BSTNode<E>(data));
    	}
    	size++; // Increase the size
        return true;
    }

    /* Return the "kth" element in this Binary Search Tree. If kth = 0 the smallest value
     * (minimum) is returned. If kth = 1 the second smallest value is returned, and so forth.
     * pre: 0 <= kth < size() */
    public E get(int kth) {
    	// Check precondition, kth is within bounds
    	if(kth < 0 || kth >= size()) {
    		throw new IllegalArgumentException("Parameter out of bounds");
    	}
    	// Create an ArrayList to keep track of the index and access the element
    	ArrayList<E> track = new ArrayList<E>();
    	// Call helper method to traverse tree in order
    	getHelper(root, track, kth);
    	
        return track.get(kth);
    }
    
    /* Helper for get method that will traverse tree in order and stop once we are the kth spot
     * Traversal node goes to sub trees and checks the left node, then the parent, and the right node
     * to keep the order
     * @param n is a traversal node
     * @param track is an ArrayList to keep the elements with its last element the target index
     * @param target is the index element we want to return */
    private void getHelper(BSTNode<E> n, ArrayList<E> track, int target) {
    	// Method does nothing does nothing if node we are looking at is null
    	if(n != null) {
    		// Keeps traversal node going left to get to the first element of each subtree
    		getHelper(n.getLeft(), track, target);
    		
    		// Add current node that also acts as the parent node
    		track.add(n.getData());
    		
    		// Continue to the right if size of track - 1 is not equal to the target
    		// to exit the recursive method once we have the right index
    		if(track.size() - 1 != target) {
    			getHelper(n.getRight(), track, target);	
    		}
    	}
    }

    /* Return a List with all values in this Binary Search Tree that are less than value
     * value != null
     * @param value is the cutoff value */
    public List<E> getAllLessThan(E value) {
    	// Check precondition, value must not be null
    	if(value == null) {
    		throw new IllegalArgumentException("Value is null");
    	}
    	// ArrayList to hold the elements in tree less than value
    	ArrayList<E> result = new ArrayList<E>();
    	// Traverse tree in ascending order to add values
    	lessThanHelper(root, result, value);
    	
        return result;
    }

    /* Method will traverse tree in ascending order and stop once the current element is >= val
     * Traversal node goes to sub trees and checks the left node, then the parent, and the right node
     * to keep the ascending order
     * @param n is a traversal node
     * @param list is an ArrayList to keep the elements < val
     * @param val is the value we want to compare elements to */
    private void lessThanHelper(BSTNode<E> n, ArrayList<E> list, E val) {
    	// Method does nothing does nothing if node we are looking at is null
    	if(n != null) {   
    		// Keeps traversal node going left to get to the first element of each subtree
    		lessThanHelper(n.getLeft(), list, val);
    		
    		// If current node is less than val, then add to list and check the next highest element
    		if(val.compareTo(n.getData()) > 0) {
    			list.add(n.getData());
    			lessThanHelper(n.getRight(), list, val);
    		}
    	}    	
    }
    
    /* Return a List with all values in this Binary Search Tree that are greater than value
     * value != null
     * @param value is the cutoff value */
    public List<E> getAllGreaterThan(E value) {
    	// Check precondition, value must not be null
    	if(value == null) {
    		throw new IllegalArgumentException("Value is null");
    	}
    	// ArrayList to hold the elements in tree greater than value
    	ArrayList<E> result = new ArrayList<E>();
    	// Traverse tree in descending order to add values
    	greaterThanHelper(root, result, value);
    	
        return result;
    }

    /* Method will traverse tree in descending order and stop once the current element is <= val
     * Traversal node goes to sub trees and checks the right node, then the parent, and the left node
     * to keep the descending order
     * @param n is a traversal node
     * @param list is an ArrayList to keep the elements > val
     * @param val is the value we want to compare elements to */
    private void greaterThanHelper(BSTNode<E> n, ArrayList<E> list, E val) {
    	// Method does nothing does nothing if node we are looking at is null
    	if(n != null) {
    		// Keeps traversal node going left to get to the last element of each subtree
    		greaterThanHelper(n.getRight(), list, val);
    		
    		// If current node is greater than val, then add to list and check the next lowest element
    		if(val.compareTo(n.getData()) < 0) {
    			list.add(0, n.getData());
    			greaterThanHelper(n.getLeft(), list, val);
    		}
    	}    	
    }

    /* Return The number of nodes in this tree at a depth equal to the parameter d
     * pre: none
     * @param d The target depth */
    public int numNodesAtDepth(int d) {
        return depthHelper(root, d);
    }
    
    /* Returns number of nodes at depth by searching through all nodes and stopping at null object or target depth
     * @param n is traversal node 
     * @param d is target depth */
    private int depthHelper(BSTNode<E> n, int d) {
    	// Return 0 if node is null, meaning its depth is less than target
    	if(n == null) {
    		return 0;
    	}
    	// Return 1 if node is at target depth, we don't have to keep searching from this node
    	if(d == 0) {	
    		return 1;
    	}
    	// Trickle down traversal nodes in tree
    	return depthHelper(n.getLeft(), d - 1) + depthHelper(n.getRight(), d - 1);
    }

    /* Prints a vertical representation of this tree.
     * The tree has been rotated counter clockwise 90
     * degrees. The root is on the left. Each node is printed
     * out on its own row. A node's children will not necessarily
     * be at the rows directly above and below a row. They will
     * be indented three spaces from the parent. Nodes indented the
     * same amount are at the same depth. */
    public void printTree() {
        printTree(root, "");
    }

    private void printTree(BSTNode<E> n, String spaces) {
        if(n != null){
            printTree(n.getRight(), spaces + "  ");
            System.out.println(spaces + n.getData());
            printTree(n.getLeft(), spaces + "  ");
        }
    }

    private static class BSTNode<E extends Comparable<? super E>> {
        private E data;
        private BSTNode<E> left;
        private BSTNode<E> right;

        public BSTNode() {
            this(null);
        }

        public BSTNode(E initValue) {
            this(null, initValue, null); 
        }

        public BSTNode(BSTNode<E> initLeft,
                E initValue,        
                BSTNode<E> initRight) {
            data = initValue; 
            left = initLeft; 
            right = initRight; 
        }

        public E getData() { 
            return data; 
        }

        public BSTNode<E> getLeft() { 
            return left;
        }

        public BSTNode<E> getRight() { 
            return right; 
        }

        public void setData(E theNewValue) { 
            data = theNewValue; 
        }

        public void setLeft(BSTNode<E> theNewLeft) { 
            left = theNewLeft; 
        }

        public void setRight(BSTNode<E> theNewRight) { 
            right = theNewRight; 
        }    
    }
}
