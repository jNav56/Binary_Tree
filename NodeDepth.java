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
