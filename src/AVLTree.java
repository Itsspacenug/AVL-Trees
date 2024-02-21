public class AVLTree <E extends Comparable<E>> extends SearchTree<E>{
    
    public boolean add(E data)
    {
        return insert(data);
    }

    public boolean insert(E data)
    {
        // This method should use a recursive helper.  It returns
    	// the tree that results from inserting data 
    	// into t. It has a similar structure to add from BST.  It
    	// starts by asking if tree is empty, and if so it sets the
    	// a new leaf node as the root. If tree is not empty you can compare
    	// data to the current node's data and take action based on this comparison.
    	// When you create a new leaf node you should 
		// increment the tree's size variable. When you return from a 
    	// recursive call that updates one of t's children
    	// (e.g. curr.leftChild = insertHelper(data, curr.left))
		// you should check the AVL property and possibly 
    	// call updateHeight(), and then recompute curr's height.
    	
    	if(overallRoot == null) {
    		overallRoot = new AVLNode(data);
    	}return insert((AVLNode<E>) overallRoot, data);
    }
    
    //recursive helper
    private boolean insert(AVLNode<E> node, E data) {
    	int compare = ((Comparable<E>) data).compareTo(node.data); //compares the nodes data to the data given
    		if(compare > 0) { //Search Tree down the right side
    			if(node.right == null) { //if the right pointer leads to nothing 
    				node.right = new AVLNode(data); //creates new data for that given right node
    			}else { //if it DOES lead to a node
    				if(!insert((AVLNode<E>)node.right, data)) return false; //keep traversing down the tree
    			}
    			
    		}else {//Search tree down the left side
    			if(node.left == null) { //if the left pointer leads to nothing 
    				node.left = new AVLNode(data); //creates new data for that left node
    			}else { //if it DOES lead to a node
    				if(!insert((AVLNode<E>) node.left,data)) return false; //keep traversing down the tree
    			}
    		}
    	
    	node.updateHeight(); //changes the height of the tree
		
		if(node.bf() == -2) { //if the tree is left heavy it rotates it to the right
			node = rotateRight((AVLNode<E>) node);
		}else if(node.bf() == 2) { //if the tree is right heavy it rotates it to the left
			node = rotateLeft((AVLNode<E>) node);
		}
		return true;
    	
    }

    // TODO: IMPLEMENT THE FOLLOWING METHODS BASED ON THE JAVADOC COMMENTS
  
    /**
     * Perform a single rotation to the right of a tree rooted at the current node.
     * Consider the following illustrations (called on the node A):
     *
     *        A       =>     B
     *       / \      =>    / \
     *      B   T3    =>  T1   A
     *     / \        =>      / \
     *   T1   T2      =>    T2   T3
     *
     * Note that A's original parent (if it exists) will need to become B's new
     * parent. 
     *
     * @return The new root of this subtree (node B).
     */
    public AVLNode<E> rotateRight(AVLNode<E> oldRoot) {
        // TODO: Implement this method.  Return the new root B.
        // Do not forget to change A's parent (if it exists) to be
        // aware of B as the new root by returning the new root and setting the
        // parent's pointer when we call rotateRight(node).
    	
    	
        return null;
    }

    /**
     * Perform a single rotation to the left of a tree rooted at the current node.
     * Consider the following illustrations (called on the node A):
     *
     *      A         =>       B
     *     / \        =>      / \
     *   T1   B       =>     A   T3
     *       / \      =>    / \
     *     T2   T3    =>  T1   T2
     *
     * Note that A's original parent (if it exists) will need to become B's new
     * parent. 
     *
     * @return The new root of this subtree (node B).
     */
    public AVLNode<E> rotateLeft(AVLNode<E> OldRoot) {
        // TODO: Implement this method. Return the new root B. 
        // Do not forget to change A's parent (if it exists) to be
        // aware of B as the new root by returning the new root and setting the
        // parent's pointer when we call rotateRight(node).
        return null;
    }

    // WAIT TO WORK ON THIS!!!
    public boolean remove(E data)
    {
        return false;
    }

    // This will help you with debugging. It prints the keys
   // on each level of the tree.
   public void treePrinter() {
    for (int level = 0; level < ((AVLNode<E>)overallRoot).height(); level++ ) {
        System.out.printf("Level %d: ", level);
        printLevel(level, (AVLNode<E>)overallRoot);
        System.out.println();
    }
}

    public void printLevel(int level, AVLNode<E> t) {
        if (t != null) {
            if (level == 0)
                System.out.printf(  "%s ", t.data);
            else {
                printLevel(level-1, (AVLNode<E>)t.left);
                printLevel(level-1, (AVLNode<E>)t.right);
            }
        }
    }
}
