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
