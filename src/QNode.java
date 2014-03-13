// TODO: Auto-generated Javadoc
/**
 * The Class QNode.
 *
 * @author Omar
 * @version 1
 * @param <T>
 *            the generic type
 */
public abstract class QNode<T extends Point>
{

    /**
     * Find.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param xmin
     *            TODO
     * @param ymin
     *            TODO
     * @param xmax
     *            the i
     * @param ymax
     *            TODO
     * @return the t
     */
    public abstract T find(int x, int y, int xmin,
        int ymin, int xmax, int ymax);


    /**
     * Removes the.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param xmin
     *            the xmin
     * @param ymin
     *            the ymin
     * @param xmax
     *            the xmax
     * @param ymax
     *            the ymax
     * @return true, if successful
     */
    public abstract boolean remove(
        int x,
        int y,
        int xmin,
        int ymin,
        int xmax,
        int ymax);


    /**
     * Insert.
     *
     * @param data
     *            the data
     * @param xmin
     *            the xmin
     * @param ymin
     *            the ymin
     * @param xmax
     *            the xmax
     * @param ymax
     *            the ymax
     * @return true, if successful
     */
    public abstract boolean insert(
        T data,
        int xmin,
        int ymin,
        int xmax,
        int ymax);


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
     * @param xmin
     *            the xmin
     * @param ymin
     *            the ymin
     * @param xmax
     *            the xmax
     * @param ymax
     *            the ymax
     */
    public abstract void rfind(
        int x,
        int y,
        int w,
        int h,
        int xmin,
        int ymin,
        int xmax,
        int ymax);


    /**
     * Tree.
     *
     * @param d
     *            the d
     * @param xmin
     *            the xmin
     * @param ymin
     *            the ymin
     * @param xmax
     *            the xmax
     * @param ymax
     *            the ymax
     */
    public abstract void tree(int d, int xmin, int ymin, int xmax, int ymax);

}
