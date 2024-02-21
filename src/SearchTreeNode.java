
public class SearchTreeNode<E extends Comparable<E>> {
	public E data; //data stored in node
	public SearchTreeNode<E> left; //left subtree
	public SearchTreeNode<E> right; //right subtree
	public SearchTreeNode<E> overallRoot;

	//constructs node with given data
		public SearchTreeNode() {
			this(null);
		}

		public SearchTreeNode(E data) {
			this(data,null, null);
			this.overallRoot = null;
		}
		public SearchTreeNode(E data, SearchTreeNode<E> left, SearchTreeNode<E> right) {
			this.data = data;
			this.right = right;
			this.left = left;
			this.overallRoot =null;
		}
		
		private SearchTreeNode<E> add(SearchTreeNode<E> root, E value) {
				if(root == null) {
					root = new SearchTreeNode<E>(value);
				}else if( ((Comparable<E>) value).compareTo(root.data) <= 0) {
					root.left = add(root.left, value);
				}else if(((Comparable<E>) value).compareTo(root.data) <= 0) {
					root.left = add(root.right, value);
				}
				return root;
		}
		
		private boolean contains(SearchTreeNode<E> root, E value) {
			if(root == null) {
				return false;
			}else {
				int compare = ((Comparable<E>) value).compareTo(root.data);
				if(compare == 0) {
					return true;
				}else if(compare<0) {
					return contains(root.left,value);
				}else {
					return contains(root.right,value);
				}
				
			}
		}
}
