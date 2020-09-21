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
