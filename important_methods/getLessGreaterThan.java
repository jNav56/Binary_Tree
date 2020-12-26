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
