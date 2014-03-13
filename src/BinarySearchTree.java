/*
 *
 */
import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class BinarySearchTree.
 *
 * @author Omar
 * @version 1
 * @param <T>
 *            the generic type
 */
public class BinarySearchTree<T>
{

    /** The root. */
    public Node<T>       root;

    /** The comp. */
    public Comparator<T> comp;

    /** The list. */
    public ArrayList<T>  list;

    /** The sortedList. */
    public ArrayList<T>  sorted;


    // Constructors
    /**
     * Instantiates a new binary search tree.
     *
     * @param comp
     *            the comp
     */
    public BinarySearchTree(Comparator<T> comp)
    {
        root = null;
        this.comp = comp;
        this.list = new ArrayList<T>();
        this.sorted = new ArrayList<T>();
    }


    /**
     * Insert.
     *
     * @param data
     *            the data
     */
    public void insert(T data)
    {
        root = insert(root, data);
    }


    // Insert Method
    /**
     * Insert.
     *
     * @param n
     *            Node<T>
     * @param toInsert
     *            data that will be inserted
     * @return Node<T> new root
     */
    public Node<T> insert(Node<T> n, T toInsert)
    {
        if (n == null)
        {
            return new Node<T>(toInsert);
        }
        if (comp.compare(toInsert, n.data) >= 0)
        {
            if (n.right == null)
            {
                n.right = new Node<T>(toInsert);
            }
            else
            {
                insert(n.right, toInsert);
            }
            /*
             * n.numRight++; n.right = insert(n.right, n.data);
             */
        }
        else
        {
            if (n.left == null)
            {
                n.left = new Node<T>(toInsert);
                n.numLeft++;
            }
            else
            {
                n.numLeft++;
                insert(n.left, toInsert);
            }
        }
        return n;
    }


    /**
     * Find.
     *
     * @param data
     *            the data
     * @return the t
     */
    public ArrayList<T> find(T data)
    {
        list.clear();
        findRange(data, data, root);
        return list;
    }


    /*
     * public T find(Node<T> n, T toFind) { if (n == null || n.data == null) {
     * return null; } if (comp.compare(toFind, n.data) == 0) { return n.data; }
     * else if (comp.compare(toFind, n.data) > 0) { find(n.right, toFind); }
     * else { find(n.left, toFind); } return n.data; }
     */

    // findKth Method
    /**
     * Find kth.
     *
     * @param k
     *            kth element in tree
     * @return the t
     */
    public T findKth(int k)
    {
        return findKth(root, k);

    }


    /**
     * Find kth.
     *
     * @param n
     *            Node<T>
     * @param k
     *            kth element
     * @return Node<T>
     */
    private T findKth(Node<T> n, int k)
    {
        if (n == null)
        {
            return null;
        }
        if (n.numLeft > k)
        {
            return findKth(n.left, k);
        }
        else if (n.numLeft < k)
        {
            return findKth(n.right, k - n.numLeft - 1);
        }
        else
        {
            return n.data;
        }
        /*
         * if (k == n.numLeft + 1) { return n.data; } if (k > n.numLeft + 1) {
         * findKth(n.right, k - n.numLeft - 1); } else { findKth(n.left, k); }
         * return null;
         */
    }


    /**
     * Find range.
     *
     * @param min
     *            the min
     * @param max
     *            the max
     * @return the array list
     */
    public ArrayList<T> findRange(T min, T max)
    {
        list.clear();
        findRange(min, max, root);
        return list;
    }


    /**
     * Find range.
     *
     * @param min
     *            the min
     * @param max
     *            the max
     * @param n
     *            the n
     */
    public void findRange(T min, T max, Node<T> n)
    {
        if (n == null)
        {
            return;
        }
        else
        {
            if (comp.compare(min, n.data) <= 0)
            {
                findRange(min, max, n.left);
            }
            if (comp.compare(min, n.data) <= 0
                && comp.compare(max, n.data) >= 0)
            {
                list.add(n.data);
            }
            if (comp.compare(max, n.data) >= 0)
            {
                findRange(min, max, n.right);
            }
        }
    }


    // Sort Method
    /**
     * Sort.
     *
     * @return the array list
     */
    public ArrayList<T> sort()
    {
        sorted.clear();
        sortHelper(root);
        return sorted;
    }


    // Traversals
    // inOrder Traversal
    /**
     * Sort helper.
     *
     * @param n
     *            the r
     */
    private void sortHelper(Node<T> n)
    {
        if (n == null)
        {
            return;

        }
        sortHelper(n.left);
        sorted.add(n.data);
        sortHelper(n.right);

        /*
         * if (n != null) { if (n.left != null) { sortHelper(n.left); }
         * System.out.print(n.data.toString() + "\n"); if (n.right != null) {
         * sortHelper(n.right); } } else { System.out.print("Database Empty"); }
         */
    }


    // Tree Method
    /**
     * Tree.
     */
    public void tree()
    {
        treeHelper(root, 0);
    }


    /**
     * Tree helper.
     *
     * @param r
     *            Node<T>
     * @param d
     *            4*height used for indentation
     */
    private void treeHelper(Node<T> r, int d)
    {
        if (r != null)
        {
            treeHelper(r.left, d + 1);
            String s = "";
            for (int i = 0; i < d; i++)
            {
                s += "    ";
            }
            System.out.println(s + r.data.toString());
            treeHelper(r.right, d + 1);
        }
        else
        {
            if (d == 0)
            {
                System.out.println("Database Empty");
            }
        }

    }


    /**
     * DELETE ------------------------------------------------------
     * -------------------------------------------------------------
     * -------------------------------------------------------------
     * -------------------------------------------------------------
     * -------------------------------------------------------------.
     *
     * @param toDelete
     *            the to delete
     */

    public void delete(T toDelete)
    {
        root = delete(root, toDelete);
    }


    /**
     * Delete.
     *
     * @param n
     *            the p
     * @param toDelete
     *            the to delete
     * @return the node
     */
    private Node<T> delete(Node<T> n, T toDelete)
    {
        if (n == null)
        {
            return null;
        }
        T c1 = toDelete;
        T c2 = n.data;

        if (comp.compare(c1, c2) < 0)
        {
            n.numLeft--;
            n.left = delete(n.left, toDelete);
        }
        else if (comp.compare(c1, c2) > 0)
        {
            n.right = delete(n.right, toDelete);
        }
        else
        {
            if (c1 == c2)
            {
                if (n.left == null)
                {
                    return n.right;
                }
                if (n.right == null)
                {
                    return n.left;
                }
                else
                {
                    n.data = retrieveData(n.right);
                    n.right = delete(n.right, n.data);
                }
            }
            else
            {
                n.right = delete(n.right, toDelete);
            }
        }
        return n;
    }


    /**
     * Retrieve data.
     *
     * @param n
     *            the p
     * @return the t
     */
    private T retrieveData(Node<T> n)
    {
        while (n.left != null)
        {
            n = n.left;
        }

        return n.data;
    }


    /**
     * Makenull.
     */
    public void makenull()
    {
        root = null;
    }

}
