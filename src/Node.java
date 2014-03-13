// TODO: Auto-generated Javadoc
// -------------------------------------------------------------------------
/**
 * Node<T> used to populate BST.
 *
 * @author Omar
 * @version Feb 13, 2014
 * @param <T> the generic type
 */
public class Node<T>
{

    /** data. */
    public T       data;    // data for this Node<T>

    /** left node. */
    public Node<T> left;    // Pointer to left child

    /** right node. */
    public Node<T> right;   // Pointer to right child

    /** number of nodes in left subtree. */
    public int     numLeft;

    /** number of nodes in right subtree. */
    public int     numRight;


    // Constructors
    // ----------------------------------------------------------
    /**
     * Create a new Node object.
     *
     * @param data the data
     * @param l the l
     * @param r the r
     */
    public Node(T data, Node<T> l, Node<T> r)
    {
        left = l;
        right = r;
        this.data = data;
        numLeft = 0;
    }


    // ----------------------------------------------------------
    /**
     * Create a new Node object.
     *
     * @param data the data
     */
    public Node(T data)
    {
        this(data, null, null);
    }


}
