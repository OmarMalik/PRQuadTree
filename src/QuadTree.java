/*
 *
 */
import java.util.ArrayList;

/**
 * The Class QuadTree.
 *
 * @param <T>
 *            the generic type
 * @author Omar
 * @version 1
 */
public class QuadTree<T extends Point>
{

    /**
     * The Class InternalNode.
     *
     * @param <T>
     *            the generic type
     */
    public class InternalNode<T extends Point>
        extends QNode<T>
    {

        /** The nw. */
        QNode<T> nW;

        /** The ne. */
        QNode<T> nE;

        /** The sw. */
        QNode<T> sW;

        /** The se. */
        QNode<T> sE;

        /** The empty. */
        QNode<T> empty;


        /**
         * Instantiates a new internal node.
         *
         * @param empty0
         *            the empty0
         */
        public InternalNode(QNode<T> empty0)
        {
            nW = empty0;
            nE = empty0;
            sW = empty0;
            sE = empty0;
            empty = empty0;
        }


        // ----------------------------------------------------------
        @Override
        public T find(int x, int y, int xmin, int ymin, int xmax, int ymax)
        {
            int xmid = (xmin + xmax) / 2;
            int ymid = (ymin + ymax) / 2;

            if (x < xmid && y < ymid && x >= xmin && y >= ymin)
            {
                return nW.find(x, y, xmin, ymin, xmid, ymid);
            }
            else if (x >= xmid && y < ymid && x < xmax && y >= ymin)
            {
                return nE.find(x, y, xmid, ymin, xmax, ymid);
            }
            else if (x < xmid && y >= ymid && x >= xmin && y < ymax)
            {
                return sW.find(x, y, xmin, ymid, xmid, ymax);
            }
            else if (x >= xmid && y >= ymid && x < xmax && y < ymax)
            {
                return sE.find(x, y, xmid, ymid, xmax, ymax);
            }

            return null;
        }


        // ----------------------------------------------------------
        @Override
        public boolean insert(T data, int xmin, int ymin, int xmax, int ymax)
        {
            int x = data.x;
            int y = data.y;
            int xmid = (xmax + xmin) / 2;
            int ymid = (ymax + ymin) / 2;

            if (x < xmid && y < ymid && x >= xmin && y >= ymin)
            {
                if (nW instanceof InternalNode)
                {
                    return nW.insert(data, xmin, ymin, xmid, ymid);
                }
                else if (nW instanceof EmptyNode)
                {
                    nW = new LeafNode<T>(data);
                    return true;
                }
                else if (nW instanceof LeafNode)
                {
                    LeafNode<T> temp = new LeafNode<T>(((LeafNode<T>)nW).data);
                    if (x == temp.data.x && y == temp.data.y)
                    {
                        return false;
                    }
                    else
                    {
                        nW = new InternalNode<T>(empty);
                        nW.insert(temp.data, xmin, ymin, xmid, ymid);
                        return nW.insert(data, xmin, ymin, xmid, ymid);
                    }
                }
            }
            else if (x >= xmid && y < ymid && x < xmax && y >= ymin)
            {
                if (nE instanceof InternalNode)
                {
                    return nE.insert(data, xmid, ymin, xmax, ymid);
                }
                else if (nE instanceof EmptyNode)
                {
                    nE = new LeafNode<T>(data);
                    return true;
                }
                else if (nE instanceof LeafNode)
                {
                    LeafNode<T> temp = new LeafNode<T>(((LeafNode<T>)nE).data);
                    if (x == temp.data.x && y == temp.data.y)
                    {
                        return false;
                    }
                    else
                    {
                        nE = new InternalNode<T>(empty);
                        nE.insert(temp.data, xmid, ymin, xmax, ymid);
                        return nE.insert(data, xmid, ymin, xmax, ymid);
                    }
                }
            }

            else if (x < xmid && y >= ymid && x >= xmin && y < ymax)
            {
                if (sW instanceof InternalNode)
                {
                    return sW.insert(data, xmin, ymid, xmid, ymax);
                }
                else if (sW instanceof EmptyNode)
                {
                    sW = new LeafNode<T>(data);
                    return true;
                }
                else if (sW instanceof LeafNode)
                {
                    LeafNode<T> temp = new LeafNode<T>(((LeafNode<T>)sW).data);
                    if (x == temp.data.x && y == temp.data.y)
                    {
                        return false;
                    }
                    else
                    {
                        sW = new InternalNode<T>(empty);
                        sW.insert(temp.data, xmin, ymid, xmid, ymax);
                        return sW.insert(data, xmin, ymid, xmid, ymax);
                    }
                }
            }
            else if (x >= xmid && y >= ymid && x < xmax && y < ymax)
            {
                if (sE instanceof InternalNode)
                {
                    return sE.insert(data, xmid, ymid, xmax, ymax);
                }
                else if (sE instanceof EmptyNode)
                {
                    sE = new LeafNode<T>(data);
                    return true;
                }
                else if (sE instanceof LeafNode)
                {

                    LeafNode<T> temp = new LeafNode<T>(((LeafNode<T>)sE).data);
                    if (x == temp.data.x && y == temp.data.y)
                    {
                        return false;

                    }
                    else
                    {
                        sE = new InternalNode<T>(empty);
                        sE.insert(temp.data, xmid, ymid, xmax, ymax);
                        return sE.insert(data, xmid, ymid, xmax, ymax);
                    }
                }
            }

            return false;
        }


        // ----------------------------------------------------------
        @Override
        public void rfind(
            int x,
            int y,
            int w,
            int h,
            int xmin,
            int ymin,
            int xmax,
            int ymax)
        {
            int xmid = (xmin + xmax) / 2;
            int ymid = (ymin + ymax) / 2;
            if (x < xmid && y < ymid)
            {
                nW.rfind(x, y, w, h, xmin, ymin, xmid, ymid);
            }
            if (x + w >= xmid && y < ymid)
            {
                nE.rfind(x, y, w, h, xmid, ymin, xmax, ymid);
            }
            if (x < xmid && y + h >= ymid)
            {
                sW.rfind(x, y, w, h, xmin, ymid, xmid, ymax);
            }
            if (x + w >= xmid && x < xmax && y + h >= ymid && y < ymax)
            {
                sE.rfind(x, y, w, h, xmid, ymid, xmax, ymax);
            }
        }


        // ----------------------------------------------------------
        @Override
        public void tree(int d, int xmin, int ymin, int xmax, int ymax)
        {
            int xmid = (xmin + xmax) / 2;
            int ymid = (ymin + ymax) / 2;

            for (int k = 0; k < d; k++)
            {
                System.out.print("....");
            }
            System.out.print("Internal (" + xmid + ", " + ymid + ")" + "\n");
            nW.tree(d + 1, xmin, ymin, xmid, ymid);
            nE.tree(d + 1, xmid, ymin, xmax, ymid);
            sW.tree(d + 1, xmin, ymid, xmid, ymax);
            sE.tree(d + 1, xmid, ymid, xmax, ymax);
        }


        // ----------------------------------------------------------
        @Override
        public boolean remove(
            int x,
            int y,
            int xmin,
            int ymin,
            int xmax,
            int ymax)
        {

            int xmid = (xmax + xmin) / 2;
            int ymid = (ymax + ymin) / 2;

            if (x < xmid && y < ymid && x >= xmin && y >= ymin)
            {
                if (nW instanceof InternalNode)
                {
                    nW.remove(x, y, xmin, ymin, xmid, ymid);
                    LeafNode<T> temp = removeHelper((InternalNode<T>)nW);
                    if (temp != null)
                    {
                        nW = temp;
                    }
                }
                else if (nW instanceof EmptyNode)
                {
                    return false;
                }
                else if (nW instanceof LeafNode)
                {
                    nW = empty;
                    return true;
                }
            }
            else if (x >= xmid && y < ymid && x < xmax && y >= ymin)
            {
                if (nE instanceof InternalNode)
                {
                    nE.remove(x, y, xmid, ymin, xmax, ymid);
                    LeafNode<T> temp = removeHelper((InternalNode<T>)nE);
                    if (temp != null)
                    {
                        nE = temp;
                    }

                }
                else if (nE instanceof EmptyNode)
                {
                    return false;
                }
                else if (nE instanceof LeafNode)
                {
                    nE = empty;
                    return true;
                }
            }

            else if (x < xmid && y >= ymid && x >= xmin && y < ymax)
            {
                if (sW instanceof InternalNode)
                {
                    sW.remove(x, y, xmin, ymid, xmid, ymax);
                    LeafNode<T> temp = removeHelper((InternalNode<T>)sW);
                    if (temp != null)
                    {
                        sW = temp;
                    }

                }
                else if (sW instanceof EmptyNode)
                {
                    return false;
                }
                else if (sW instanceof LeafNode)
                {
                    sW = empty;
                    return true;
                }
            }
            else if (x >= xmid && y >= ymid && x < xmax && y < ymax)
            {
                if (sE instanceof InternalNode)
                {
                    sE.remove(x, y, xmid, ymid, xmax, ymax);
                    LeafNode<T> temp = removeHelper((InternalNode<T>)sE);
                    if (temp != null)
                    {
                        sE = temp;
                    }

                }
                else if (sE instanceof EmptyNode)
                {
                    return false;
                }
                else if (sE instanceof LeafNode)
                {
                    sE = empty;
                    return true;
                }
            }

            return true;
        }


        /**
         * Removes the helper.
         *
         * @param n
         *            the n
         * @return the leaf node
         */
        private LeafNode<T> removeHelper(InternalNode<T> n)
        {
            int count = 0;
            if (n.nW instanceof EmptyNode)
            {
                count++;
            }
            if (n.nE instanceof EmptyNode)
            {
                count++;
            }
            if (n.sW instanceof EmptyNode)
            {
                count++;
            }
            if (n.sE instanceof EmptyNode)
            {
                count++;
            }
            if (count == 3)
            {
                if (n.nW instanceof LeafNode)
                {
                    return (LeafNode<T>)n.nW;
                }
                if (n.nE instanceof LeafNode)
                {
                    return (LeafNode<T>)n.nE;
                }
                if (n.sW instanceof LeafNode)
                {
                    return (LeafNode<T>)n.sW;
                }
                if (n.sE instanceof LeafNode)
                {
                    return (LeafNode<T>)n.sE;
                }
            }
            return null;
        }
    }


