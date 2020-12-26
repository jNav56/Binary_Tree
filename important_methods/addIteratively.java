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
