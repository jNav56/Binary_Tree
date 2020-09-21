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