    /**
     * The Class LeafNode.
     *
     * @param <T>
     *            the generic type
     */
    public class LeafNode<T extends Point>
        extends QNode
    {

        /** The data. */
        T data;


        /**
         * Instantiates a new leaf node.
         *
         * @param data0
         *            the data0
         */
        public LeafNode(T data0)
        {
            data = data0;
        }


        // ----------------------------------------------------------
        @Override
        public Point find(int x, int y, int xmin, int ymin, int xmax, int ymax)
        {
            if (x == data.x && y == data.y)
            {
                return data;
            }
            else
            {
                return null;
            }
        }


        // ----------------------------------------------------------
        @Override
        public boolean insert(Point data0, int i, int j, int i2, int j2)
        {
            return false;
        }


        // ----------------------------------------------------------
        @Override
        public void rfind(
            int x,
            int y,
            int w,
            int h,
            int xmin,
            int ymin,
            int xmax,
            int ymax)
        {
            if (data.x >= x && data.x < x + w && data.y >= y && data.y < y + h)
            {
                rfound.add(data);
            }
        }


        // ----------------------------------------------------------
        @Override
        public void tree(int d, int xmin, int ymin, int xmax, int ymax)
        {
            for (int k = 0; k < d; k++)
            {
                System.out.print("....");
            }
            System.out.print(data.toString() + "\n");
        }


        // ----------------------------------------------------------
        @Override
        public boolean remove(
            int x,
            int y,
            int xmin,
            int ymin,
            int xmax,
            int ymax)
        {
            return false;
        }
    }


