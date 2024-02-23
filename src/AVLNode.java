public class AVLNode<E extends Comparable<E>> extends SearchTreeNode<E>
{
    public int height;
    public int bf;

    public AVLNode(E data)
    {
        super(data);   
        height = 1;
    }
    public AVLNode(E val, AVLNode<E> l, AVLNode<E> r) 
    {
        super(val, l, r);
        updateHeight();
    }

    public int height()
    {
        return height;
    }

    public int bf() {
        int lh = nodeHeight((AVLNode<E>)left);
        int rh = nodeHeight((AVLNode<E>)right);
        this.bf = rh - lh;
        return bf;
    }

    void updateHeight() {
        int lh = nodeHeight((AVLNode<E>)left);
        int rh = nodeHeight((AVLNode<E>)right);
        height = Math.max(lh, rh) + 1;
    }

    private int nodeHeight(AVLNode<E> node) {
        if (node == null) {
            return 0;
        } else {
            return node.height;
        }
    }
}