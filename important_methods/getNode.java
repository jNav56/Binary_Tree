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