    /**
     * The Class EmptyNode.
     *
     * @param <T>
     *            the generic type
     */
    public class EmptyNode<T extends Point>
        extends QNode
    {

        // ----------------------------------------------------------
        @Override
        public Point find(int x, int y, int xmin, int ymin, int xmax, int ymax)
        {
            return null;
        }


        // ----------------------------------------------------------
        @Override
        public boolean insert(Point data, int i, int j, int i2, int j2)
        {
            return true;
        }


        // ----------------------------------------------------------
        @Override
        public void rfind(
            int x,
            int y,
            int w,
            int h,
            int xmin,
            int ymin,
            int xmax,
            int ymax)
        {
            // empty.rfind does not do anything
        }


        // ----------------------------------------------------------
        @Override
        public void tree(int d, int xmin, int ymin, int xmax, int ymax)
        {
            for (int k = 0; k < d; k++)
            {
                System.out.print("....");
            }
            System.out.print("Empty\n");
        }


        // ----------------------------------------------------------
        @Override
        public boolean remove(
            int x,
            int y,
            int xmin,
            int ymin,
            int xmax,
            int ymax)
        {
            return false;
        }
    }

    /** The root. */
    QNode<T>         root;

    /** The empty. */
    QNode<T>         empty;

    /** The bound. */
    int              bound;

    /** The rfound. */
    static ArrayList rfound;


    /**
     * Instantiates a new quad tree.
     */
    public QuadTree()
    {
        empty = new EmptyNode();
        root = empty;
        bound = (int)Math.pow(2, 10);
        rfound = new ArrayList<T>();
    }


