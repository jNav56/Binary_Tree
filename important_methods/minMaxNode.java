
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
