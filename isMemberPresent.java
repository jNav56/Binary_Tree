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