    /**
     * Insert.
     *
     * @param data
     *            the data
     * @return true, if successful
     */
    public boolean insert(T data)
    {
        if (data.x >= bound || data.y >= bound || data.x < 0 || data.y < 0)
        {
            return false;
        }
        if (root instanceof EmptyNode)
        {
            root = new LeafNode<T>(data);
            return true;
        }
        else if (root instanceof LeafNode)
        {
            LeafNode<T> temp = new LeafNode<T>(((LeafNode<T>)root).data);
            root = new InternalNode<T>(empty);
            root.insert(temp.data, 0, 0, bound, bound);
            return root.insert(data, 0, 0, bound, bound);
        }
        return root.insert(data, 0, 0, bound, bound);
    }


    /**
     * Find.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @return the t
     */
    public T find(int x, int y)
    {
        if (x >= bound || y >= bound || y < 0 || x < 0)
        {
            return null;
        }
        T found = root.find(x, y, 0, 0, bound, bound);
        return found;
    }


    /**
     * Rfind.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param w
     *            the w
     * @param h
     *            the h
     */
    public void rfind(int x, int y, int w, int h)
    {
        rfound.clear();
        root.rfind(x, y, w, h, 0, 0, bound, bound);
        if (rfound.isEmpty())
        {
            System.out.println("Not found");
        }
        else
        {
            for (Object o : rfound)
            {
                System.out.println(o.toString());
            }
        }
        rfound.clear();
    }


    /**
     * Removes the.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @return true, if successful
     */
    public boolean remove(int x, int y)
    {
        if (root instanceof LeafNode)
        {
            if (((LeafNode)root).data.x == x && ((LeafNode)root).data.y == y)
            {
                root = empty;
                return true;
            }
        }
        else if (root instanceof EmptyNode)
        {
            return false;
        }
        boolean b = root.remove(x, y, 0, 0, bound, bound);

        if (root instanceof InternalNode)
        {
            LeafNode<T> temp = removeHelper((InternalNode<T>)root);
            if (temp != null)
            {
                root = temp;
            }
        }

        return b;
    }


    /**
     * remover helper method
     *
     * @param n
     *            the n
     * @return leafnode that is there
     */
    private LeafNode<T> removeHelper(InternalNode<T> n)
    {
        int count = 0;
        if (n.nW instanceof EmptyNode)
        {
            count++;
        }
        if (n.nE instanceof EmptyNode)
        {
            count++;
        }
        if (n.sW instanceof EmptyNode)
        {
            count++;
        }
        if (n.sE instanceof EmptyNode)
        {
            count++;
        }
        if (count == 3)
        {
            if (n.nW instanceof LeafNode)
            {
                return (LeafNode<T>)n.nW;
            }
            if (n.nE instanceof LeafNode)
            {
                return (LeafNode<T>)n.nE;
            }
            if (n.sW instanceof LeafNode)
            {
                return (LeafNode<T>)n.sW;
            }
            if (n.sE instanceof LeafNode)
            {
                return (LeafNode<T>)n.sE;
            }
        }
        return null;
    }


    /**
     * Tree.
     */
    public void tree()
    {
        if (root instanceof LeafNode)
        {
            System.out.println(((LeafNode)root).data.toString());
        }
        else if (root instanceof EmptyNode)
        {
            System.out.println("Empty");
        }
        else
        {
            root.tree(0, 0, 0, bound, bound);
        }
    }


    /**
     * Makenull.
     */
    public void makenull()
    {
        root = empty;
    }

/*
 * public QNode<T> insertHelper(QNode<T> n, T toInsert, int i) { if (n
 * instanceof EmptyNode) { return new LeafNode<T>(toInsert); } if (n instanceof
 * LeafNode) { T temp = (T)((LeafNode)n).data; insertHelper(n, temp, i / 2);
 * insertHelper(n, toInsert, i / 2); return new InternalNode<T>(empty); } if (n
 * instanceof InternalNode) { int x = toInsert.x; int y = toInsert.y; if (x > i
 * / 2 && y > i / 2) { insertHelper(((InternalNode)n).SE, toInsert, i / 2); }
 * else if (x > i / 2 && y < i / 2) { insertHelper(((InternalNode)n).NE,
 * toInsert, i / 2); } else if (x < i / 2 && y > i / 2) {
 * insertHelper(((InternalNode)n).NW, toInsert, i / 2); } else if (x < i / 2 &&
 * y < i / 2) { insertHelper(((InternalNode)n).NE, toInsert, i / 2); } } return
 * null; }
 */

}
